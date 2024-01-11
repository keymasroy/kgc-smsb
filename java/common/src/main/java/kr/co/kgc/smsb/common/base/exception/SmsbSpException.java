package kr.co.kgc.smsb.common.base.exception;

import com.gsitm.ustra.java.core.exception.ResponseCode;
import com.gsitm.ustra.java.core.exception.UstraException;

public class SmsbSpException extends UstraException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public SmsbSpException(ResponseCode code) {
		super(code);
	}
	
	public SmsbSpException(ResponseCode code, String message) {
		super(code, message);
	}
	
	public SmsbSpException(String code, String message) {
		super(code, message);
	}
	
}
