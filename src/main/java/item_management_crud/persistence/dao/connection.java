package item_management_crud.persistence.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class connection {
	public static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","admin");
			System.out.println("Connected..");
		} catch (ClassNotFoundException e) {
			System.out.println("Driver Class not found");
		} catch (SQLException e) {
			System.out.println("Data Base not found");
		}
		return con;
	}
}
