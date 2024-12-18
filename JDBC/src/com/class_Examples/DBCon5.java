package com.class_Examples;
import java.util.*;
import java.sql.*;
public class DBCon5 {
	public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        try(s;){
        	Class.forName("oracle.jdbc.driver.OracleDriver");
        	Connection con = DriverManager.getConnection
        			("jdbc:oracle:thin:@localhost:1521:xe","system","tiger");
        	PreparedStatement ps1 = con.prepareStatement("select * from Product69");
        	PreparedStatement ps2 = con.prepareStatement
    				("select * from Product69 where code=?");
        	ResultSet rs = ps1.executeQuery();
        	System.out.println("-----------Product Details------------");
        	while(rs.next()) {
        		System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t"+
        	       rs.getFloat(3)+"\t"+rs.getInt(4));
        	}//end of loop
        	System.out.println("=======Choice(operation on Product)=====");
        	System.out.println("\t1.UpdateProduct"
        			+ "\n\t2.DeleteProduct");
        	System.out.println("Enter your Choice:");
        	int choice = Integer.parseInt(s.nextLine());
        	switch(choice)
        	{
        	case 1:
        		System.out.println("Enter the Product-Code to update price-qty:");
        		String pC1 = s.nextLine();
        		
        		ps2.setString(1, pC1);
        		ResultSet rs2 = ps2.executeQuery();
        		if(rs2.next()) {
        			System.out.println("Old Product-Price:"+rs2.getFloat(3));
        			System.out.println("Enter the new price for product:");
        			float nPrice = Float.parseFloat(s.nextLine());
        			System.out.println("Existing Product-Qty:"+rs2.getInt(4));
        			System.out.println("Enter new Stock for Product:");
        			int nQty = Integer.parseInt(s.nextLine());
        			PreparedStatement ps3 = con.prepareStatement
        			("update Product69 set price=?,qty=qty+? where code=?");
        			ps3.setFloat(1, nPrice);
        			ps3.setInt(2, nQty);
        			ps3.setString(3, pC1);
        			int k2 = ps3.executeUpdate();
        			if(k2>0) {
        				System.out.println("Product Updated Successfully....");
        			}
        		}else {
        			System.out.println("Invalid Product Code....");
        		}
        		break;
        	case 2:
        		System.out.println("Enter the Product-Code to delete Product:");
        		String pC2 = s.nextLine();
        		ps2.setString(1, pC2);
        		ResultSet rss = ps2.executeQuery();
        		if(rss.next()) {
        			PreparedStatement ps4 = con.prepareStatement
        					("delete from Product69 where code=?");
        			ps4.setString(1, pC2);
        			int k3 = ps4.executeUpdate();
        			if(k3>0) {
        				System.out.println("Product deleted Successfully...");
        			}
        		}else {
        			System.out.println("Invalid Product Code...");
        		}
        		break;
        	default:
        		System.out.println("Invalid Choice....");
        	}//end of switch
        	System.out.println("-----------Product Details------------");
        	ResultSet rs3 = ps1.executeQuery();
        	while(rs3.next()) {
        		System.out.println(rs3.getString(1)+"\t"+rs3.getString(2)+"\t"+
        	       rs3.getFloat(3)+"\t"+rs3.getInt(4));
        	}//end of loop
        }catch(Exception e) {
        	e.printStackTrace();
        }
	}
}
