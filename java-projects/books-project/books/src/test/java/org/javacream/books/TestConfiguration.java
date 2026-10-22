package org.javacream.books;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootConfiguration
@ComponentScan(basePackageClasses = BookController.class)
@EnableAutoConfiguration
@EnableJpaRepositories
public class TestConfiguration {
}
