package com.sortws.model.exception.ws;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;



@Provider
public class ServiceExceptionMapper implements ExceptionMapper<WSException>{

	public Response toResponse(WSException wse) {
		return Response.status(wse.getCode())
				.entity(new ErrorMessage(wse))
				.type(MediaType.APPLICATION_JSON)
				.build();
	}
	

}
