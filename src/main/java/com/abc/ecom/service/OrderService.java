package com.abc.ecom.service;

import java.util.List;

import com.abc.ecom.entity.Order;

public interface OrderService {

	public Order saveOrder(Order customer);
	
	public List<Order> getAllOrders() ;
	
	public Order getOrderById(int OrderId);
	
	public Order updateOrder(Order order);
	
	public void deleteOrder(int orderId);
}