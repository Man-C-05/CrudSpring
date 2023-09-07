package com.crud.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.entity.Product;
import com.crud.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository repository;


	public Product saveProduct(Product product) {
		
		return repository.save(product);
	}

	public List<Product> saveProducts(List<Product> product) {
		return repository.saveAll(product);
	}

	public List<Product> getProducts() {
		return repository.findAll();
	}
	
	public String deleteProductById(int id) {
        repository.deleteById(id);
        return "Product is deleted "+id;
    }
	
	public Product getProductById(int id) {
        return repository.findById(id).orElse(null);
    }
	

    public Product updateProduct(UUID uId,Product updatedProduct) {
        if (updatedProduct.getId() != 0) {
            return repository.save(updatedProduct);
        }
        return null;
    }
    
    public List<Product> getProductsByUid(UUID uId) {
		return repository.findAllByuId(uId);
	}
    
    
    public List<Product> getLatestProduct(UUID uId)
    {
    	return repository.findFirstByuIdOrderByTimestampMillisDesc(uId);
    }
    	
    
    
   
}
