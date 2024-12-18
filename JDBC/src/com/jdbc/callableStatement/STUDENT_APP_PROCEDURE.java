package com.jdbc.callableStatement;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

public  class STUDENT_APP_PROCEDURE {
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		try(s;){
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","c##batch37","PKP");
			
			CallableStatement cs=con.prepareCall("{call createStudent69(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			
			System.out.println("Enter the student-roll");
			int roll=Integer.parseInt(s.nextLine());
			System.out.println("Enter the student-name");
			String name=s.nextLine();
			System.out.println("Enter the student-branch");
			String branch=s.nextLine();
			System.out.println("Enter the student-hno");
			String hno=s.nextLine();
			System.out.println("Enter the student-sname");
			String sname=s.nextLine();
			System.out.println("Enter the student-city");
			String city=s.nextLine();
			System.out.println("Enter the student-state");
			String state=s.nextLine();			
			System.out.println("Enter the student-pincode");
			int pinCode=Integer.parseInt(s.nextLine());
			System.out.println("Enter the student-mid");
			String mid=s.nextLine();
			System.out.println("Enter the student-phno");
			long phno=Long.parseLong(s.nextLine());
			System.out.println("Enter the student-sub1 marks");
			int sub1=Integer.parseInt(s.nextLine());
			System.out.println("Enter the student-sub2 marks");
			int sub2=Integer.parseInt(s.nextLine());

			System.out.println("Enter the student-sub3 marks");
			int sub3=Integer.parseInt(s.nextLine());

			System.out.println("Enter the student-sub4 marks");
			int sub4=Integer.parseInt(s.nextLine());

			System.out.println("Enter the student-sub5 marks");
			int sub5=Integer.parseInt(s.nextLine());

			System.out.println("Enter the student-sub6 marks");
			int sub6=Integer.parseInt(s.nextLine());
			float totMarks=sub1+sub2+sub3+sub4+sub5+sub6;
			float percentage=totMarks/6;
			int result=0;
			if(sub1>35&&sub2>35&&sub3>35&&sub4>35&&sub5>35&&sub6>35)result=1;
			
			
			
			cs.setInt(1, roll);
			cs.setString(2, name);
			cs.setString(3, branch);
			cs.setString(4, hno);
			cs.setString(5, sname);
			cs.setString(6, city);
			cs.setString(7, state);
			cs.setInt(8, pinCode);
			cs.setString(9, mid);
			cs.setLong(10, phno);
			cs.setInt(11, sub1);
			cs.setInt(12, sub1);
			cs.setInt(13, sub1);
			cs.setInt(14, sub1);
			cs.setInt(15, sub1);
			cs.setInt(16, sub1);
			cs.setFloat(17, totMarks);
			cs.setFloat(18,percentage);
			cs.setInt(19, result);
			
			cs.execute();
			System.out.println("Procedure executed successfully and inserted student details");
			con.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
