package com.elasticsearch.delegate;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.elasticsearch.model.Customer;
import com.elasticsearch.service.ElasticSearchCustomerService;

@Component
public class ElasticSearchCustomerDelegate {

	@Autowired
	ElasticSearchCustomerService elasticSearchCustomerService;

	public Optional<Customer> getCustomer(Integer id) {
		return elasticSearchCustomerService.getCustomer(id);
	}

	public Iterable<Customer> getAllCustomers() {
		return elasticSearchCustomerService.getAllCustomers();
	}

	public Customer save(Customer customer) {
		return elasticSearchCustomerService.save(customer);
	}

	public Iterable<Customer> saveAll(Iterable<Customer> customers) {
		return elasticSearchCustomerService.saveAll(customers);
	}

	public void delete(Customer customer) {
		elasticSearchCustomerService.delete(customer);
	}

	public void deleteAll(Iterable<Customer> customers) {
		elasticSearchCustomerService.deleteAll(customers);
	}

	public Customer update(Customer customer) {
		return elasticSearchCustomerService.update(customer);
	}
	
	public Page<Customer> getPaginatedCustomers(int page, int size) {
		return elasticSearchCustomerService.getPaginatedCustomers(page, size);
	}
}
