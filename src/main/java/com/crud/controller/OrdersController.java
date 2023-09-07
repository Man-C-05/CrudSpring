package com.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud.entity.Orders;
import com.crud.service.OrderService;
import com.crud.service.TotalSales;



@RestController
@RequestMapping("/spring")
public class OrdersController {
	
	@Autowired
	private OrderService orderService;
	
	@GetMapping("/endpoint")
	public ResponseEntity<String> getEndpoint() {
		return ResponseEntity.ok("   *********************This is the GET response.");

	}
	
	@PostMapping("/save1")
	public Orders addOrder(@RequestBody Orders orders)
	{
//		UUID uId= Helper.generateUUID();
//		orders.setuId(uId);
//    	
//    	orders.setTimestampMillis(System.currentTimeMillis());
		return orderService.saveOrder(orders);
	}
	
	@GetMapping("/orders")
	public List<Orders> getAllOrders() 
	{
	    return orderService.getOrders();
	}
	
	 @GetMapping("/total-sales")
	 public List<TotalSales> getTotalSalesByName() 
	 {
		 return orderService.getProductCount();
	 }

}
