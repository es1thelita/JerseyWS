package com.sortws.model.exception.ws;

/**
 * 
 * @author begt
 * 
 */
public class WSException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6182590193258507328L;

	int code;
	String link;
	String message;
	
	/**
	 *
	 * @param code
	 * @param developerMessage
	 * @param link
	 */
	public WSException(int code, String message, String link) {
		super(message);
		this.code = code;
		this.message = message;
		this.link = link;
	}
	
	public int getCode() {
		return code;
	}
	
	public void setCode(int code) {
		this.code = code;
	}
	
	public String getLink() {
		return link;
	}
	
	public void setLink(String link) {
		this.link = link;
	}

}
