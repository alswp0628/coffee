package service.impl;

import java.util.List;

import dao.OrderDao;
import dao.impl.OrderDaoImpl;
import dto.OrderDto;
import service.OrderService;

public class OrderServiceImpl implements OrderService {

	OrderDao dao = new OrderDaoImpl();

	
	
	
	@Override
	public List<OrderDto> getOrderList(String id) {
		// TODO Auto-generated method stub
		return dao.getOrderList(id);
	}

	@Override
	public void orderConfirm(OrderDto dto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean orderComplete(OrderDto dto, String id) {
		// TODO Auto-generated method stub
		return dao.orderComplete(dto, id);
	}
	
	
	
}
