package com.crud.repository;
  

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import com.crud.entity.Product;

  
  public interface ProductRepository extends JpaRepository<Product, Integer> {

	List<Product> findAllByuId(UUID uId);
	
	List<Product> findFirstByuIdOrderByTimestampMillisDesc(UUID uId);

	

	

	
	  

	
  }
 