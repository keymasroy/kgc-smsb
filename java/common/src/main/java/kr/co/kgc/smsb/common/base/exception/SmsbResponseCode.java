package kr.co.kgc.smsb.common.base.exception;

import com.gsitm.ustra.java.core.exception.ResponseCode;
import com.gsitm.ustra.java.core.exception.UstraCoreException;
import com.gsitm.ustra.java.core.exception.UstraException;

public enum SmsbResponseCode implements ResponseCode {

	FAILURE_SSO_LOGIN("4001", "SSO ������ �����Ͽ����ϴ�."),
	REQUIRE_TRY_SSO("4002", "SSO ���� Ȯ���� �ʿ��մϴ�."),
	INVALID_AUTHENTICATION_REQUEST_INFO("4003", "�߸��� ���� ��û �����Դϴ�."),
	CANNOT_FOUND_AUTHENTICATION_USER("4004", "��ȸ�� ����� ������ �����ϴ�."),


	HAS_ERROR_ON_DRM_CONVERSION("SY01", "DRM ���� ��ȯ �� ������ �߻��Ͽ����ϴ�. �����ڵ� : {0}"),
	INVALIDATE_PASSWORD("SY02", "��ȿ���� ���� ��й�ȣ�Դϴ�. : {0}"),

	HAS_ERROR_REGISTER_SUPPC("SC01", "���޻� ���� ��û �� ������ �߻��Ͽ����ϴ�."),
	CANNOT_FOUND_USER("SC02", "����ڸ� ã�� �� �����ϴ�."),
	CANNOT_APPROVE_USER_STATUS("SC03", "������ �� ���� ������Դϴ�."),
	CANNOT_REJECT_USER_STATUS("SC04", "������� �� ���� ������Դϴ�."),
	CANNOT_STOP_USER_STATUS("SC05", "�ߴ��� �� ���� ������Դϴ�."),
	CANNOT_AVAILABLE_USER_STATUS("SC06", "�ߴ������� �� ���� ������Դϴ�."),
	ALREADY_INITIALIZED_PASSWORD_USER("SC07", "�̹� ��й�ȣ�� �ʱ�ȭ�� ������Դϴ�."),
	CANNOT_CHANGE_MASTER_USER("SC08", "������ ����ڷ� ��ȯ�� �� �����ϴ�."),
	MUST_HAVE_MASTER_USER("SC09", "������ ����ڴ� �� �� �̻� �����ؾ� �մϴ�."),
	NOT_AVALIABLE_SET_AUTHORITY("SC10", "����ڿ��� ���� �Ұ����� ������ �Ҵ�Ǿ����ϴ�."),


	EXISTS_EMAIL("SC11", "�̹� ��� ���� �̸��� �ּ��Դϴ�. �ٸ� �̸��� �ּҸ� ����� �ֽʽÿ�."),
	EXISTS_TEL_NO("SC12", "�̹� ��� ���� ��ȭ��ȣ�Դϴ�. �ٸ� ��ȭ��ȣ�� ����� �ֽʽÿ�."),

	HAS_ERROR_REGISTER_MEMBER("CU01", "���� ��û ���� ��� �� ������ �߻��Ͽ����ϴ�."),
	HAS_ERROR_UPDATE_MEMBER("CU02", "����� ���� ���� �� ������ �߻��Ͽ����ϴ�."),
	HAS_ERROR_UPDATE_COMPANY("CU03", "ȸ���� ���� ���� �� ������ �߻��Ͽ����ϴ�."),
	CANNOT_REMOVE_MASTER_USER("CU04", "������ ����ڴ� ������ �� �����ϴ�."),
	APPLICATION_STATUS_USER("CU05", "������ ���� ��� ���Դϴ�. ���� �Ϸ� �� �̿밡���մϴ�."),
	INVALID_REFUND_BANK_ACCOUNT("CU07", "��ȿ���� ���� ȯ�Ұ��� �����Դϴ�. �� Ȯ�� �� �Է����ּ���.");


	private String code;
	private String message;

	SmsbResponseCode(String code, String message) {
		this.code = code;
		this.message = message;
	}

	@Override
	public String getCode() {
		return this.code;
	}

	@Override
	public String getMessage() {
		return this.message;
	}

	public UstraException exception() {
		return new UstraCoreException(this);
	}

	public UstraException exception(String message) {
		return new UstraCoreException(this, message);
	}
}