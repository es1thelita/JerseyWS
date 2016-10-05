package com.sortws.service.client.impl;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.jackson.JacksonFeature;

import com.sortws.model.OperationConstants;
import com.sortws.model.entity.Information;
import com.sortws.model.exception.ExceptionCodes;
import com.sortws.model.exception.ServiceException;
import com.sortws.service.client.JerseyClient;

/**
 * 
 * @author begt
 * 
 */
public class JerseyClientImpl implements JerseyClient{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5903318194729400891L;
	
	private final Logger logger = Logger.getLogger(getClass());
	private static final String MESSAGE_ERR_INVALID_PARAMETER = "The information is null or incomplete";
	private static final String MESSAGE_ERR_GENERAL_WEB_SERVICE = "Error returned by web service";
	

	/*
	 * Create client and invoke the sort ws  
	 * 
	 * @param Information
	 * @return Information 
	 * @throws ServiceException
	 * */
	public Information getSortList(Information info)throws ServiceException{
		Information responseEntity = null;
			
		//Validate the information
		logger.debug("Validate the information");
		validateInformation(info);
			
		// Create Jersey client
		logger.debug("Create the client");
		ClientConfig cc = new ClientConfig().register(new JacksonFeature());
		Client client = ClientBuilder.newClient(cc);
		WebTarget target = client.target(OperationConstants.URL_WEB_SERVICE + OperationConstants.TARGET_SORT_LIST);
			
		// POST request to sortList resource
		Response post = target.request(MediaType.APPLICATION_JSON).post(Entity.json(info), Response.class); 
	        
		//Validate result ws
		if (post.getStatus() != 200) {
	       	if(post.getStatus() == 400)
	       		throw new ServiceException(ExceptionCodes.ERR_INVALID_PARAMETER, MESSAGE_ERR_INVALID_PARAMETER);
	       	logger.error("Error: "+ ExceptionCodes.ERR_GENERAL_WEB_SERVICE + " Message: " + MESSAGE_ERR_GENERAL_WEB_SERVICE);
	       	throw new ServiceException(ExceptionCodes.ERR_RESULT_WEB_SERVICE, MESSAGE_ERR_GENERAL_WEB_SERVICE);
		}

        responseEntity = post.readEntity(Information.class);
		
		return responseEntity;
	}
	
	//Validate the information
	private void validateInformation(Information information)throws ServiceException{
		if(information == null || StringUtils.isBlank(information.getName()) || StringUtils.isBlank(information.getNumberList())){
			logger.error("Error: "+ ExceptionCodes.ERR_INVALID_PARAMETER + " Message: " + MESSAGE_ERR_INVALID_PARAMETER);
			throw new ServiceException(ExceptionCodes.ERR_INVALID_PARAMETER, MESSAGE_ERR_INVALID_PARAMETER);
		}
	}
	
}
