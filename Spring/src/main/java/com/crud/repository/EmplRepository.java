package com.crud.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.crud.entity.Employee;
import com.crud.entity.Product;

public interface EmplRepository extends MongoRepository<Employee, Integer> {

	

	List<Employee> findAllByuId(UUID uId);

	List<Employee> findFirstByuIdOrderByTimestampMillisDesc(UUID uId);

}
