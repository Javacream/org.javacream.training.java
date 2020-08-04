package org.javacream.training.java.profile.api;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Profiles")

public class Profile {
	public void setActive(Boolean active) {
		this.active = active;
	}
	@SuppressWarnings("unused")
	private Profile() {}
	@Id
	private String username;
	private String email;
	private Boolean active;
	public Profile(String username, String email, Boolean active) {
		super();
		this.username = username;
		this.email = email;
		this.active= active;
	}
	public String getUsername() {
		return username;
	}
	public String getEmail() {
		return email;
	}
	public Boolean getActive() {
		return active;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((active == null) ? 0 : active.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Profile other = (Profile) obj;
		if (active == null) {
			if (other.active != null)
				return false;
		} else if (!active.equals(other.active))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Profile [username=" + username + ", password=" + email + ", active=" + active + "]";
	}
}
