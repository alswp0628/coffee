package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBClose {

	// db 패키지만 가지고 가면 이제 편하게 할수 있음. 
	// 이코드를 계속 집어넣어 줘야해서 스테틱 함수로 만듦.
	public static void close(PreparedStatement psmt, Connection conn, ResultSet rs) {
		try {
			if (psmt != null) {
				psmt.close();
			}
			if(conn != null) {
				conn.close();
			}
			if(rs != null) {
				rs.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
