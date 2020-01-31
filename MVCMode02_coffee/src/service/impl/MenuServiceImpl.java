package service.impl;

import java.util.List;

import dao.MenuDao;
import dao.impl.MenuDaoImpl;
import dto.MenuDto;
import service.MenuService;

public class MenuServiceImpl implements MenuService {
	
	MenuDao dao = new MenuDaoImpl();
	
	public List<MenuDto> getMenuList() {
		return dao.getMenuList();
	}
	
}
