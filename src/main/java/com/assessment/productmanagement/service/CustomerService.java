package com.assessment.productmanagement.service;

import com.assessment.productmanagement.dto.CustomerDto;
import com.assessment.productmanagement.exception.ResourceNotFound;
import com.assessment.productmanagement.model.Customer;

public interface CustomerService {
    CustomerDto getCustomerDetail(Integer customerId) throws ResourceNotFound;
    CustomerDto save(CustomerDto customer);
}
