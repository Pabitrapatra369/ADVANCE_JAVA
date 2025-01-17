package com.jdbc.callableStatement;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;
import java.util.Scanner;

public class RETRIEVE_STUDENT_DETAILS69 {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		System.out.println("Welcome to student details retrieve app");
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","c##batch37","PKP");
			CallableStatement cs=con.prepareCall("{call retrieveStudentDetails(?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			System.out.println("Enter the student roll number:");
			int roll=Integer.parseInt(s.nextLine());
			cs.setInt(1, roll);
			cs.registerOutParameter(2, Types.VARCHAR);
			cs.registerOutParameter(3, Types.VARCHAR);
			cs.registerOutParameter(4, Types.VARCHAR);
			cs.registerOutParameter(5, Types.VARCHAR);
			cs.registerOutParameter(6, Types.VARCHAR);
			cs.registerOutParameter(7, Types.VARCHAR);
			cs.registerOutParameter(8, Types.INTEGER);
			cs.registerOutParameter(9, Types.VARCHAR);
			cs.registerOutParameter(10, Types.BIGINT);
			cs.registerOutParameter(11, Types.FLOAT);
			cs.registerOutParameter(12, Types.FLOAT);
			cs.registerOutParameter(13, Types.FLOAT);
			cs.execute();
			
			System.out.println("==========student details===========");
			System.out.println("student-roll:"+roll);
			System.out.println("student-name:"+cs.getString(2));
			System.out.println("student-branch:"+cs.getString(3));
			System.out.println("student-hno:"+cs.getString(4));
			System.out.println("student-sname:"+cs.getString(5));
			System.out.println("student-city:"+cs.getString(6));
			System.out.println("student-state:"+cs.getString(7));
			System.out.println("student-pincode:"+cs.getInt(8));
			System.out.println("student-mail:"+cs.getString(9));
			System.out.println("student-phone no:"+cs.getLong(10));
			System.out.println("student-total mark:"+cs.getFloat(11));
			System.out.println("student-percentage:"+cs.getFloat(12));
			if(cs.getFloat(13)==1.0)
			System.out.println("student-result: Pass");
			else 
		    System.out.println("student-result: Fail");

			
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
