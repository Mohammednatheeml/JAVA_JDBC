package productmanagement;


import java.net.ConnectException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import dbconnection.DBconnection;

public class AdminLogic {
	String create = "create table admin("
			+ "adminid int,"
			+ "name varchar(50),"
			+ "Password varchar(20)"
			+ ")";
	
	DBconnection dBconnection = new DBconnection();
	Connection conn = dBconnection.dbconnection();
	
	public void createadmin() {
		try {
			Statement st = conn.createStatement();
			st.executeUpdate(create);
			System.out.println("Admin Table Created");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	
}
