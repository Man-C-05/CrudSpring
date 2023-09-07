package com.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Service;

import com.crud.entity.Orders;


@Service
public class OrderService {

	private MongoTemplate mongoTemplate;

	@Autowired
	public OrderService(MongoTemplate mongoTemplate) {
		this.mongoTemplate= mongoTemplate;
	}
	
	public Orders saveOrder(Orders orders)
	{
		return mongoTemplate.save(orders);
	}
	
	public List<Orders> getOrders() 
	{
		return mongoTemplate.findAll(null);
	}
	
//	public List<Orders> getSalesByProductA() {
////        MatchOperation matchOperation = Aggregation.match(
////            Criteria.where("cName").is("doremon")
////        );
////        
////       
////
////        Aggregation aggregation = Aggregation.newAggregation(matchOperation);
////
////        return mongoTemplate.aggregate(aggregation, "orders", Orders.class).getMappedResults();
//		
//	}
	
	public List<TotalSales> getProductCount() {
        Aggregation aggregation = Aggregation.newAggregation(
            Aggregation.match(Criteria.where("cName").is("doremon")),
            Aggregation.group("cName").count().as("count")
        );

        return mongoTemplate.aggregate(aggregation, "orders", TotalSales.class).getMappedResults();
    }
}
	

