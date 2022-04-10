package com.customer.service;

import com.customer.service.dto.CustomerRequestDto;
import com.customer.service.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.UUID;

@SpringBootApplication
public class CustomerServiceApplication implements CommandLineRunner {

    CustomerService service;

    public CustomerServiceApplication (CustomerService service) {
        this.service = service;
    }

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        service.save(new CustomerRequestDto(UUID.randomUUID().toString(),"Jos", "jos@gamil.com"));
        service.save(new CustomerRequestDto(UUID.randomUUID().toString(), "Miora", "miora@gamil.com"));
        service.save(new CustomerRequestDto(UUID.randomUUID().toString(), "Jeremy", "jeremy@gamil.com"));
        service.save(new CustomerRequestDto(UUID.randomUUID().toString(), "Thibault", "tibo@gamil.com"));
        service.save(new CustomerRequestDto(UUID.randomUUID().toString(), "Timo", "timo@gamil.com"));
        service.save(new CustomerRequestDto(UUID.randomUUID().toString(), "Nathan", "nathan@gamil.com"));
    }
}
