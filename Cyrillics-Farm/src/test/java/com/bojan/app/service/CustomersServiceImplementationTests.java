package com.bojan.app.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.bojan.app.entity.Customer;
import com.bojan.app.exception.ResourceNotFoundException;
import com.bojan.app.repository.CustomerRepository;
import com.bojan.pojo.CustomerModel;

import java.util.Optional;

import org.junit.Assert;

@RunWith(MockitoJUnitRunner.class)
public class CustomersServiceImplementationTests {
	@Mock
	private CustomerRepository mockRepository;

	@InjectMocks
	private CustomersServiceImplementation service;

	@Test
	public void testSaveCustomer() throws ResourceNotFoundException {
		Customer customer = new Customer();
		customer.setName("Test name");
		Mockito.when(mockRepository.save(Mockito.any())).thenReturn(customer);
		
		CustomerModel model = new CustomerModel();
		model.setName("Test name");
		CustomerModel result = service.saveCustomer(model);
		Mockito.verify(mockRepository).save(Mockito.any());
		Assert.assertEquals("Test name", result.getName());
	}
	
	@Test
	public void testUpdateCustomer() throws ResourceNotFoundException{
		Customer customer = new Customer();
		customer.setName("Test name");
		
		Mockito.when(mockRepository.save(Mockito.any())).thenReturn(customer);
		Mockito.when(mockRepository.findById(Mockito.any())).thenReturn(Optional.of(customer));
		
		CustomerModel model = new CustomerModel();
		model.setName("Test name");
		CustomerModel result = service.updateCustomer(model, 1);
		
		Mockito.verify(mockRepository).save(Mockito.any());
		Assert.assertEquals("Test name", result.getName());
	}
	
	@Test(expected=ResourceNotFoundException.class)
	public void testUpdateCustomerFail() {
		Mockito.when(mockRepository.findById(Mockito.any())).thenReturn(Optional.empty());
		CustomerModel model = new CustomerModel();
		model.setName("Test name");
		service.updateCustomer(model, 1);
	}
}
