package com.sortws.service.ws;

import com.sortws.model.entity.Information;
import com.sortws.model.exception.ws.WSException;

/**
 * 
 * @author begt
 * 
 */
public interface SortWebService {
	
	/*
	 * Sort Number List 
	 * 
	 * @param Information
	 * @return Information 
	 * @throws WSException
	 * */
	public Information postSortList(Information info)throws WSException;

}
