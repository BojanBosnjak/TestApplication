package com.bojan.app.service;

import java.util.List;

import com.bojan.app.exception.ResourceNotFoundException;
import com.bojan.pojo.CustomerModel;


public interface CustomerService {
	CustomerModel saveCustomer(CustomerModel customer);

	void deleteCustomerById(Integer customerId);

	CustomerModel findById(Integer customerId) throws ResourceNotFoundException;

	List<CustomerModel> getAllCustomers();

	CustomerModel updateCustomer(CustomerModel customer, Integer customerId) throws ResourceNotFoundException;

}
