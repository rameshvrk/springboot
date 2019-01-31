package com.panalpina.sci.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.panalpina.sci.dao.OrderDao;
import com.panalpina.sci.dto.OrderDTO;
import com.panalpina.sci.model.Order;
import com.panalpina.sci.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderDao orderDao;

	@Override
	public List<OrderDTO> getOrderDetails() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrderDTO getOrderDetails(int orderId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrderDTO updateOrderDetails(Order order, int transportId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderDTO> getOrderDetailsByStatus(String status) {
		// TODO Auto-generated method stub
		return null;
	}

}
