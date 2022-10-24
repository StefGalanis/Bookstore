package com.example.bookstore.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> getCustomers(){
        return customerRepository.findAll();
    }

    public void addNewCustomer(Customer customer) {
        Optional<Customer> customerOptional = customerRepository.findCustomerByEmail(customer.getEmail());
        if (customerOptional.isPresent()){
            throw new IllegalStateException("email taken");
        }
        customerRepository.save(customer);
    }

    public void updateCustomer(Customer customer){
        customerRepository.save(customer);
    }

    public Customer getCustomerById(Long id){
        Optional<Customer> customerOptional = customerRepository.findById(id);
        Customer customer = null;
        if(customerOptional.isPresent()){
            customer = customerOptional.get();
        }
        else{
            throw new RuntimeException(" Customer not found by id :: " + id);
        }
        return customer;
    }

    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }
}
