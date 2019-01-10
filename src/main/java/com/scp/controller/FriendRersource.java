package com.scp.controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.scp.entities.ProfileEntity;
import com.scp.service.ProfileService;
import com.scp.service.ProfileServiceImpl;

@Path("/")
public class FriendRersource {

	ProfileService profileService=new ProfileServiceImpl();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<ProfileEntity> getFriends(@PathParam("id") int profileId)
	
	{     System.out.println("in get friends..");
		
		   /* ProfileEntity prof =      profileService.getProfile(profileId);
        	prof.getFriends().add(new ProfileEntity("neha","neha","Neha","ABC",true,null));
	
        	profileService.addProfile(prof);
        	System.out.println("profile added..");*/
		List<ProfileEntity> friends = profileService.getAllFriends(profileId);
		System.out.println("friends..size "+friends.size());
		return friends;
	}
	
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public ProfileEntity addFriend(@PathParam("id")int profileId,ProfileEntity profile)
	{
		ProfileEntity p=profileService.getProfile(profileId);
		p.getFriends().add(profile);
		return profileService.addProfile(p);
		
	}
	
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public ProfileEntity removeFriend(@PathParam("id")int profileId,ProfileEntity friend)
	{
		System.out.println("deleting friend..");
		ProfileEntity p=profileService.getProfile(profileId);
		p.getFriends().remove(friend);
		profileService.addProfile(p);
		return friend;
	}
	
}
