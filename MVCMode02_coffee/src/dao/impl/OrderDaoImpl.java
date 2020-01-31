package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.OrderDao;
import db.DBClose;
import db.DBConnection;
import dto.OrderDto;

public class OrderDaoImpl implements OrderDao{
	
	
	public OrderDaoImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<OrderDto> getOrderList(String id) {
		String sql = " SELECT SEQ, ID, BEVERAGE, SYRUP, "
				+ " C_SHORT, C_TALL, C_GRANDE,SHOT, WHEEPING,CUP,PRICE, WDATE"
				+ " FROM ORDER_TABLE "
				+ " WHERE ID = ?";
		
		Connection conn = null;			// DB Connection
		PreparedStatement psmt = null;	// SQL
		ResultSet rs = null;			// result
		
		
		List<OrderDto> list = new ArrayList<OrderDto>();
		
		try {
			conn = DBConnection.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				OrderDto dto = new OrderDto(rs.getInt(1),//seq_order, 
											rs.getString(2),//orderId, 
											rs.getString(3),//beverage, 
											rs.getInt(4),//syrup, 
											rs.getInt(5),//shortS, 
											rs.getInt(6),//tallS, 
											rs.getInt(7),//grandeS, 
											rs.getInt(8),//shot, 
											rs.getInt(9),//cream, 
											rs.getInt(10),//cup, 
											rs.getInt(11),//price, 
											rs.getString(12));//wdate)
				list.add(dto);
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBClose.close(psmt, conn, rs);
		}
		
		return list;
	}

	@Override
	public boolean orderComplete(OrderDto dto, String id) {
		int count = 0;
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		String sql = "INSERT INTO ORDER_TABLE(SEQ, ID, BEVERAGE, SYRUP, "
				+ " C_SHORT, C_TALL, C_GRANDE,"
				+ " SHOT, WHEEPING, CUP, PRICE , WDATE ) "
				+ " VALUES(SEQ_ORDER.NEXTVAL, ?, ?, ?, ? , ?, ? ,?, ?, ?, ?, SYSDATE) ";
		
		try {
			conn = DBConnection.getConnection();
			psmt = conn.prepareStatement(sql);
			System.out.println("sql= " + sql);
			
			psmt.setString(1, id);
			psmt.setString(2, dto.getBeverage());
			psmt.setInt(3, dto.getSyrup());
			psmt.setInt(4, dto.getShortS());
			psmt.setInt(5, dto.getTallS());
			psmt.setInt(6, dto.getGrandeS());
			psmt.setInt(7, dto.getShot());
			psmt.setInt(8, dto.getCream());
			psmt.setInt(9, dto.getCup());
			psmt.setInt(10, dto.getPrice());
				
			count = psmt.executeUpdate();	
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBClose.close(psmt, conn, rs);
			
		}
		return count >0?true:false;
	
	}
	
	
}
















