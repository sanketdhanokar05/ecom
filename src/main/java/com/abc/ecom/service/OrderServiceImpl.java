package com.abc.ecom.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abc.ecom.entity.Order;
import com.abc.ecom.exception.ResourceNotFoundException;
import com.abc.ecom.repository.OrderRepository;
import com.abc.ecom.repository.ProductRepository;

@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private ProductRepository productRepository;

	@Override
	public Order saveOrder(Order order) {
		
		Order savedOrder = orderRepository.save(order);
		
		return savedOrder;
	}

	@Override
	public List<Order> getAllOrders() {
		List<Order> order = orderRepository.findAll();
		return orders;
	}

	@Override
	public Order getOrderById(int customerId) throws ResourceNotFoundException {
		
		Optional<Order> optionalOrder = orderRepository.findById(orderId);
		
		if(optionalOrder.isEmpty()) {
			throw new ResourceNotFoundException("Sorry! Order is not existing with id: "+orderId);
		}
		return optionalOrder.get();		
	}
	
	@Override
	public Order updateOrder(Order order) {
		
		Optional<Order> optionalOrder = orderRepository.findById(order.getOrderrId());
		
		if(optionalOrder.isEmpty()) {
			throw new ResourceNotFoundException("Sorry! Order is not existing with id: "+order.getCustomerId());
		}
		
		Order updatedOrder = orderRepository.save(order);
		
		return updatedOrder;
	}

	@Override
	public void deleteOrder(int orderId) {
	
		Optional<Order> optionalOrder = orderRepository.findById(orderId);
		
		if(optionalOrder.isPresent()) {			
			customerRepository.deleteById(orderId);			
		}
		else {
			throw new ResourceNotFoundException("Sorry! Order is not existing with id: "+orderId);
		}	
	}
}