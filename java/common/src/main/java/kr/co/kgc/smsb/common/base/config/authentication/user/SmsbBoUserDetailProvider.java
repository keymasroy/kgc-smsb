package kr.co.kgc.smsb.common.base.config.authentication.user;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;

import com.gsitm.ustra.java.management.authentication.ManagementGrantedAuthority;
import com.gsitm.ustra.java.management.exception.UstraManagementResponseCode;
import com.gsitm.ustra.java.management.models.UstraAuthorityGroupModel;
import com.gsitm.ustra.java.management.models.UstraUserModel;
import com.gsitm.ustra.java.management.services.UstraAuthorityGroupService;
import com.gsitm.ustra.java.management.services.UstraAuthorityService;
import com.gsitm.ustra.java.management.services.UstraUserService;
import com.gsitm.ustra.java.security.authentication.cache.SecurityCacheSupport;
import com.gsitm.ustra.java.security.authentication.request.token.UstraAuthenticationRequestToken;
import com.gsitm.ustra.java.security.authentication.user.UstraAnonymousUser;
import com.gsitm.ustra.java.security.authentication.user.UstraCachedUserDetailProvider;
import com.gsitm.ustra.java.security.authentication.user.UstraUser;
import com.gsitm.ustra.java.security.exception.UstraSecurityAuthenticationException;
import com.gsitm.ustra.java.security.jwt.authentication.authentication.UstraJwtAuthentication;

import kr.co.kgc.smsb.common.base.config.authentication.permission.Permissions;

/**
 * BO ����� ��ȸ ó��
 * @author RoyLee
 *
 */
public class SmsbBoUserDetailProvider<U extends UstraUser> extends UstraCachedUserDetailProvider<UstraAuthenticationRequestToken, UstraJwtAuthentication, U> {

	@Autowired(required=false) private UstraUserService userService;
	@Autowired(required=false) private UstraAuthorityGroupService authorityGroupService;
	@Autowired(required=false) private UstraAuthorityService authorityService;
//	@Autowired private SuppcPsnAuthenticationMapper suppcPsnAuthenticationMapper;



	public SmsbBoUserDetailProvider(Class<U> userClazz) {
		super(userClazz);
	}


	@Override
	protected UstraUser getInternalUserDetails(UstraAuthenticationRequestToken authenticationRequestToken) {
		return this.getUser(authenticationRequestToken.getUserName(), "10,20");
	}

	@Override
	protected UstraUser getInternalUserDetails(UstraJwtAuthentication authentication) {
		if (authentication == null) {
			return new UstraAnonymousUser(new ArrayList<>());
		}

		if (authentication instanceof UstraJwtAuthentication) {
			UstraJwtAuthentication jwtAuthentication = (UstraJwtAuthentication)authentication;

			if (jwtAuthentication.getClaims() == null ||
					StringUtils.isEmpty(jwtAuthentication.getClaims().getSubject())) {
				return new UstraAnonymousUser(new ArrayList<>());
			}
		}

		if (authentication.isAnonymous()) {
			return new UstraAnonymousUser(new ArrayList<>());
		}


		return this.getUser(authentication.getName(), "10,20");
	}

	@Override
	protected Cache getCache() {
		return SecurityCacheSupport.getDefaultUserCache();
	}


