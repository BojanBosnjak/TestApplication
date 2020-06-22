package com.bojan.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bojan.app.entity.Customer;
import com.bojan.app.exception.ResourceNotFoundException;
import com.bojan.app.repository.CustomerRepository;
import com.bojan.pojo.CustomerModel;


@Service
public class CustomersServiceImplementation implements CustomerService {
	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public CustomerModel saveCustomer(CustomerModel customer) {
		Customer customerEntity = new Customer();
		customerEntity.setName(customer.getName());
		customerRepository.save(customerEntity);
		return toModel(customerEntity);
	}

	@Override
	public CustomerModel updateCustomer(CustomerModel customer, Integer customerId) throws ResourceNotFoundException {
		
		Optional<Customer> theCustomer = customerRepository.findById(customerId);
		if(theCustomer.isEmpty()) {
			throw new ResourceNotFoundException("Customer not found");
		}
		Customer entity = theCustomer.get();
		entity.setName(customer.getName());
		customerRepository.save(entity);
		return toModel(entity);
	}


	@Override
	public CustomerModel findById(Integer customerId) throws ResourceNotFoundException {
		Optional<Customer> customerOptional = customerRepository.findById(customerId);
		if (customerOptional.isEmpty()) {
			throw new ResourceNotFoundException("Farm not found");
		}
		return toModel(customerOptional.get());

	}

	@Override
	public List<CustomerModel> getAllCustomers() {
		List<Customer> entities = customerRepository.findAll();

		List<CustomerModel> result = new ArrayList<>();
		for (Customer customer : entities) {
			result.add(toModel(customer));
		}
		return result;
	}

	@Override
	public void deleteCustomerById(Integer customerId) {
		customerRepository.deleteById(customerId);		
	}


	private CustomerModel toModel(Customer entity) {
		CustomerModel model = new CustomerModel();
		model.setCustomerId(entity.getCustomerId());
		model.setName(entity.getName());
		return model;
	}

}
