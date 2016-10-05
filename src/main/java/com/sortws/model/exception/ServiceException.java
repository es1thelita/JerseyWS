package com.sortws.model.exception;


/**
 * 
 * @author begt
 * 
 */
public class ServiceException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5386722360669752913L;

	private String errorCode;
	
	/**
	 * @param errorCode
	 * @param message
	 * 
	 */
	public ServiceException(String errorCode, String message) {
		super(message);
		this.errorCode = errorCode;
	}
	
	/**
	 * @param errorCode
	 * @param message
	 * @param motive
	 */
	public ServiceException(String errorCode, String message, Throwable motive) {
		super(message, motive);
		this.errorCode = errorCode;
	}
	
	/**
	 * Return code exception
	 * 
	 * @return
	 */
	public String getErrorCode() {
		return errorCode;
	}

}
