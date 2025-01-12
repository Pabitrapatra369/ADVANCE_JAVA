package com.class_Examples;
import java.util.*;
import java.sql.*;
public class DBCon11 {
	public static void main(String[] args) {
      Scanner s = new Scanner(System.in);
      try(s;){
    	  Class.forName("oracle.jdbc.driver.OracleDriver");
    	  Connection con = DriverManager.getConnection
    			  ("jdbc:oracle:thin:@localhost:1521:xe","system","tiger");
    	  CallableStatement cs = con.prepareCall
    			  ("{call ?:=RetrieveBalance69(?)}");
    	  System.out.println("Enter the Cust-AccNo to retrieve balance:");
    	  long accNo = s.nextLong();
    	  cs.setLong(2, accNo);
    	  cs.registerOutParameter(1, Types.FLOAT);
    	  cs.execute();
    	  System.out.println("--------Deatils-------");
    	  System.out.println("Cust-AccNo:"+accNo);
    	  System.out.println("Cust-Balance:"+cs.getFloat(1));
    	  con.close();
      }catch(Exception e) {
    	  e.printStackTrace();
      }
	}
}

