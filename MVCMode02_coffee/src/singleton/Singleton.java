package singleton;

import controller.MemberController;
import controller.MenuController;
import controller.OrderController;

public class Singleton {
	
	private static Singleton s = null;
	
	private String loginId = null;
	
	public MemberController memCtrl = null;
	
	public MenuController menuCtrl = null;
	
	public OrderController orderCtrl = null;
	public Singleton() {
		memCtrl = new MemberController();
		menuCtrl = new MenuController();
		orderCtrl = new OrderController();
	}
	
	public static Singleton getInstace() {
		if(s == null) {
			s = new Singleton();
		}
		return s;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	
	
}

