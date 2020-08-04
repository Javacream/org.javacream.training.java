package org.javacream.training.java.profile.api;

import java.util.List;

public interface ProfileService {

	Profile create(String username, String email, Boolean active);
	Profile findByUsername(String username);
	void update(Profile profile);
	void deleteByUsername(String username);
	List<Profile> findActive();
	List<Profile> findInactive();
	List<Profile> findMatching(String usernameFilter);
	
	
}
