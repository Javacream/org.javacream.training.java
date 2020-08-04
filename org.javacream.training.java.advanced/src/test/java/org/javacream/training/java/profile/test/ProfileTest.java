package org.javacream.training.java.profile.test;

import org.javacream.training.java.profile.api.Profile;
import org.javacream.training.java.profile.api.ProfileService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ProfileTest {
	@Autowired
	ProfileService profileService;

	@Test public void testProfileService() {
		profileService.create("Sawitzki", "hier@there.de", true);
		profileService.create("Meier", "hier@there.is", true);
		profileService.create("Mustermann", "hier@there.dk", true);
		profileService.create("Metzger", "hier@there.us", false);
		profileService.create("Hoffmann", "hier@there.it", false);
		
		
		Profile p = profileService.findByUsername("Meier");
		Assertions.assertEquals("Meier",  p.getUsername());
		Assertions.assertTrue(p.getActive());
		p.setActive(false);
		profileService.update(p);
		System.out.println(profileService.findActive());
		System.out.println(profileService.findInactive());
		System.out.println(profileService.findMatching("M%"));
		
	}
}
