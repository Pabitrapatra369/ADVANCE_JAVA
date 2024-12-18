package com.class_Examples;
import java.util.*;
import java.sql.*;
public class DBCon9 {
	public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        try(s;){
        	Class.forName("oracle.jdbc.driver.OracleDriver");
        	Connection con = DriverManager.getConnection
        			("jdbc:oracle:thin:@localhost:1521:xe","system","tiger");
        	CallableStatement cs = con.prepareCall
        			("{call CreateCustomer69(?,?,?,?,?,?,?,?,?,?,?)}");
        	
        	System.out.println("Enter the Cust-AccNO:");
        	long accNo = Long.parseLong(s.nextLine());
        	System.out.println("Enter the Cust-Name:");
        	String name = s.nextLine();
        	System.out.println("Enter the Cust-Balance:");
        	float bal = Float.parseFloat(s.nextLine());
        	System.out.println("Enter the Cust-AccType:");
        	String accType = s.nextLine();
        	System.out.println("Enter the Cust-HNO:");
        	String hNo = s.nextLine();
        	System.out.println("Enter the Cust-StreetName:");
        	String sName = s.nextLine();
        	System.out.println("Enter the Cust-City:");
        	String city = s.nextLine();
        	System.out.println("Enter the Cust-State:");
        	String state = s.nextLine();
        	System.out.println("Enter the Cust-PinCode:");
        	int pinCode = Integer.parseInt(s.nextLine());
        	System.out.println("Enter the Cust-MailId:");
        	String mId = s.nextLine();
        	System.out.println("Enter the Cust-PhoneNO:");
        	long phNo = Long.parseLong(s.nextLine());
        	
        	cs.setLong(1, accNo);
        	cs.setString(2, name);
        	cs.setFloat(3, bal);
        	cs.setString(4, accType);
        	cs.setString(5, hNo);
        	cs.setString(6, sName);
        	cs.setString(7, city);
        	cs.setString(8, state);
        	cs.setInt(9, pinCode);
        	cs.setString(10, mId);
        	cs.setLong(11, phNo);
        	
        	cs.execute();//Executing Procedure
        	System.out.println("Procedure executed Successfully and inserted Customer details");
        	con.close();
        }catch(Exception e) {
        	e.printStackTrace();
        }
	}
}

