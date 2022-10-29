package com.example.bookstore.controller;

import com.example.bookstore.service.CustomerService;
import com.example.bookstore.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/showNewCustomerForm")
    public String showNewCustomerForm(Model model){
        Customer customer = new Customer();
        model.addAttribute("customer", customer);
        return "new_customer";
    }

    @GetMapping("/customer")
    public String getCustomers(Model model, Customer customer){
        List<Customer> customers = customerService.getCustomers();
        model.addAttribute("customers",customers);
        return "customer";
    }

    @PostMapping("/saveCustomer")
    public String addNewCustomer(@ModelAttribute("customer") Customer customer){
        customerService.addNewCustomer(customer);
        return "redirect:/customer";
    }

    @PostMapping("/udpateCustomer")
    public String updateCustomer(@ModelAttribute("customer") Customer customer){
        customerService.updateCustomer(customer);
        return "redirect:/customer";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable ( value = "id") long id, Model model){
        Customer customer = customerService.getCustomerById(id);
        model.addAttribute("customer", customer);
        return "update_customer";
    }

    @GetMapping("/deleteCustomerWithId/{id}")
    public String deleteCustomerWithId(@PathVariable ( value = "id") long id, Model model){
        customerService.deleteCustomer(id);
        return "redirect:/customer";
    }
}
