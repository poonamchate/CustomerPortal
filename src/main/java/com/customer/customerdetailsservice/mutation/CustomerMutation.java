package com.customer.customerdetailsservice.mutation;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.customer.customerdetailsservice.dao.entity.Customer;
import com.customer.customerdetailsservice.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CustomerMutation implements GraphQLMutationResolver {

    @Autowired
    private CustomerService customerService;

    public Customer createCustomer(final String firstName, final String lastName, final String email, final String phoneNumber) {
        return this.customerService.createCustomer(firstName, lastName, email, phoneNumber);
    }
}
