package com.scp.controller;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.scp.exception.ErrorCode;
import com.scp.exception.ProductNFound;


@Provider
public class ProductNotFoundException implements ExceptionMapper<ProductNFound>{


	public Response toResponse(ProductNFound ex) {
		
		// TODO Auto-generated method stub
		return Response.status(Status.BAD_REQUEST).entity(new ErrorCode("404",ex.getMessage()) ).build();
	}

}
