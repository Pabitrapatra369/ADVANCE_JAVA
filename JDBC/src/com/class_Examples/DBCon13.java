package com.class_Examples;
import java.util.*;
import java.sql.*;
public class DBCon13 {
	public static void main(String[] args) {
      Scanner s = new Scanner(System.in);
      try(s;){
    	  Class.forName("oracle.jdbc.driver.OracleDriver");
    	  Connection con = DriverManager.getConnection
    			  ("jdbc:oracle:thin:@localhost:1521:xe","system","tiger");
    	  Statement stm = con.createStatement();
    	  System.out.println("=======insert operation on Table:Bank69======");
    	  System.out.println("Enter the Cust-AccNo:");
    	  long accNo = Long.parseLong(s.nextLine());
    	  System.out.println("Enter the Cust-Name:");
    	  String name = s.nextLine();
    	  System.out.println("Enter the Cust-Balance:");
    	  float bal = Float.parseFloat(s.nextLine());
    	  System.out.println("Enter the Cust-AccType:");
    	  String accType = s.nextLine();
    	  stm.addBatch
    	  ("insert into Bank69 values("+accNo+",'"+name+"',"+bal+",'"+accType+"')");
    	  
    	  System.out.println("=======Delete operation on Table:Product69=====");
    	  System.out.println("Enter the Prod-Code to delete product details:");
    	  String pCode = s.nextLine();
    	  stm.addBatch("delete from Product69 where code='"+pCode+"'");
    	  
    	  int k[] = stm.executeBatch();
    	  for(int i : k)
    	  {
    		  System.out.println("Query executed : "+i);
    	  }
    	  
    	  stm.clearBatch();
    	  con.close();
      }catch(Exception e) {
    	  e.printStackTrace();
      }

	}

}
