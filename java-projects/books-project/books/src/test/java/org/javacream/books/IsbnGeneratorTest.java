
package org.javacream.books;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest(classes = TestConfiguration.class)
@ActiveProfiles("test")
public class IsbnGeneratorTest {

    @Autowired
    private IsbnGenerator generator;

    @Test
    void testFormat() {
        String isbn = generator.next();

        assertTrue(isbn.matches(
            "979-9-\\d{4}-\\d{4}-\\d"));
    }

    @Test
    void testCheckDigit() {
        String isbn = generator.next();
        String digits = isbn.replace("-", "");

        int sum = 0;

        for (int i = 0; i < 12; i++) {
            int digit = digits.charAt(i) - '0';
            sum += digit * (i % 2 == 0 ? 1 : 3);
        }

        int expectedCheckDigit = (10 - (sum % 10)) % 10;
        int actualCheckDigit = digits.charAt(12) - '0';

        assertEquals(expectedCheckDigit, actualCheckDigit);
    }
}
