package com.customer.service.service;

import com.customer.service.dto.CustomerRequestDto;
import com.customer.service.dto.CustomerResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CustomerService {

    CustomerResponseDto save(CustomerRequestDto requestDto);

    CustomerResponseDto getCustomer(String id);

    CustomerResponseDto update(CustomerRequestDto requestDto);

    List<CustomerResponseDto> getList();
}
