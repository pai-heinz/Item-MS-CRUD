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
	
	public void updateData(itemRequestDto dto) {
		String query = "update item set item_name=?,item_price=? where item_code=?";
		try {
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setString(1, dto.getItemName());
			stmt.setDouble(2, dto.getItemPrice());
			stmt.setString(3, dto.getItemCode());
			stmt.executeUpdate();
			System.out.println("Updating successful");
		} catch (SQLException e) {
			System.out.println("Error occured while updating");
		}
	}
	
	public void deleteData(itemRequestDto dto) {
		String query = "delete from item where item_code=?";
		try {
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setString(1, dto.getItemCode());
			stmt.executeUpdate();
			System.out.println("Deleting successful");
		} catch (SQLException e) {
			System.out.println("Error occured while deleting");
		}
	}
	
	public itemResponseDto selectOne(itemRequestDto dto) {
		itemResponseDto res = new itemResponseDto();
		String query = "select * from item where item_code=?";
		try {
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setString(1, dto.getItemCode());
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				res.setItemCode(rs.getString("item_code"));
				res.setItemName(rs.getString("item_name"));
				res.setItemPrice(rs.getDouble("item_price"));
			}
		} catch (SQLException e) {
			System.out.println("Error occured while selecting one row");
		}
		return res;
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
