package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.MenuDao;
import db.DBClose;
import db.DBConnection;
import dto.MenuDto;

public class MenuDaoImpl implements MenuDao {

	public List<MenuDto> getMenuList() {
		String sql = " SELECT ID, CNAME, CSHORT, CTALL, CGRANDE"
				+ " FROM coffee ";
		
		Connection conn = null;			// DB Connection
		PreparedStatement psmt = null;	// SQL
		ResultSet rs = null;			// result
		
		List<MenuDto> list = new ArrayList<MenuDto>();
		
		try {
			conn = DBConnection.getConnection();
			psmt = conn.prepareStatement(sql);
			
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				MenuDto dto = new MenuDto(rs.getInt(1),//id, 
										rs.getString(2),//beverage, 
										rs.getInt(3),//shortSize, 
										rs.getInt(4),//tallSize, 
										rs.getInt(5));//grandeSize)
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
	
	
	
	
	
	
}






































