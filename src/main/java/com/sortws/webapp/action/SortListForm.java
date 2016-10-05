package com.sortws.webapp.action;

import java.io.Serializable;

import com.sortws.model.entity.Information;
import com.sortws.model.exception.ExceptionCodes;
import com.sortws.model.exception.ServiceException;
import com.sortws.service.client.JerseyClient;
import com.sortws.webapp.util.UserServices;

/**
 * 
 * @author begt
 * 
 */
public class SortListForm implements Serializable{

	private static final long serialVersionUID = 1L;
	private static final String MESSAGE_ERR = "An error ocurred, please try later";
	
	private Information information;
	private Information sortInformation;
	private JerseyClient jerseyClient;
	private String messageError;
	
	public SortListForm() {
		startControllers();
		startServices();
	}
	
	protected void startControllers() {
		information = new Information();
	}
	
	protected void startServices() {
		UserServices userServices = new UserServices();
		jerseyClient = (JerseyClient) userServices.getService("jerseyClient");
	}
	
	/*
	 * Invoke the client to sort number list 
	 *  
	 * */
	public void sortList(){
		sortInformation = null;
		messageError = null;
		try {
			sortInformation = jerseyClient.getSortList(information);
		} catch(ServiceException se){
			if(se.getErrorCode().equals(ExceptionCodes.ERR_INVALID_PARAMETER))
				messageError=se.getMessage();
			else
				messageError=MESSAGE_ERR;
		}
	}
	
	/*
	 * Clean the objects used to view 
	 *  
	 * */
	public void clean(){
		information = new Information();
		sortInformation = null;
		messageError = null;
	}
	
	//Getter and Setter
	public Information getInformation() {
		return information;
	}
	
	public void setInformation(Information information) {
		this.information = information;
	}
	
	public Information getSortInformation() {
		return sortInformation;
	}
	
	public void setSortInformation(Information sortInformation) {
		this.sortInformation = sortInformation;
	}

	public String getMessageError() {
		return messageError;
	}
	
	public void setMessageError(String messageError) {
		
	}
	
}
