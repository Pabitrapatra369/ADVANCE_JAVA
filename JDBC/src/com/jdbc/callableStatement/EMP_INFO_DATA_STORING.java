package com.jdbc.callableStatement;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

public class EMP_INFO_DATA_STORING {
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		try(s;){
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","c##batch37","PKP");
			CallableStatement cs=con.prepareCall("{call createemployee69(?,?,?,?,?,?,?,?,?)}");
			
			System.out.println("Enter the employee-empId");
			int roll=Integer.parseInt(s.nextLine());
			System.out.println("Enter the employee-empName");
			String name=s.nextLine();
			System.out.println("Enter the employee-empRole");
			String role=s.nextLine();
			System.out.println("Enter the employee-empDept");
			String dept=s.nextLine();
			System.out.println("Enter the employee-empHno");
	        int  hno=Integer.parseInt(s.nextLine());
			System.out.println("Enter the employee-empCity");
			String city=s.nextLine();
			System.out.println("Enter the employee-empPincode");
			int pin=Integer.parseInt(s.nextLine());
			System.out.println("Enter the employee-empMailId");
			String mailid=s.nextLine();
			System.out.println("Enter the employee-empPhno");
		    Long phno=Long.parseLong(s.nextLine());
		    
		    
		    cs.setInt(1, roll);
		    cs.setString(2, name);
		    cs.setString(3, role);
		    cs.setString(4, dept);
		    cs.setInt(5, hno);
		    cs.setString(6, city);
		    cs.setInt(7, pin);
		    cs.setString(8, mailid);
		    cs.setLong(9, phno);
		    
		    cs.execute();
		    System.out.println("Data stored successfully...");
		    con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
