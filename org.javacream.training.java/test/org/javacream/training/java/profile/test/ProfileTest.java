package org.javacream.training.java.profile.test;

import org.javacream.training.java.profile.api.Profile;
import org.javacream.training.java.profile.api.ProfileService;
import org.javacream.training.java.profile.impl.JpaProfileService;
import org.junit.Assert;
import org.junit.Test;

public class ProfileTest {

	@Test public void testProfileService() {
		ProfileService profileService = new JpaProfileService();
		profileService.create("Sawitzki", "hier@there.de", true);
		profileService.create("Meier", "hier@there.is", true);
		profileService.create("Mustermann", "hier@there.dk", true);
		profileService.create("Metzger", "hier@there.us", false);
		profileService.create("Hoffmann", "hier@there.it", false);
		
		
		Profile p = profileService.findByUsername("Meier");
		Assert.assertEquals("Meier",  p.getUsername());
		Assert.assertTrue(p.getActive());
		p.setActive(false);
		profileService.update(p);
		System.out.println(profileService.findActive());
		System.out.println(profileService.findInactive());
		System.out.println(profileService.findMatching("M%"));
		
	}
}
