package com.abc.ecom.service;

import java.util.List;

import com.abc.ecom.entity.Customer;

public interface CustomerService {

	public Customer saveCustomer(Customer customer);
	
	public List<Customer> getAllCustomers() ;
	
	public Customer getCustomerById(int customerId);
	
	public Customer updateCustomer(Customer customer);
	
	public void deleteCustomer(int customerId);
}