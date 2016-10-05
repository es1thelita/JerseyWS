package com.sortws.webapp.util;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserServices implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -303430910425547285L;

	private Map<String, Object> servicios;
	private ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"applicationContext-service.xml"});
	public UserServices() {
		servicios = new HashMap<String, Object>();
	}

	public <T> Object getService(String nameClass) {
		Object servicio = null;

		if (servicios.containsKey(nameClass)) {
			servicio = servicios.get(nameClass);
		} else {
			servicio = getServiceInstance(nameClass);
			servicios.put(nameClass, servicio);
		}

		return servicio;
	}
	
	private <T> Object getServiceInstance(String nameClass) {
		
		return context.getBean(nameClass);
	}

}
