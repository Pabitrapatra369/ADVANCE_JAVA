package com.pk.basics;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class JDBC_APP_4 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		try(sc;){

			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","c##batch37","PKP");
			PreparedStatement ps1=con.prepareStatement("insert into product values(?,?,?,?)");
			PreparedStatement ps2=con.prepareStatement("select * from product");
			while(true) {
				System.out.println("***********Choice**************");
				System.out.println("1.AddProduct\r\n"
						+ "2.ViewProduct\r\n"
						+ "3.Exit\r\n"
						+ "");
				System.out.print("Enter your choice:");
				int choice =Integer.parseInt(sc.nextLine());
				switch(choice){
				case 1:
					System.out.println("Enter the number of products to add(insert):");
					int n=Integer.parseInt(sc.nextLine());
					for(int i=1;i<=n;i++) {
						System.out.println("================Product-"+i+"=================");
						System.err.print("Enter the prod-code:");
						int code=Integer.parseInt(sc.nextLine());
						System.err.print("Enter the prod-name:");
						String pname=sc.nextLine();
						
						System.err.print("Enter the prod-price:");
						Double price=Double.parseDouble(sc.nextLine());

						System.err.print("Enter the prod-qty:");
						int qty=Integer.parseInt(sc.nextLine());
						ps1.setInt(1, code);
						ps1.setString(2, pname);
						ps1.setDouble(3, price);
						ps1.setInt(4, qty);
						
						int isInsert=ps1.executeUpdate();
						if(isInsert>0)System.out.println("Product Added SusscessFully.....");
						else System.out.println("Product not added");
					}
					System.out.println("Successfully added "+n+" products");
					break;
				case 2:
					break;
				case 3:
					System.out.println("operation stopped");
					System.exit(0);
					break;
				default :System.out.println("<<<<<<<Invalid choice>>>>>");
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
