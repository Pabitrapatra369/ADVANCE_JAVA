package com.class_Examples;
import java.util.*;
import java.sql.*;
public class DBCon12 
{
	public static void main(String[] args) 
	{
	     Scanner s = new Scanner(System.in);
	     try(s;){
	    	 Class.forName("oracle.jdbc.driver.OracleDriver");
	    	 Connection con = DriverManager.getConnection
	    			 ("jdbc:oracle:thin:@localhost:1521:xe","system","tiger");
	    	 PreparedStatement ps1 = con.prepareStatement
	    			 ("select * from Bank69 where accno=?");
	    	 PreparedStatement ps2 = con.prepareStatement
	    			 ("update Bank69 set balance=balance+? where accno=?");
	    	 System.out.println("status of Commit : "+con.getAutoCommit());
	    	 con.setAutoCommit(false);
	    	 System.out.println("status of Commit : "+con.getAutoCommit());
	    	 Savepoint sp = con.setSavepoint();
	    	 System.out.println("Enter the HomeAccNo:");
	    	 long hAccNo = s.nextLong();
	    	 ps1.setLong(1, hAccNo);
	    	 ResultSet rs1 = ps1.executeQuery();
	    	 if(rs1.next()) {
	    		 float bal = rs1.getFloat(3);
	    		 System.out.println("Enter the beneficieryAccNo:");
	    		 long bAccNo = s.nextLong();
	    		 ps1.setLong(1, bAccNo);
	    		 ResultSet rs2 = ps1.executeQuery();
	    		 if(rs2.next()) {
	    			 System.out.println("Enter the amt to be transferred:");
	    			 float amt = s.nextFloat();
	    			 if(amt<=bal) {
	    				 // Statement-1 : Subtract 5000/- from accNo:6123456
	    				 ps2.setFloat(1,-amt);
	    				 ps2.setLong(2, hAccNo);
	    				 int p = ps2.executeUpdate();//Updated in Buffer
	    				 
	    				 //Statement-2 : Add 5000/- to accNo:313131
	    				 ps2.setFloat(1, +amt);
	    				 ps2.setLong(2, bAccNo);
	    				 int q = ps2.executeUpdate();//Updated in Buffer
	    				 
	    				 if(p==1 && q==1) {
	    					 con.commit();
	    					 System.out.println("Transaction Successfull...");
	    				 }else {
	    					 System.out.println("Transaction failed....");
	    					 con.rollback(sp);
	    				 }
	    			 }else {
	    				 System.out.println("Insuffiecient fund...");
	    			 }
	    		 }else {
	    			 System.out.println("Invalid bAccNo...");
	    		 }
	    		 
	    	 }else {
	    		 System.out.println("Invalid hAccNo....");
	    	 }
	     }catch(Exception e) {
	    	 e.printStackTrace();
	     }
	}

}
