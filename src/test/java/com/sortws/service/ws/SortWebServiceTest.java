package com.sortws.service.ws;

import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertEquals;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;

import com.sortws.model.entity.Information;
import com.sortws.service.ws.impl.SortWebServiceImpl;

public class SortWebServiceTest extends JerseyTest{

	@Override
	protected Application configure() {

		return new ResourceConfig(SortWebServiceImpl.class);
	}

	//@Before and/or @After for db preparing etc. - if you want integration tests

	@Test
	public void postSortListTest() {
	    Information info = new Information();
	    info.setName("My List");
	    info.setNumberList("9,7,1,5");
	    
	    Response response = target("/services/sortList")
	            .request()
	            .post(Entity.entity(info, MediaType.APPLICATION_JSON));
	    assertEquals("Should return status 200", 200, response.getStatus());
        assertNotNull("Should return information", response.getEntity());
	}
}
