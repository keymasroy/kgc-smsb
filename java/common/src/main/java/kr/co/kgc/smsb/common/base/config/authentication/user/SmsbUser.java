package kr.co.kgc.smsb.common.base.config.authentication.user;

import java.time.LocalDateTime;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;

import com.gsitm.ustra.java.security.authentication.user.UstraUser;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public abstract class SmsbUser extends UstraUser {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -7684975026373730096L;

	protected SmsbUser(String username, String password, boolean enabled, boolean accountNonExpired,
			boolean credentialsNonExpired, boolean accountNonLocked,
			Collection<? extends GrantedAuthority> authorities) {
		super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
	}


	/**
	 * ���� ��
	 */
	private String displayName;

	/**
	 * ����� ���̵�
	 */
	private String userId;

	/**
	 * �α��� ���� ��
	 */
	private Integer loginFailCnt;

	/**
	 * �н����� �ʱ�ȭ ����
	 */
	private boolean resetPassword;

	/**
	 * �н����� ���� �ʿ� ����
	 */
	private boolean requiredChangePassword;

	/**
	 * ���� ������
	 */
	private LocalDateTime lastConnectedDttm;

	/**
	 * ���� ���� ������
	 */
	private String lastConnIp;

}
