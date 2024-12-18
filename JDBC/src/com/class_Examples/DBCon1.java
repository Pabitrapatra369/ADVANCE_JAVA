package com.class_Examples;
import java.sql.*;;
public class DBCon1 
{
	public static void main(String[] args) 
	{
        try {
        	//step-1 : Loading JDBC driver
        	Class.forName("oracle.jdbc.driver.OracleDriver");
        	//step-2 : Creating connection to database product
        	Connection con = DriverManager.getConnection
        			("jdbc:oracle:thin:@localhost:1521:xe","system","tiger");
        	//step-3 : Creating JDBC Statement
        	Statement stm = con.createStatement();
        	//step-4 : Executing query
        	ResultSet rs = stm.executeQuery("select * from Customer69");
        	while(rs.next())
        	{
        		System.out.println(rs.getLong(1)+"\t"+rs.getString(2)+
        				"\t"+rs.getString(3)+"\t"+rs.getString(4));
        	}//end of loop
        	//step-5 : Closing the Connection.
        	con.close();
        }catch(Exception e) {
        	e.printStackTrace();
        }
	}
}
