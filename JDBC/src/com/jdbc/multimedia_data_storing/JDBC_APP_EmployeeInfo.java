package com.jdbc.multimedia_data_storing;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class JDBC_APP_EmployeeInfo {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		try(sc;){
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","C##batch37","PKP");
			PreparedStatement ps=con.prepareStatement("insert into emp_info values(?,?,?,?,?,?)");
			
			//for getting the data form user
			System.out.print("Enter the employee id:");
			int eid=Integer.parseInt(sc.nextLine());
			System.out.print("Enter the employee name:");
			String name=sc.nextLine();
			System.out.print("Enter the employee adderss:");
			String address=sc.nextLine();
			System.out.print("Enter the employee email:");
			String email=sc.nextLine();
			System.out.println("Enter  the phone number:");
			long phoneNo=Long.parseLong(sc.nextLine());
			System.out.print("Ente the filePath of the resume:");
			String resumePath=sc.nextLine();
			
			
			//storing into database
			File f=new File(resumePath);
			if(f.exists()) {
				FileInputStream fis=new FileInputStream(f);
				
				//setting the data into the preapared statement
				ps.setInt(1, eid);
				ps.setString(2,name );
				ps.setString(3,address );
				ps.setString(4,email );
				ps.setLong(5,phoneNo );
				ps.setBinaryStream(6, fis);
				
				int storeData=ps.executeUpdate();
				if(storeData>0) {
					System.out.println("Image stored successfully...");
				}else {
					System.out.println("invalid filePath or fileName...");
				}
				con.close();
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
