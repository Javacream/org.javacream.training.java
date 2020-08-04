package org.javacream.training.java.profile.web;

import org.javacream.training.java.profile.api.Profile;
import org.javacream.training.java.profile.api.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProfileWebService {

	
	@Autowired private ProfileService profileService;

	//http://localhost:9099/api/profile/<Sawitzki> GET
	@GetMapping(path = "api/profile/{username}")
	public Profile findByUsername(@PathVariable("username") String username) {
		return profileService.findByUsername(username);
	}
}
