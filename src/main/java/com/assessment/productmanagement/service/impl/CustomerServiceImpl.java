package com.assessment.productmanagement.service.impl;

import com.assessment.productmanagement.dto.CustomerDto;
import com.assessment.productmanagement.exception.ResourceNotFound;
import com.assessment.productmanagement.model.Customer;
import com.assessment.productmanagement.repository.CustomerRepository;
import com.assessment.productmanagement.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {
    private static final Logger logger = LoggerFactory.getLogger(CustomerServiceImpl.class);

    @Autowired
    private CustomerRepository customerRepository;

    public CustomerDto getCustomerDetail(Integer customerId) throws ResourceNotFound {
        logger.info("fetching customer details for customerId :: {}", customerId);
        CustomerDto customerDto = new CustomerDto();
        Customer customer = customerRepository.findById(customerId).orElseThrow(() -> new ResourceNotFound(String.format("Customer with Id %d not found", customerId)));
        BeanUtils.copyProperties(customer, customerDto);
        return customerDto;
    }

    public CustomerDto save(CustomerDto customerDto) {
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDto, customer);
        Customer savedCustomer = customerRepository.save(customer);
        CustomerDto returnCustomerDto = new CustomerDto();
        BeanUtils.copyProperties(savedCustomer, returnCustomerDto);
        return returnCustomerDto;
    }
}
