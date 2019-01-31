package com.panalpina.sci.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.panalpina.sci.dto.OrderDTO;
import com.panalpina.sci.model.Order;

@Component
public interface OrderService {

	List<OrderDTO> getOrderDetails();

	OrderDTO getOrderDetails(int orderId);

	OrderDTO updateOrderDetails(Order order, int transportId);

	List<OrderDTO> getOrderDetailsByStatus(String status);

}
