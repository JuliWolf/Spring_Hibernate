package com.example.spring_hibernate_web.controller;

import com.example.spring_hibernate_web.dao.CustomerDAO;
import com.example.spring_hibernate_web.entity.Customer;
import com.example.spring_hibernate_web.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

  // need to inject our customer service
  @Autowired
  private CustomerService customerService;

  @GetMapping("/list")
  public String listCustomers(Model theModel) {

    // get customers from the customer service
    List<Customer> customers = customerService.getCustomers();

    // add the customer to the model
    theModel.addAttribute("customers", customers);

    return "list-customers";
  }

  @GetMapping("/showFormForAdd")
  public String showFormForAdd(Model model) {
    // create model attribute to bind form data
    Customer customer = new Customer();

    model.addAttribute("customer", customer);

    return "customer-form";
  }

  @PostMapping("/saveCustomer")
  public String saveCustomer(@ModelAttribute("customer") Customer customer) {
    //save the customer using service
    customerService.saveCustomer(customer);

    return "redirect:/customer/list";
  }
}
