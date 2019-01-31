package com.panalpina.sci.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.panalpina.sci.dto.OrderDTO;
import com.panalpina.sci.exception.ServiceException;
import com.panalpina.sci.model.Order;
import com.panalpina.sci.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private OrderService orderService;

	@GetMapping(value = "/getOrderDetails")
	public List<OrderDTO> getOrderDetails() throws ServiceException {
		try {
			return orderService.getOrderDetails();
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
	}

	@GetMapping(value = "/getOrderDetailsByStatus")
	public List<OrderDTO> getOrderDetailsByStatus(String status) throws ServiceException {
		try {
			return orderService.getOrderDetailsByStatus(status);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
	}

	@GetMapping(value = "/getOrderDetails/{orderId}")
	public OrderDTO getOrderDetails(int orderId) throws ServiceException {
		try {
			return orderService.getOrderDetails(orderId);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
	}

	@PutMapping(value = "/updateOrderDetails/{orderId}")
	public OrderDTO updateOrderDetails(@RequestBody Order order, int orderId) throws ServiceException {
		try {
			return orderService.updateOrderDetails(order, orderId);
		} catch (Exception e) {
			throw new ServiceException(e.getMessage());
		}
	}
}
