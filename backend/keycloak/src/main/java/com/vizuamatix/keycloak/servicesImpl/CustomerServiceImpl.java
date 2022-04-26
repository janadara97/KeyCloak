package com.vizuamatix.keycloak.servicesImpl;

import java.util.List;

import com.vizuamatix.keycloak.models.Customer;
import com.vizuamatix.keycloak.payload.ApiResponse;
import com.vizuamatix.keycloak.repositories.CustomerRepository;
import com.vizuamatix.keycloak.services.CustomerService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

  @Autowired
  CustomerRepository customerRepository;

  private static final Logger LOGGER = LoggerFactory.getLogger(CustomerServiceImpl.class);

  @Override
  public ApiResponse getCustomers() {
    try {
      List<Customer> customers = customerRepository.findAll();
      LOGGER.info("Customers fetched successfully");
      return new ApiResponse(true, "Customers fetched successfully", customers);
    } catch (Exception e) {
      e.printStackTrace();
      LOGGER.error("Failed to load customers");
      return new ApiResponse(false, "Failed to load customers");
    }

  }

}
