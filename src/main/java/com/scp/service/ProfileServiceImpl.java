package com.scp.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.scp.bean.Product;
import com.scp.entities.ProfileEntity;
import com.scp.util.SessionFactoryUtil;


public class ProfileServiceImpl implements ProfileService {

static SessionFactory sf = SessionFactoryUtil.getSessionFactory();
	
	
	
	@Override
	public ProfileEntity addProfile(ProfileEntity p) {
System.out.println("adding userprofile...");
		
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		try{
		session.saveOrUpdate(p);
		session.flush();
		tr.commit();
		return p;		}
		catch(Exception e ){
			tr.rollback();			
			throw e ;
			
		}
		finally{
			session.close();
		}
	}

	@Override
	public ProfileEntity getProfile(int profileId) {
		Session session = sf.openSession();
		System.out.println("getting profile...");
		ProfileEntity prof =session.get(ProfileEntity.class, profileId);
		System.out.println(prof +" "+profileId );
		session.close();
		return prof;
	}

	@Override
	public int deleteProfile(int profileId) {
		Session session=sf.openSession();
		Transaction tr=session.beginTransaction();
		session.delete(session.load(ProfileEntity.class,profileId));
		session.flush();
		tr.commit();
		return profileId;
		
	}

	@Override
	public ProfileEntity updateProfile(ProfileEntity p) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProfileEntity> getAllProfile() {
		Session session = sf.openSession();
		List<ProfileEntity>list=session.createCriteria(ProfileEntity.class).list();
		System.out.println("Profile List Size :"+list.size());
		return list;
		
	}

	public List<ProfileEntity> getAllFriends(int profileId)
	{
		Session session=sf.openSession();
		ProfileEntity p=getProfile(profileId);
		return p.getFriends();
	}
	

	
	
}
