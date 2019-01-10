package com.scp.service;

import java.util.List;

import com.scp.bean.Product;
import com.scp.entities.ProfileEntity;


public interface ProfileService {
	public ProfileEntity addProfile(ProfileEntity p);
	public ProfileEntity getProfile(int profileid);
	public int deleteProfile(int profileId);
	public ProfileEntity updateProfile(ProfileEntity p);
	public List<ProfileEntity> getAllProfile();
	public List<ProfileEntity> getAllFriends(int profileId);
	
}
