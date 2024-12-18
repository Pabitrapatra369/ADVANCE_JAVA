package com.class_Examples;
import java.sql.*;
import java.util.*;
public class DBCon2 
{
	public static void main(String[] args) 
	{
        Scanner s = new Scanner(System.in);
        try(s;)
        {
        	System.out.println("Enter the Customer-PhoneNo:");
        	long phNo = s.nextLong();
        	Class.forName("oracle.jdbc.driver.OracleDriver");
        	Connection con = DriverManager.getConnection
        			("jdbc:oracle:thin:@localhost:1521:xe","system","tiger");
        	Statement stm = con.createStatement();
        	ResultSet rs = stm.executeQuery
        			("select * from Customer69 where phoneno="+phNo+"");
        	if(rs.next()) {
        	   System.out.println(rs.getLong(1)+"\t"+rs.getString(2)+"\t"
        			   +rs.getString(3)+"\t"+rs.getString(4));
        	}else {
        		System.out.println("No Customer avialable....");
        	}
        	con.close();
        }//end of try
        catch(Exception e)
        {
        	e.printStackTrace();
        }
	}
}
