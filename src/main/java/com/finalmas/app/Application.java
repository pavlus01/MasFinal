package com.finalmas.app;

import com.finalmas.app.model.Policy;
import com.finalmas.app.repository.PolicyRepository;
import com.vaadin.flow.component.page.AppShellConfigurator;
import com.vaadin.flow.theme.Theme;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

/**
 * The entry point of the Spring Boot application.
 *
 * Use the @PWA annotation make the application installable on phones, tablets
 * and some desktop browsers.
 *
 */
@SpringBootApplication
@Theme(value = "masfinal")
public class Application implements AppShellConfigurator {

//    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

        @Bean
    public CommandLineRunner loadData(PolicyRepository repository) {
        return (args) -> {
            // save a couple of customers
            repository.save(new Policy("P1", "AAAAAA", LocalDate.now(), LocalDate.now(), 3000));
            repository.save(new Policy("P2", "BBBBBB", LocalDate.now(), LocalDate.now(), 3200));
            repository.save(new Policy("P3", "CCCCCC", LocalDate.now(), LocalDate.now(), 3300));


        };
    }

}
