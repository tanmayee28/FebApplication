package com.scp.controller;


import java.io.IOException;

import java.util.StringTokenizer;

import javax.ws.rs.WebApplicationException;
//import javax.ws.rs.container.ContainerRequestContext;
//import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

import com.sun.jersey.spi.container.ContainerRequest;
import com.sun.jersey.spi.container.ContainerRequestFilter;

//import org.glassfish.jersey.internal.util.Base64;

/*import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.Provider;

import com.sun.jersey.core.util.Base64;
import com.sun.jersey.spi.container.ContainerRequest;
import com.sun.jersey.spi.container.ContainerRequestFilter;
import com.sun.jersey.spi.container.ContainerResponse;
import com.sun.jersey.spi.container.ContainerResponseFilter;*/
/*
@Provider
public class MyFilter implements ContainerRequestFilter {

	static {
		System.out.println("filetr loaded..");
	}

	
	public void filter(ContainerRequestContext arg0) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("Starting Authentication...");
		String s= arg0.getHeaderString ("Authorization");
		String credit=Base64.decodeAsString(s);//username:password
		System.out.println("Credentials :"+credit);
		
		
		StringTokenizer token=new StringTokenizer(":");
		String username=token.nextToken();
		String password=token.nextToken();
		
		if(username.equals("tanu") && password.equals("tanu"))
		{
			System.out.println("Authentication Success..");
		}
		else {
		
			throw new WebApplicationException(Response.status(403).build());
		}
		
		
		
	}

	@Override
	public ContainerRequest filter(ContainerRequest arg0) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	@Override
	public ContainerRequest filter(ContainerRequest request) {
	
		System.out.println("Starting Authentication...");
		String s=request.getHeaderValue("Authorization");
		String credit=Base64.base64Decode(s);//username:password
		System.out.println("Credentials :"+credit);
		
		
		StringTokenizer token=new StringTokenizer(":");
		String username=token.nextToken();
		String password=token.nextToken();
		
		if(username.equals("tanu") && password.equals("tanu"))
		{
			System.out.println("Authentication Success..");
		}
		else {
			throw new WebApplicationException(Response.status(403).build());
		}
			
		
		
		
		
		String[]unamepass=credit.split(":");
		if(unamepass[0].equals("tanu") && unamepass[1].equals("tanu"))
		{
			System.out.println("Authenticated User..");
		}
		else {
			
		}
		return null;
	}

	@Override
	public ContainerResponse filter(ContainerRequest req, ContainerResponse res) {
		// TODO Auto-generated method stub
		return null;
	}

}
*/