package com.hibernate.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ProfileDetails")
public class Profile {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int profileId;

	private String profileName;

	private long profileContact;
	@OneToOne(mappedBy = "profile")
	private User user;

	public int getProfileId() {
		return profileId;
	}

	public void setProfileId(int profileId) {
		this.profileId = profileId;
	}

	public String getProfileName() {
		return profileName;
	}

	public void setProfileName(String profileName) {
		this.profileName = profileName;
	}

	public long getProfileContact() {
		return profileContact;
	}

	public void setProfileContact(long profileContact) {
		this.profileContact = profileContact;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Profile(int profileId, String profileName, long profileContact) {
		super();
		this.profileId = profileId;
		this.profileName = profileName;
		this.profileContact = profileContact;
	}

	public Profile(String profileName, long profileContact) {
		super();
		this.profileName = profileName;
		this.profileContact = profileContact;
	}

	public Profile() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Profile [profileId=" + profileId + ", profileName=" + profileName + ", profileContact=" + profileContact
				+ "]";
	}

}
