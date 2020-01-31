package dao;

import java.util.List;

import dto.OrderDto;

public interface OrderDao {
	
	public List<OrderDto> getOrderList(String id);
	public boolean orderComplete(OrderDto dto, String id);
}
