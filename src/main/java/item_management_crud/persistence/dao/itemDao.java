package item_management_crud.persistence.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import item_management_crud.dto.itemRequestDto;
import item_management_crud.dto.itemResponseDto;

public class itemDao {
	static Connection con = null;
	static {
		con = connection.getConnection();
	}
	
	public void addData(itemRequestDto dto) {
		String query = "insert into item (item_code,item_name,item_price) values(?,?,?)";
		try { 
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setString(1, dto.getItemCode());
			stmt.setString(2, dto.getItemName());
			stmt.setDouble(3, dto.getItemPrice());
			stmt.executeUpdate();
			System.out.println("Adding successful");
		} catch (SQLException e) {
			System.out.println("Error occured while adding");
		}
	}
	
	public ArrayList<itemResponseDto> selectAll(){
		ArrayList <itemResponseDto> list = new ArrayList();
		String query = "select * from item";
		try {
			PreparedStatement stmt = con.prepareStatement(query);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				itemResponseDto dto = new itemResponseDto();
				dto.setItemCode(rs.getString("item_code"));
				dto.setItemName(rs.getString("item_name"));
				dto.setItemPrice(rs.getDouble("item_price"));
				list.add(dto);
			}
			System.out.println("Selecting successful");
		} catch (SQLException e) {
			System.out.println("Error occured while selecting");
		}
		return list;
	}
}
