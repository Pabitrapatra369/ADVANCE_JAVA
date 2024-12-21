package com.class_Examples;
import java.sql.*;
import java.util.*;
public class DBCon10 {
	public static void main(String[] args) {
       Scanner s = new Scanner(System.in);
       try(s;){
    	   Class.forName("oracle.jdbc.driver.OracleDriver");
    	   Connection con = DriverManager.getConnection
    	   ("jdbc:oracle:thin:@localhost:1521:xe","system","tiger");
    	   CallableStatement cs = con.prepareCall
    			   ("{call RetrieveCustomer69(?,?,?,?,?,?,?,?,?,?,?)}");
    	   System.out.println("Enter the Cust-AccNO to retrieve details:");
    	   long accNo = s.nextLong();
    	   cs.setLong(1, accNo);
    	   cs.registerOutParameter(2, Types.VARCHAR);
    	   cs.registerOutParameter(3, Types.FLOAT);
    	   cs.registerOutParameter(4, Types.VARCHAR);
    	   cs.registerOutParameter(5, Types.VARCHAR);
    	   cs.registerOutParameter(6, Types.VARCHAR);
    	   cs.registerOutParameter(7, Types.VARCHAR);
    	   cs.registerOutParameter(8, Types.VARCHAR);
    	   cs.registerOutParameter(9, Types.INTEGER);
    	   cs.registerOutParameter(10, Types.VARCHAR);
    	   cs.registerOutParameter(11, Types.BIGINT);
    	   cs.execute();
    	   System.out.println("-------Customer Details------");
    	   System.out.println("AccNO:"+accNo);
    	   System.out.println("Cust-Name:"+cs.getString(2));
    	   System.out.println("Cust-Bal:"+cs.getFloat(3));
    	   System.out.println("Cust-AccTYpe:"+cs.getString(4));
    	   System.out.println("Cust-HNO:"+cs.getString(5));
    	   System.out.println("Cust-SName:"+cs.getString(6));
    	    System.out.println("Cust-City:"+cs.getString(7));
    	   System.out.println("Cust-State:"+cs.getString(8));
    	   System.out.println("Cust-PinCode:"+cs.getInt(9));
    	   System.out.println("Cust-MID:"+cs.getString(10));
    	   System.out.println("Cust-PhoneNo:"+cs.getLong(11));
    	   
    	   con.close();
       }catch(Exception e) {
    	   e.printStackTrace();
       }
	}
}
