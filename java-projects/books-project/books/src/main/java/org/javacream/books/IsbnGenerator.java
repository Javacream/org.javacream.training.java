
package org.javacream.books;

import org.springframework.stereotype.Service;

@Service
public class IsbnGenerator {

    private String prefix = "979";
    private String countryCode = "9";

    public String next() {
        StringBuilder isbn = new StringBuilder(prefix + countryCode);

        for (int i = 0; i < 8; i++) {
            isbn.append((int) (Math.random() * 10));
        }

        int sum = 0;

        for (int i = 0; i < 12; i++) {
            int digit = isbn.charAt(i) - '0';
            sum += digit * (i % 2 == 0 ? 1 : 3);
        }

        int checkDigit = (10 - (sum % 10)) % 10;

        return prefix + "-" + countryCode + "-"
                + isbn.substring(4, 8) + "-"
                + isbn.substring(8, 12) + "-"
                + checkDigit;
    }
}
