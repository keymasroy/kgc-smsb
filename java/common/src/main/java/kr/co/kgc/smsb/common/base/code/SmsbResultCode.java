package kr.co.kgc.smsb.common.base.code;

public interface SmsbResultCode {

	/**
	 * ���� �ڵ�
	 */
	String getCode();

	/**
	 * ���� �޽���
	 */
	String getMessage();

	/**
	 * ���� ����
	 */
	default boolean isSuccess() {
		return "0000".equals(this.getCode());
	};
}