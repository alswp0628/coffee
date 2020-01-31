package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	
	public static void intiConnection(){
		// 이건 생성자에 넣어둔것. 
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); // 현재 우리가 사용할 클래스가 있느냐 없느냐
			
			System.out.println("Driver Loading Success!");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public static Connection getConnection() {
		
		Connection conn = null;
		
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.2.28:1521:xe", 
												"hr", "hr");
			System.out.println("DB Connection Success!"); // DB랑 완전히 연결된건 여기. 실제 연결된곳.
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return conn;
	}
	
}
