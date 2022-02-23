package com.abc.ecom.service;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abc.ecom.entity.Order;
import com.abc.ecom.entity.Product;
import com.abc.ecom.exception.ProductNotFoundException;
import com.abc.ecom.exception.ResourceNotFoundExcption;
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
		
		order.setOrderDate(LocalDate.now());
		
		// calcualte Order amount
		
		int productId = order.getProductId();
		
		Optional<Product> optionalProduct = productRepository.findById(productId);
		
		if(optionalProduct.isEmpty()) {
			throw new ProductNotFoundException("Product not exising with id: "+productId);
		}
		else {
			Product product = optionalProduct.get();
			double unitPrice = product.getProductPrice();
			double orderAmount = order.getQuantity() * unitPrice;
			
			order.setOrderAmount(orderAmount);
		}		
		
		Order newOrder = orderRepository.save(order);
		return newOrder;
	}

	@Override
	public Order getOrderDetails(int orderId) {
	
		Optional<Order> optionalOrder = orderRepository.findById(orderId);
		if(optionalOrder.isEmpty()) {
			throw new ResourceNotFoundExcption("Order not found with Order Id: "+orderId);
		}
		
		return optionalOrder.get();
	}

	
}