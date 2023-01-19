package com.assessment.productmanagement.controller;

import com.assessment.productmanagement.dto.CustomerDto;
import com.assessment.productmanagement.exception.ResourceNotFound;
import com.assessment.productmanagement.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("/{customer_id}")
    public ResponseEntity<CustomerDto> getCustomerById(@PathVariable(name = "customer_id") Integer customerId) throws ResourceNotFound {
        return ResponseEntity.ok(customerService.getCustomerDetail(customerId));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CustomerDto> createCustomer(@RequestBody CustomerDto customer) {
        return new ResponseEntity<>(customerService.save(customer), HttpStatus.CREATED);
    }
}
