package com.pk.basics;
import java.sql.*;
public class JDBC_APP_1 {
	public static void main(String[] args) {
		try
		{
			//Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","C##BATCH37","PKP");
			 Statement smt=con.createStatement();
			 ResultSet rs=smt.executeQuery("select * from bookdetails");
			 while(rs.next()) {
				 System.out.println(rs.getInt(1)+"....."+rs.getString(2)+"....."+rs.getString(3)+"....."+rs.getInt(4)+"...."+rs.getInt(5));
			 }
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}