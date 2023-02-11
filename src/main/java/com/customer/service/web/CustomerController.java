package com.customer.service.web;

import com.customer.service.dto.CustomerRequestDto;
import com.customer.service.dto.CustomerResponseDto;
import com.customer.service.service.CustomerService;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerController {
	
	private static Logger LOG = LogManager.getLogger(CustomerController.class);
	
    private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/customers/{id}")
    public ResponseEntity<CustomerResponseDto> getCustustomer(@PathVariable (value = "id") String id) {
    	LOG.info("obtenir un client by id : {}", id);
        return new ResponseEntity<>(customerService.getCustomer(id), HttpStatus.OK);
    }

    @GetMapping("/customers")
    public ResponseEntity<List<CustomerResponseDto>> getListCustomers() {
    	LOG.info("obtenir la liste de tous les clients");
        return new ResponseEntity<>(customerService.getList(), HttpStatus.OK);
    }


    @PostMapping("/customers")
    public ResponseEntity<CustomerResponseDto> createCustomer(@RequestBody CustomerRequestDto customerRequestDto) {
        return new ResponseEntity<>(customerService.save(customerRequestDto), HttpStatus.CREATED);
    }


}
