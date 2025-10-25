package com.elasticsearch.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.data.elasticsearch.repository.config.EnableReactiveElasticsearchRepositories;
import org.springframework.stereotype.Component;

import com.elasticsearch.model.Customer;

@Component
@EnableReactiveElasticsearchRepositories
public interface ElasticSearchCustomerRepository extends ElasticsearchRepository<Customer, Integer> {

}
