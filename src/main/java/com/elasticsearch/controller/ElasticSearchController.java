package com.elasticsearch.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.elasticsearch.delegate.ElasticSearchCustomerDelegate;
import com.elasticsearch.model.Customer;

@RestController
@RequestMapping("/elastic")
public class ElasticSearchController {

	@Autowired
	ElasticSearchCustomerDelegate elasticSearchCustomerDelegate;

	@GetMapping("/getCustomer")
	public Optional<Customer> getCustomer(@RequestParam("id") Integer id) {
		return elasticSearchCustomerDelegate.getCustomer(id);
	}

	@GetMapping("getAllCustomers")
	public Iterable<Customer> getAllCustomers() {
		return elasticSearchCustomerDelegate.getAllCustomers();
	}

	@PostMapping("save")
	public Customer save(Customer customer) {
		return elasticSearchCustomerDelegate.save(customer);
	}

	@PostMapping("/saveAll")
	public Iterable<Customer> saveAll(Iterable<Customer> customers) {
		return elasticSearchCustomerDelegate.saveAll(customers);
	}

	@PutMapping
	public void delete(Customer customer) {
		elasticSearchCustomerDelegate.delete(customer);
	}

	@PutMapping("/delateAll")
	public void deleteAll(Iterable<Customer> customers) {
		elasticSearchCustomerDelegate.deleteAll(customers);
	}

	@PutMapping("/update")
	public Customer update(Customer customer) {
		return elasticSearchCustomerDelegate.update(customer);
	}

	@GetMapping("/getPagenatedCustomer")
	public Page<Customer> getPaginatedCustomers(@RequestParam("pageNo") Integer pageNo,
			@RequestParam("displaySizePerPage") Integer displaySizePerPage) {
		return elasticSearchCustomerDelegate.getPaginatedCustomers(pageNo, displaySizePerPage);
	}
}
