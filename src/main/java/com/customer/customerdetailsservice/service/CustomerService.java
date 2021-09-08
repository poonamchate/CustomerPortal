package com.customer.customerdetailsservice.service;

import com.customer.customerdetailsservice.dao.entity.Customer;
import com.customer.customerdetailsservice.dao.repository.AddressRepository;
import com.customer.customerdetailsservice.dao.repository.CustomerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    private final AddressRepository addressRepository;

    public CustomerService(final CustomerRepository customerRepository, AddressRepository addressRepository ){
        this.customerRepository = customerRepository ;
        this.addressRepository = addressRepository;
    }

    @Transactional
    public Customer createCustomer(final String firstName, final String lastName, final String email, final String phoneNumber) {
        final Customer customer = new Customer();
        customer.setFirstName(firstName);
        customer.setCustomerId(3);
        customer.setLastName(lastName);
        customer.setEmailId(email);
        customer.setPhoneNumber(phoneNumber);
        customer.setCreation_date(LocalDate.now());
        return this.customerRepository.save(customer);
    }

    @Transactional(readOnly = true)
    public List<Customer> getCustomerDetails(final int count) {
        return this.customerRepository.findAll().stream().limit(count).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public Optional<Customer> getCustomerDetailsById(final int id) {

        return this.customerRepository.findById(id);
    }
}
