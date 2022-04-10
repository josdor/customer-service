package com.customer.service.mapper;

import com.customer.service.dto.CustomerRequestDto;
import com.customer.service.dto.CustomerResponseDto;
import com.customer.service.entity.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.Optional;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    CustomerResponseDto customerToCustomerDto(Customer customer);
    Customer customerDtoToCustomer(CustomerRequestDto requestDto);
    Customer customerNewToCustomerOld(Customer customerNew);
}
