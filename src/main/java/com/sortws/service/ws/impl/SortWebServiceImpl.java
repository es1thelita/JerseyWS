package com.sortws.service.ws.impl;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import com.sortws.model.OperationConstants;
import com.sortws.model.entity.Information;
import com.sortws.model.exception.ExceptionCodes;
import com.sortws.model.exception.ws.WSException;
import com.sortws.service.ws.SortWebService;

@Path("/services")
public class SortWebServiceImpl implements SortWebService{
	
	private final Logger logger = Logger.getLogger(getClass());
	private static final String MESSAGE_ERROR_INVALID_PARAMETER = "The information is null or incomplete";
	
	@POST
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	@Path("/sortList")
	public Information postSortList(Information info)throws WSException{
		Information result = new Information();
		
		//validate to information
		logger.debug("Validate the information");
		validateInformation(info);
		
		//Sort Number
		logger.debug("Sort list");
		List<String> valores = Arrays.asList(info.getNumberList().split(","));
		Collections.sort(valores);
		String sortList = valores.toString().replaceAll("\\[|\\]", "").replaceAll(", ",", ");
		
		//Create result
		result.setName(info.getName());
		result.setNumberList(sortList);
		return result;
	}
	
	//Validate the information
	private void validateInformation(Information information)throws WSException{
		if(information == null || StringUtils.isBlank(information.getName()) || StringUtils.isBlank(information.getNumberList())){
			logger.error("Error: "+ ExceptionCodes.ERR_INVALID_PARAMETER + " Message: " + MESSAGE_ERROR_INVALID_PARAMETER);
			throw new WSException(ExceptionCodes.ERR_BAD_REQUEST, MESSAGE_ERROR_INVALID_PARAMETER, OperationConstants.URL_WEB_SERVICE + OperationConstants.URL_WEB_SERVICE);
		}
	}
}
