package controller;

import java.util.List;

import javax.swing.JOptionPane;

import dto.OrderDto;
import service.OrderService;
import service.impl.OrderServiceImpl;
import singleton.Singleton;
import view.OrderCompleteView;
import view.OrderConfirmView;
import view.OrderView;

public class OrderController {
	OrderService orderServ = new OrderServiceImpl();
	
	public void orderConfirm(OrderDto dto) {
		new OrderConfirmView(dto);
	}
	
	public void orderComAf(OrderDto dto, String id) {
		boolean b = orderServ.orderComplete(dto, id);
		List<OrderDto> list = orderServ.getOrderList(id);
		if(b) {
			JOptionPane.showMessageDialog(null, "주문해주셔서 감사합니다.");
			getOrderList(id);
			
		}else {
			JOptionPane.showMessageDialog(null, "주문 실패");
			orderConfirm(dto);
		}
	}
	
	public void getOrderList(String id) {
		List<OrderDto> list = orderServ.getOrderList(id);
		new OrderCompleteView(list);
	}
	
	
}
