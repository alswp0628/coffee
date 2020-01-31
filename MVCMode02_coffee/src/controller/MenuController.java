package controller;

import java.util.List;

import dto.MenuDto;
import service.MenuService;
import service.impl.MenuServiceImpl;
import view.MenuView;
import view.OrderView;

public class MenuController {

	MenuService menuServ = new MenuServiceImpl();
	
	public void order() {
		
		List<MenuDto> list = menuServ.getMenuList();
		new OrderView(list);
	}
	
	
	public void getMenuList() {
		List<MenuDto> list = menuServ.getMenuList();
		MenuView.getInstance().menu(list);
	}
	
}
