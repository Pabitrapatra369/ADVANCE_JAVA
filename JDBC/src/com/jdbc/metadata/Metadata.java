package com.jdbc.metadata;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class Metadata {
	public static void main(String[] args) throws ClassNotFoundException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		try 
		{
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","C##BATCH37","PKP");
			
			System.out.println("===========Database Metadata==============");
			DatabaseMetaData DB = con.getMetaData();
			System.out.println("DB product name:"+DB.getDatabaseProductName());
			System.out.println("DB product version:"+DB.getDatabaseMajorVersion());
			System.out.println("DB driver name:"+DB.getDriverName());
			System.out.println("DB maximum colom in a table:"+DB.getMaxColumnsInTable());
			
			System.out.println("==============ResultSet Metadata=============");
		    Statement sm=con.createStatement();
		    ResultSet rs=sm.executeQuery("select * from emp");
		    ResultSetMetaData RSMD = rs.getMetaData();
		    System.out.println("Number of columns:"+RSMD.getColumnCount());
		    System.out.println("column name:"+RSMD.getColumnName(1));
		    System.out.println("column datatype:"+RSMD.getColumnTypeName(1));
		    
		}
		catch(Exception e)
		{
			
		}
	}
}
