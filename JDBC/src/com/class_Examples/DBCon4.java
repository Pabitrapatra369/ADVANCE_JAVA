package com.class_Examples;
import java.sql.*;
import java.util.*;
public class DBCon4 {
	public static void main(String[] args) {
         Scanner s = new Scanner(System.in);
         try(s;){
        	 Class.forName("oracle.jdbc.driver.OracleDriver");
        	 Connection con = DriverManager.getConnection
        			 ("jdbc:oracle:thin:@localhost:1521:xe","system","tiger");
        	 PreparedStatement ps1 = con.prepareStatement
        			 ("insert into Product69 values(?,?,?,?)");
        	 PreparedStatement ps2 = con.prepareStatement
        			 ("select * from Product69");
        	 while(true) {
        		 System.out.println("********Choice*******");
        		 System.out.println("\t1.AddProduct"
        		 		+ "\n\t2.ViewProdcuts"
        		 		+ "\n\t3.Exit");
        		 System.out.println("Enter your Choice:");
        		 int choice = Integer.parseInt(s.nextLine());
        		 switch(choice)
        		 {
        		 case 1:
        			 System.out.println("Enter the number of products to add(insert):");
        			 int n = Integer.parseInt(s.nextLine());
        			 for(int i=1;i<=n;i++)
        			 {
        				 System.out.println("=======Product-"+i+"======");
        				 System.out.println("Enter the Prod-Code:");
        				 String code = s.nextLine();
        				 System.out.println("Enter the Prod-Name:");
        				 String name = s.nextLine();
        				 System.out.println("Enter the Prod-Price:");
        				 float price = Float.parseFloat(s.nextLine());
        				 System.out.println("Enter the Prod-Qty:");
        				 int qty = Integer.parseInt(s.nextLine());
        				 
        				 ps1.setString(1, code);
        				 ps1.setString(2, name);
        				 ps1.setFloat(3, price);
        				 ps1.setInt(4, qty);
        				 int k = ps1.executeUpdate();
        				 if(k>0) {
        					 System.out.println("Product added Successfully...");
        				 }
        			 }//end of loop
        			 break;
        		 case 2:
        			 ResultSet rs = ps2.executeQuery();
        			 System.out.println("------ProductDetails-----");
        			 while(rs.next()) {
        				 System.out.println(rs.getString(1)+"\t"+rs.getString(2)+
        						 "\t"+rs.getFloat(3)+"\t"+rs.getInt(4));
        			 }//end of loop
        			 break;
        		 case 3:
        			 System.out.println("Operations stopped....");
        			 System.exit(0);
        			 break;
        		 default:
        			 System.out.println("Invalid choice....");
        		 }//end of switch
        	 }//end of loop
         }catch(Exception e) {
        	 e.printStackTrace();
         }
	}
}

