package com.sortws.service.client;

import java.io.Serializable;

import com.sortws.model.entity.Information;
import com.sortws.model.exception.ServiceException;

public interface JerseyClient extends Serializable{
	
	public Information getSortList(Information info)throws ServiceException;

}
