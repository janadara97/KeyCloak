package com.vizuamatix.keycloak.controllers;

import com.vizuamatix.keycloak.payload.ApiResponse;
import com.vizuamatix.keycloak.services.CustomerService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping(value = "api/customers")
public class CustomerController {

  private static final Logger LOGGER = LoggerFactory.getLogger(CustomerController.class);

  @Autowired
  CustomerService customerService;

  @GetMapping("/getCustomers")
  public ResponseEntity<ApiResponse> getCustomers() {
    try {
      return ResponseEntity.status(HttpStatus.OK).body(customerService.getCustomers());
    } catch (Exception e) {
      e.printStackTrace();
      LOGGER.error("Failed to get customers");
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
          .body(new ApiResponse(false, "Failed to get customers"));
    }
  }
}
