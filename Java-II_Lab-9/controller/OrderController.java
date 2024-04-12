package edu.cscc.OrderApi.controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.cscc.OrderApi.model.Order;
import edu.cscc.OrderApi.model.OrderRequest;

@RestController
@RequestMapping("/v1")
public class OrderController {
	
	Map<Long, Order> orders = new HashMap<Long, Order>();
	long nextId = 0;
	
	@GetMapping("/orders")
	public ResponseEntity<Collection<Order>> getOrders() {
		return new ResponseEntity<Collection<Order>>(orders.values(), HttpStatus.OK);
	}
	
	@GetMapping("/orders/{id}")
	public ResponseEntity<Order> getOrders(@PathVariable long id) {
		if(orders.containsKey(id)) {
			return new ResponseEntity<Order>(orders.get(id), HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@PostMapping("/orders")
	public ResponseEntity<Order> postOrders(@RequestBody OrderRequest order) {
		
		nextId++;
		orders.put(nextId, new Order(nextId, order.firstName, order.lastName, order.quantity, order.price));
		
		return new ResponseEntity<Order>(orders.get(nextId), HttpStatus.CREATED);
	}
	
	@DeleteMapping("/orders/{id}")
	public ResponseEntity<Order> deleteOrders(@PathVariable long id){
		
		if(orders.containsKey(id)) {
			orders.remove(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
	}
	

}
