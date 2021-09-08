package com.customer.customerdetailsservice.query;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.customer.customerdetailsservice.dao.entity.Customer;
import com.customer.customerdetailsservice.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CustomerQuery implements GraphQLQueryResolver {

    @Autowired
    private CustomerService customerService;

    public List<Customer> getCustomerDetails(final int count) {
        return this.customerService.getCustomerDetails(count);
    }

    public Optional<Customer> getCustomerDetailsById(final int id) {
        return this.customerService.getCustomerDetailsById(id);
    }
}
