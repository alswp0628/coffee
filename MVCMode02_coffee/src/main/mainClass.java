package main;

import db.DBConnection;
import dto.OrderDto;
import singleton.Singleton;
import view.AccountView;
import view.LoginView;
import view.MenuView;
import view.OrderConfirmView;
import view.OrderView;

public class mainClass {

	public static void main(String[] args) {
		
		DBConnection.intiConnection();
		
		Singleton s = Singleton.getInstace();
		s.memCtrl.login();

		
//		new MenuView();
		
	//	new orderConfirm();
	//	new accountView();
	//	new orderView();
	}

}
