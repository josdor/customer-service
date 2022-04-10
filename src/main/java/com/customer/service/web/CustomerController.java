package com.customer.service.web;

import com.customer.service.dto.CustomerRequestDto;
import com.customer.service.dto.CustomerResponseDto;
import com.customer.service.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerController {

    private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/customers/{id}")
    public ResponseEntity<CustomerResponseDto> getCustustomer(@PathVariable (value = "id") String id) {
        return new ResponseEntity<>(customerService.getCustomer(id), HttpStatus.OK);
    }

    @GetMapping("/customers")
    public ResponseEntity<List<CustomerResponseDto>> getListCustomers() {
        return new ResponseEntity<>(customerService.getList(), HttpStatus.OK);
    }


    @PostMapping("/customers")
    public ResponseEntity<CustomerResponseDto> createCustomer(@RequestBody CustomerRequestDto customerRequestDto) {
        return new ResponseEntity<>(customerService.save(customerRequestDto), HttpStatus.CREATED);
    }


}
