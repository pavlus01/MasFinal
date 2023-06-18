package com.finalmas.app;

import com.finalmas.app.model.*;
import com.finalmas.app.model.complexFields.CarData;
import com.finalmas.app.model.complexFields.ContantData;
import com.finalmas.app.model.complexFields.PersonalData;
import com.finalmas.app.model.complexFields.PropertyAdress;
import com.finalmas.app.repository.*;
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

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

        @Bean
    public CommandLineRunner loadData(PolicyRepository repository, InsurancePackageRepository insurancePackageRepository, PackagedPolicyRepository packagedPolicyRepository, ClientRepository clientRepository, BoughtPolicyRepository boughtPolicyRepository) {
        return (args) -> {
            // save a couple of customers
            LifeInsurance lf = new LifeInsurance("Life Policy - LIFE+", "Life insurance for everybody. Don't hesitate to buy it!", LocalDate.now(), LocalDate.now().plusDays(30), 3000);
            PropertyInsurance pr = new PropertyInsurance("Small Property Insurance", "Insurance for tiny apartment in central district", LocalDate.now(), LocalDate.now().plusMonths(10), 300200, 65, new PropertyAdress("Warsaw", "Sobieskiego", "70a", "02-930"));
            VehicleInsurance vh = new VehicleInsurance("Ferrari Car Insurance", "Insurance for one and only Ferrari", LocalDate.now(), LocalDate.now().plusMonths(12), 7000, new CarData("Ferrari", "Fs40", "WE9837o", LocalDate.now().minusMonths(10)));

            repository.save(lf);
            repository.save(pr);
            repository.save(vh);
//
            InsurancePackage in1 = new InsurancePackage("Poor Paket");
//            InsurancePackage in2 = new InsurancePackage("Interestedly Paket");
//            InsurancePackage in3 = new InsurancePackage("Fantastical Paket");

//            insurancePackageRepository.save(in1);

//
//            insurancePackageRepository.save(in1);
//            insurancePackageRepository.save(in2);
//            insurancePackageRepository.save(in3);
//
            PackagedPolicy pp1 = new PackagedPolicy(LocalDate.now().minusMonths(6));
//            PackagedPolicy pp2 = new PackagedPolicy(LocalDate.now().minusMonths(3));
//            PackagedPolicy pp3 = new PackagedPolicy(LocalDate.now().plusDays(65));

//            pp1.addPackage(in1);
//            pp1.addPolicy(lf);
//            packagedPolicyRepository.save(pp1);
//
//            packagedPolicyRepository.save(pp1);
//            packagedPolicyRepository.save(pp2);
//            packagedPolicyRepository.save(pp3);

//            InsurancePackage in3 = new InsurancePackage("TESTTT");
//            repository.getReferenceById(1L);
//            packagedPolicyRepository.getReferenceById(1L).addPolicy(repository.getReferenceById(1L));
//            packagedPolicyRepository.getReferenceById(1L).addPackage(in3);
//            insurancePackageRepository.save(in3);


//            packagedPolicyRepository.save(pp1);
//            packagedPolicyRepository.save(pp2);
//            packagedPolicyRepository.save(pp3);
//            insurancePackageRepository.save(in1);
//            insurancePackageRepository.save(in2);
//            insurancePackageRepository.save(in3);
//            repository.save(lf);
//            repository.save(pr);
//            repository.save(vh);

            Client client = new Client(1, new Person(new PersonalData("user", "Reszka", LocalDate.now(), PersonalData.Gender.MALE), new ContantData("722910129", "Warsaw", "Sobieskiego", "66a", "02-999")));
            clientRepository.save(client);
//
//            BoughtPolicy boughtPolicy = new BoughtPolicy(LocalDate.now(), BoughtPolicy.Status.CREATED, client, in1);
//
//            boughtPolicyRepository.save(boughtPolicy);
//
//            log.info("Customers found with findAll():");
//            log.info("-------------------------------");
//            for (Policy customer : repository.findAll()) {
//                log.info(customer.toString());
//            }
//            log.info("");

        };
    }

}
