package com.cater.dto.beans;
// Generated Dec 24, 2015 12:22:57 AM by Hibernate Tools 4.3.1

import java.util.HashSet;
import java.util.Set;

/**
 * Caterer generated by hbm2java
 */
public class Caterer implements java.io.Serializable {

	/**
	* 
	*/
	private static final long		serialVersionUID	= 1L;
	private Long					catererId;
	private String					displayName;
	private String					name;
	private String					ownerName;
	private boolean					isDeleted;
	private String					username;
	private String					password;
	private String					otp;
	private Set<CatererLineContact>	catererLineContacts;
	private Set<CatererAddress>		catererAddresses;

	public Caterer() {
	}

	public Caterer(boolean isDeleted, String username, String password) {
		this.isDeleted = isDeleted;
		this.username = username;
		this.password = password;
	}

	public Caterer(String displayName, String name, String ownerName, boolean isDeleted, String username,
			String password, Set catererLineContacts, Set catererAddresses) {
		this.displayName = displayName;
		this.name = name;
		this.ownerName = ownerName;
		this.isDeleted = isDeleted;
		this.username = username;
		this.password = password;
		this.catererLineContacts = catererLineContacts;
		this.catererAddresses = catererAddresses;
	}

	public String getOtp() {
		return otp;
	}

	public void setOtp(String otp) {
		this.otp = otp;
	}

	public Long getCatererId() {
		return this.catererId;
	}

	public void setCatererId(Long catererId) {
		this.catererId = catererId;
	}

	public String getDisplayName() {
		return this.displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOwnerName() {
		return this.ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public boolean isIsDeleted() {
		return this.isDeleted;
	}

	public void setIsDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<CatererLineContact> getCatererLineContacts() {
		return catererLineContacts;
	}

	public void setCatererLineContacts(Set<CatererLineContact> catererLineContacts) {
		this.catererLineContacts = catererLineContacts;
	}

	public Set<CatererAddress> getCatererAddresses() {
		return catererAddresses;
	}

	public void setCatererAddresses(Set<CatererAddress> catererAddresses) {
		this.catererAddresses = catererAddresses;
	}

}
