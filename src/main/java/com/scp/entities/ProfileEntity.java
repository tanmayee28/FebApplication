package com.scp.entities;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.Cascade;

import com.sun.research.ws.wadl.Link;

@XmlRootElement
@Entity
@Table(name="profiles")
public class ProfileEntity {
	
	@SequenceGenerator(sequenceName = "prof_seq",allocationSize=1,initialValue=0, name = "profseq")
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="profseq")
	@Id
	
	int profileId;
	String userName;
	String password;
	String actualName;
	String address;
	boolean isActive;
	
	@Transient
	List<Links>links=new ArrayList<>();
	
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	List<ProfileEntity>friends;
	
	
	
	public ProfileEntity() {
		super();
	}
	
	public ProfileEntity( String userName, String password, String actualName, String address,
			boolean isActive, List<ProfileEntity> friends) {
		super();
		this.profileId = profileId;
		this.userName = userName;
		this.password = password;
		this.actualName = actualName;
		this.address = address;
		this.isActive = isActive;
		this.friends = friends;
	}
	

	public List<Links> getLinks() {
		return links;
	}

	public void setLinks(List<Links> links) {
		this.links = links;
	}

	public int getProfileId() {
		return profileId;
	}
	public void setProfileId(int profileId) {
		this.profileId = profileId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getActualName() {
		return actualName;
	}
	public void setActualName(String actualName) {
		this.actualName = actualName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	public List<ProfileEntity> getFriends() {
		return friends;
	}
	public void setFriends(List<ProfileEntity> friends) {
		this.friends = friends;
	}
	
	
	public void addLink(String uri,String rel)
	{
		this.links.add(new Links(uri,rel));
	}
	
	

}
