package org.javacream.people;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
public class PeopleTestSequence {
	@Autowired private PeopleRepository peopleRepository;
	
	@Test public void testSequence() {
		var p1 = new Person(1l, "Musterfrau", "Hannah");
		peopleRepository.save(p1);
		var savedPeople = peopleRepository.findAll();
		Assertions.assertEquals(1, savedPeople.size());
		System.out.println(savedPeople);
		var p2 = new Person(2l, "Mustermann", "Hugo");
		peopleRepository.save(p2);
		savedPeople = peopleRepository.findAll();
		Assertions.assertEquals(2, savedPeople.size());
		System.out.println(peopleRepository.findById(2l));
		peopleRepository.deleteById(1l);
		Assertions.assertEquals(1, peopleRepository.findAll().size());
		
	}

}
