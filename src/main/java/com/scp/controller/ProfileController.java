package com.scp.controller;

import static org.hamcrest.CoreMatchers.sameInstance;

import java.io.File;
import java.net.URI;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.CookieParam;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.NewCookie;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.UriInfo;

import org.jboss.logging.Logger;

import com.scp.entities.Links;
import com.scp.entities.ProfileEntity;
import com.scp.service.ProfileService;
import com.scp.service.ProfileServiceImpl;


@Path("/profiles")
public class ProfileController {
	
	ProfileService profileService=new ProfileServiceImpl();
	public static Logger logger=Logger.getLogger(ProfileController.class);
	
	@Path("/{id}/friends")
	public FriendRersource getFriendResource()
	{
		
		FriendRersource resource=new FriendRersource();
		return resource;
	}
	
	@GET
	@Produces({MediaType.APPLICATION_JSON,MediaType.TEXT_XML})
	@Path("/{id}")
	public ProfileEntity getProfile(@CookieParam("mycookie")String str,@PathParam("id")int pid ,@Context UriInfo uriInfo)
	{
	
	  
		
		System.out.println("Cookie Value : "+str);
		System.out.println("Getting Profile");
		
		URI	uri =uriInfo.getBaseUriBuilder().path(ProfileController.class).path(Integer.toString(pid)).build();
		ProfileEntity pro=profileService.getProfile(pid);
		
		URI uri1=uriInfo.getBaseUriBuilder()
				.path(ProfileController.class)
				//.path(ProfileController.class,"getFriendResource")
				.path(FriendRersource.class)
				.build();
		
		
		pro.addLink(uri.toString(),"self");
		pro.addLink(uri1.toString(),"friends");
		return pro;
	}
	
	
	@GET
	@Produces({MediaType.APPLICATION_JSON,MediaType.TEXT_PLAIN})
	public List<ProfileEntity> getAllProfiles(@CookieParam("mycookie")String str ,@HeaderParam("Accept")String accept)
	{
		logger.info("Requested for all Profiles");
		System.out.println("Header Value : "+str+" Header Accept : "+accept);
		
		NewCookie cookie=new NewCookie("mycookie","Yesss Cookie");
		Response rs=Response.noContent().cookie(cookie).build();
		/*if(true)
			throw new WebApplicationException(rs);
		*/
		System.out.println("Adding and getting all Profiles");
		
		return profileService.getAllProfile();
	}
	
	
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public int deleteProfile(@PathParam("id") int pid)
	{
		System.out.println("Deleting profile");
		return profileService.deleteProfile(pid);
	}
	
	@POST
	@Produces({MediaType.APPLICATION_JSON,MediaType.TEXT_XML})
	@Consumes({MediaType.APPLICATION_JSON,MediaType.TEXT_XML})
	public ProfileEntity addProfile(ProfileEntity p)
	{
		return profileService.addProfile(p);
	}
	
	@GET
	@Produces("application/vnd.ms-excel")
	@Path("/file")
	public Response getFile()
	{
		System.out.println("Downloading File...");
		String FILE_PATH="C:\\Users\\Tanmayeee\\Desktop\\EmployeeInfo";
	    File f=new File(FILE_PATH);
	    return Response.ok(FILE_PATH).header("Content-Disposition",
				"attachment; filename=EmployeeInfo.xls").build();
	}
	
	@GET
	@Produces("application/pdf")
	@Path("/pdf")
	public Response getPDF()
	{
		System.out.println("Downloading PDF");
		String File_Path="C:\\Users\\Tanmayeee\\Desktop\\TanmayeeChinchalikar";
		return Response.ok(File_Path).header("Content-Disposition",
				"attachment; filename=TanmayeeChinchalikar.pdf").build();
	}
	
}
