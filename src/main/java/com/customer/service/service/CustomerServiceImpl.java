package com.customer.service.service;

import com.customer.service.dao.CustomerRepository;
import com.customer.service.dto.CustomerRequestDto;
import com.customer.service.dto.CustomerResponseDto;
import com.customer.service.entity.Customer;
import com.customer.service.mapper.CustomerMapper;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	private static Logger LOG = LogManager.getLogger(CustomerServiceImpl.class);

    CustomerRepository customerRepository;

    CustomerMapper mapper;

    public CustomerServiceImpl(CustomerRepository customerRepository, CustomerMapper mapper) {
        this.customerRepository = customerRepository;
        this.mapper = mapper;
    }

    @Override
    public CustomerResponseDto save(CustomerRequestDto requestDto) {
    	LOG.info("Start of customer creation process ...");
        Customer customer = mapper.customerDtoToCustomer(requestDto);
        LOG.info(Optional.ofNullable(customer)
        	.map(Customer::getId)
        	.orElse("Customer ID not found"));
        
        //customer.setId(UUID.randomUUID().toString());
        LOG.info("... end of customer creation process");
        return mapper.customerToCustomerDto(customerRepository.save(customer));
    }

    @Override
    public CustomerResponseDto getCustomer(String id) {
    	LOG.info("démarrage du traiment de récupération du client ... ");
        Optional<Customer> customerOptional = customerRepository.findById(id);
    	LOG.info(" ... fin du traiment de récupération du client");
        return this.mapper.customerToCustomerDto(customerOptional.orElse(null));
    }

    @Override
    public CustomerResponseDto update(CustomerRequestDto requestDto) {
        Customer customerNew = this.mapper.customerDtoToCustomer(requestDto);
        Optional<Customer> customerOld = Optional.ofNullable(this.mapper.customerNewToCustomerOld(customerNew));

        return this.mapper.customerToCustomerDto(this.customerRepository.save(customerOld.orElse(null)));
    }

    @Override
    public List<CustomerResponseDto> getList() {
        return this.customerRepository.findAll().stream()
                .map(customer -> this.mapper.customerToCustomerDto(customer))
                .collect(Collectors.toList());
    }
}
