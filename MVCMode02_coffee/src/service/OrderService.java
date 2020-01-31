package service;

import java.util.List;

import dto.OrderDto;

public interface OrderService {
	
	public List<OrderDto> getOrderList(String id);
	public void orderConfirm(OrderDto dto);
	public boolean orderComplete(OrderDto dto, String id);
}
