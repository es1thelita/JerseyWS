package com.sortws.model.exception;

import java.io.Serializable;

public interface ExceptionCodes extends Serializable{
	
	/********************** ERROR WS ***********************/
	/**
	 * Error information entity
	 */
	public static final String ERR_INVALID_PARAMETER 	= "E001";
	public static final String ERR_RESULT_WEB_SERVICE 	= "E002";
	public static final String ERR_GENERAL_WEB_SERVICE 	= "E003";
	
	/**
	 * Error http
	 */
	public static final int ERR_BAD_REQUEST=400;
	
	

}
