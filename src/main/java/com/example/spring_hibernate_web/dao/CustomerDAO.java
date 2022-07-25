package com.example.spring_hibernate_web.dao;

import com.example.spring_hibernate_web.entity.Customer;
import java.util.List;

public interface CustomerDAO {

  public List<Customer> getCustomers();
}
