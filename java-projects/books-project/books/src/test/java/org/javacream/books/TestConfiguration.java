package org.javacream.books;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootConfiguration
@ComponentScan(basePackageClasses = BookController.class)
public class TestConfiguration {
}