	/**
	 * ����� ���� ��ȸ
	 * @param userName ����� Ű ��
	 * @param useDvCds ��� ���� ��� (10: ��������������, 20:���ΰ�����, 30:���޻�)
	 * @return ��ȸ ����� ����
	 */
	protected UstraUser getUser(String userName, String useDvCds) {

		UstraUserModel user = userService.getUser(userName);
//		SuppcPsnUserModel suppcUser = suppcPsnAuthenticationMapper.selectUser(userName);

		if (user == null /*|| suppcUser == null*/) {
			return null;
		}

		// ��� ������ �ƴ� ���, ó��
		if (!StringUtils.contains(useDvCds, user.getUseDvCd())) {
			return null;
		}

		// �̽��� �ÿ��� �α��� �Ұ�
		if (!"Y".equals(user.getApvCmplYn())) {
			throw UstraSecurityAuthenticationException.from(UstraManagementResponseCode.BEFORE_APPROVAL_USER);
		}

		boolean isPrivacyInfoManager = "10".equals(user.getUseDvCd());

		if (!isPrivacyInfoManager) {
			// ������� ���� �׷� ��� ��ȸ
			List<UstraAuthorityGroupModel> groups = authorityGroupService.getAvailableGroupsOfUser(user.getUsrId());
			isPrivacyInfoManager = groups.stream().anyMatch(gr -> "Y".equals(gr.getPrvTrtYn()));
		}

		List<ManagementGrantedAuthority> userAuthorites = authorityService.getAllUserAuthorites(user.getUsrId());

		boolean isEnabled = this.isEnabledUser(user);
		boolean isNonExpiredUser = this.isNonExpiredUser(user);
		boolean isCredentialsNonExpiredUser = this.isCredentialsNonExpiredUser(user);
		boolean isAccountNonLockedUser = this.isAccountNonLockedUser(user);

		if (!isEnabled) {
			return null;
		}

		if (!isEnabled || !isNonExpiredUser || !isCredentialsNonExpiredUser || !isAccountNonLockedUser) {
			userAuthorites.clear();
		}

		// ���޻�
		if ("30".equals(useDvCds)) {

//			if ("Y".equals(suppcUser.getMstYn())) {
//				userAuthorites.add(ManagementGrantedAuthority.fromRole(Permissions.ROLE_MASTER));
//			}


			SmsbBoUser userDetail = new SmsbBoUser(
					user.getUsrId(),
					user.getPwd(),
					isEnabled,
					isNonExpiredUser,
					isCredentialsNonExpiredUser,
					isAccountNonLockedUser,
					userAuthorites);

//			String pwdExprDate = StringUtils.defaultString(suppcUser.getPwdExprDd(), LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd")));
//			long durationDate = ChronoUnit.DAYS.between(LocalDate.parse(pwdExprDate, DateTimeFormatter.ofPattern("yyyyMMdd")), LocalDate.now());

			userDetail.setDeptNm(user.getDeptNm());
			userDetail.setDisplayName(user.getUsrNm());
			userDetail.setUserId(user.getUsrId());
//			userDetail.setRequiredChangePassword(durationDate >= 0);
			userDetail.setLoginFailCnt(user.getLoginFailCnt());
			userDetail.setResetPassword("Y".equals(user.getPwdResetYn()));

//			userDetail.setSuppcCd(suppcUser.getSuppcCd());
//			userDetail.setSuppcNm(suppcUser.getSuppcNm());
//			userDetail.setRankNm(suppcUser.getRankNm());
//			userDetail.setMaster("Y".equals(suppcUser.getMstYn()));
//			userDetail.setMobileNo(user.getCphNo());
//			userDetail.setEmail(user.getEmail());

			return userDetail;
		} else {
			SmsbBoUser userDetail = new SmsbBoUser(
					user.getUsrId(),
					user.getPwd(),
					isEnabled,
					isNonExpiredUser,
					isCredentialsNonExpiredUser,
					isAccountNonLockedUser,
					userAuthorites);

			userDetail.setDeptNm(user.getDeptNm());
			userDetail.setDisplayName(user.getUsrNm());
			userDetail.setUserId(user.getUsrId());
			userDetail.setPrivacyInfoManager(isPrivacyInfoManager);
			userDetail.setLoginFailCnt(user.getLoginFailCnt());
			userDetail.setResetPassword("Y".equals(user.getPwdResetYn()));

//			userDetail.setSuppcCd(suppcUser.getSuppcCd());
//			userDetail.setSuppcNm(suppcUser.getSuppcNm());
//			userDetail.setRankNm(suppcUser.getRankNm());

			return userDetail;
		}


	}

	/**
	 * Ȱ��ȭ �� ��������� üũ
	 *
	 * @param user
	 * @return
	 */
	protected boolean isEnabledUser(final UstraUserModel user) {

		// Ż�� �ƴ� ���� Ȱ��ȭ
		return !"02".equals(user.getUsrSttCd());
	}

	/**
	 * ������� ���� ��������� üũ
	 *
	 * @param user
	 * @return
	 */
	protected boolean isNonExpiredUser(final UstraUserModel user) {

		// ��� �Ⱓ üũ
		String currentDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));

		if (StringUtils.isNotEmpty(user.getUseSrtDt())) {
			if (user.getUseSrtDt().compareTo(currentDate) > 0) {
				return false;
			}
		}

		if (StringUtils.isNotEmpty(user.getUseEndDt())) {
			if (user.getUseEndDt().compareTo(currentDate) < 0) {
				return false;
			}
		}

		return !"03".equals(user.getUsrSttCd());
	}

	/**
	 * �н����尡 ������� ���� ��������� Ȯ��
	 *
	 * @param user
	 * @return
	 */
	protected boolean isCredentialsNonExpiredUser(final UstraUserModel user) {
		return "N".equals(user.getPwdResetYn());
	}

	/**
	 * ������ ������� ���� ��������� Ȯ��
	 *
	 * @param user
	 * @return
	 */
	protected boolean isAccountNonLockedUser(final UstraUserModel user) {
		return !"04".equals(user.getUsrSttCd());
	}


}
