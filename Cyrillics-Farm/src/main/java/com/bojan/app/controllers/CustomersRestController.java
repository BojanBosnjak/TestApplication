package com.bojan.app.controllers;

import java.util.List;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.bojan.app.service.CustomerService;
import com.bojan.pojo.CustomerModel;

import javassist.NotFoundException;

@RestController

public class CustomersRestController {
	@Autowired
	private CustomerService customerService;

	@GetMapping("/customers")
	public List<CustomerModel> getAllCustomers() {
		return customerService.getAllCustomers();
	}

	@GetMapping("/customers/{customerId}")
	public CustomerModel findById(@PathVariable("customerId") Integer customerId) throws NotFoundException {
		return customerService.findById(customerId);
	}

	
	@PostMapping("/customers")
	public CustomerModel createCustomer(@Valid @RequestBody CustomerModel customer) {
		return customerService.saveCustomer(customer);
	}

	@PutMapping("/customers/{customerId}")
	public CustomerModel updateCustomer(@PathVariable Integer customerId, @Valid @RequestBody CustomerModel model)
			throws NotFoundException {
		return customerService.updateCustomer(model, customerId);

	}

	@DeleteMapping("/customers/{customerId}")
	public void deleteById(@PathVariable Integer customerId) {
		customerService.deleteCustomerById(customerId);
	}

}
