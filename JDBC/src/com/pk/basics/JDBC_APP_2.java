package com.pk.basics;
import java.util.*;
import java.sql.*;

public class JDBC_APP_2 {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		System.out.println("Enter the book code:");
		int bCode=s.nextInt();
		
		try
		{
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","C##BATCH37","PKP");
			Statement smt=con.createStatement();
			ResultSet rs=smt.executeQuery("select * from bookdetails where bcode="+bCode);
			if(rs.next()) System.out.println(rs.getInt(1)+"....."+rs.getString(2)+"....."+rs.getString(3)+"....."+rs.getInt(4)+"...."+rs.getInt(5));
			else System.err.println("Record Not available!!!");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
