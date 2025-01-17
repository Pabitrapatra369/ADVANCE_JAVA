package com.pk.basics;

import java.util.Scanner;
import java.sql.*;

public class JDBC_STUDENTLOGIN_APP {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		try {
			System.out.println("***************wlcome  to student login/register page********************");
			int choice=0;
			do {
				System.out.println("want to procced.......");
				System.out.println("1.Login\n2.Register\n3.Exit");
				System.out.print("Enter any number for procced:");
				choice=Integer.parseInt(sc.nextLine());
				int rollNo=0;
				String name=null;
				double percentage=0.0;
				String mailId=null;
				long phNo=0;
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","c##batch37","PKP");
				Statement smt=con.createStatement();
				ResultSet rs=null;
				switch(choice) {
				case 1:{
					//for login proccess
					System.out.println("//////For login enter valid data\\\\\\");
					System.out.print("Enter Student RollNo:");
					rollNo=Integer.parseInt(sc.nextLine());
					
					System.out.print("Enter Student Name:");
					name=sc.nextLine();
					rs =smt.executeQuery("select * from student where name='"+name+"' and rollno="+rollNo+"");
					System.out.println("Your are successfully logged in the app");
					if(rs.next()) {
					System.out.println("roll no="+rs.getInt(1));
					System.out.println("name="+rs.getString(2));
					System.out.println("percentage="+rs.getDouble(3));
					System.out.println("mail id="+rs.getString(4));
					System.out.println("phone no="+rs.getLong(5));
					choice=3;
					}
					else {
						System.err.println("invalid name and possword");
					}
					
					break;
				}
				case 2:{
					System.out.println("//////For Register enter valid data\\\\\\");

					System.out.print("Enter Student RollNo:");
					rollNo=Integer.parseInt(sc.nextLine());
					
					System.out.print("Enter Student Name:");
					name=sc.nextLine();
					System.out.print("Enter Student percentage:");
					percentage=Double.parseDouble(sc.nextLine());
					System.out.print("Enter Student Email Id:");
					mailId=sc.nextLine();
					System.out.print("Enter Student phone Number:");
					phNo=Long.parseLong(sc.nextLine());
					
					int isUpdated=smt.executeUpdate("insert into student values("+rollNo+",'"+name+"',"+percentage+",'"+mailId+"',"+phNo+")");
					if(isUpdated>0) {
						System.out.println("You hava Registered Successfully.");
					}
					else {
						System.out.println("<<<you are not registered>>>");
					}
					break;
				}
				case 3:{
					choice=3;
					System.out.println("!!!Thank you for visiting our app!!!");
					break;
					
				}
				default : System.err.println("<<<You entered wrong choice>>>");
				}
				
			}while(choice!=3);
			
		}
		catch(SQLIntegrityConstraintViolationException e) {
			System.err.println("Field already exist...");
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

}
