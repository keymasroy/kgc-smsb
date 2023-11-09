package kr.co.kgc.smsb.common.base.config.authentication.user;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class SmsbBoUser extends SmsbUser {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 7647995839620972648L;


	@JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
	public SmsbBoUser(
			@JsonProperty("username") String username,
			@JsonProperty("password") String password,
			@JsonProperty("enabled") boolean enabled,
			@JsonProperty("accountNonExpired") boolean accountNonExpired,
			@JsonProperty("credentialsNonExpired") boolean credentialsNonExpired,
			@JsonProperty("accountNonLocked") boolean accountNonLocked,
			@JsonProperty("authorities") Collection<? extends GrantedAuthority> authorities) {
		super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
	}

	/**
	 * �������� ������ ����
	 */
	private boolean isPrivacyInfoManager = false;

	/**
	 * �μ� ��
	 */
	private String deptNm;

	/**
	 * ���޻� �ڵ�
	 */
	private String suppcCd;

	/**
	 * ���޻� ��
	 */
	private String suppcNm;

	/**
	 * ���� ��
	 */
	private String rankNm;
}
