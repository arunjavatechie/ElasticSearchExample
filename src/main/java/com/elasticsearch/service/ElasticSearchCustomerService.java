package com.elasticsearch.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.elasticsearch.model.Customer;
import com.elasticsearch.repository.ElasticSearchCustomerRepository;

@Service
public class ElasticSearchCustomerService {

	@Autowired
	ElasticSearchCustomerRepository elasticSearchCustomerRepository;

	public Optional<Customer> getCustomer(Integer id) {
		return elasticSearchCustomerRepository.findById(id);
	}

	public Iterable<Customer> getAllCustomers() {	
		return elasticSearchCustomerRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
	}

	public Customer save(Customer customer) {
		return elasticSearchCustomerRepository.save(customer);
	}

	public Iterable<Customer> saveAll(Iterable<Customer> customers) {
		return elasticSearchCustomerRepository.saveAll(customers);
	}

	public void delete(Customer customer) {
		elasticSearchCustomerRepository.delete(customer);
	}

	public void deleteAll(Iterable<Customer> customers) {
		elasticSearchCustomerRepository.deleteAll(customers);
	}

	public Customer update(Customer customer) {
		return elasticSearchCustomerRepository.save(customer);
	}

    public Page<Customer> getPaginatedCustomers(int page, int size) {
        PageRequest pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.ASC, "id"));
        return elasticSearchCustomerRepository.findAll(pageable);
    }
    
}
