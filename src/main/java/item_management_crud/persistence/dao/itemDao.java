package item_management_crud.persistence.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import item_management_crud.dto.itemRequestDto;

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
		} catch (SQLException e) {
			System.out.println("Error occured while adding");
		}
	}
}
