package productmanagement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import dbconnection.DBconnection;

public class ProductLogic {
	
	Scanner sc = new Scanner(System.in);
	String create = "create table productdetails("
			+ "product_id int primary key,"
			+ "productname varchar(150),"
			+ "productprice decimal(10,2),"
			+ "qty int,"
			+ "dates date"
			+ ")";
	
	DBconnection call = new DBconnection();
	Connection conn= call.dbconnection();
	
	public void createtable() {
		try {
			Statement st = conn.createStatement();
			st.executeUpdate(create);
			System.out.println("Successfully Created");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	String insert = "insert into productdetails(product_id,productname,productprice,qty,dates) values (?,?,?,?,?)";
	public void inserttable () {
		System.out.println("Enter your datas");
		System.out.println("Enter your product id");
		int product_id = sc.nextInt();
		sc.nextLine();
		System.out.println("Enter your product name");
		String product_name = sc.nextLine();
		System.out.println("Procuct price");
		double product_price = sc.nextDouble();
		System.out.println("Enter qty");
		int qty = sc.nextInt();
		sc.nextLine();
		System.out.println("Enter your Date");
		String date =sc.nextLine();
		
		try {
			PreparedStatement ps = conn.prepareStatement(insert);
			 ps.setInt(1, product_id);
	         ps.setString(2, product_name);
	         ps.setDouble(3, product_price);
	         ps.setInt(4, qty);
	         ps.setString(5, date);
	         
	         int row = ps.executeUpdate();
	         
	         if (row > 0) {
	                System.out.println("Product Successfully Inserted");
	            }
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		
	}
}
