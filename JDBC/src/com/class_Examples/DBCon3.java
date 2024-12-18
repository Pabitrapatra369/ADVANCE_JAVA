package com.class_Examples;
import java.util.*;
import java.sql.*;
public class DBCon3 
{
	public static void main(String[] args) 
	{
         Scanner s = new Scanner(System.in);
         try(s;){
        	 System.out.println("******Customer details******");
        	 System.out.println("Enter the Customer-PhNo:");
        	 long phNo = Long.parseLong(s.nextLine());
        	 System.out.println("Enter the Customer-Name:");
        	 String name = s.nextLine();
        	 System.out.println("Enter the Customer-City:");
        	 String city = s.nextLine();
        	 System.out.println("Enter the Customer-MailId:");
        	 String mId = s.nextLine();
        	 
        	 Class.forName("oracle.jdbc.driver.OracleDriver");
        	 Connection con = DriverManager.getConnection
        			 ("jdbc:oracle:thin:@localhost:1521:xe","system","tiger");
        	 Statement stm = con.createStatement();
        	 int k = stm.executeUpdate
        	("insert into Customer69 values("+phNo+",'"+name+"','"+city+"','"+mId+"')");
        	 if(k>0) {
        		 System.out.println("Customer added Successfully....");
        	 }
        	 con.close();
         }catch(SQLIntegrityConstraintViolationException se) {
        	 System.out.println("Customer already available....");
         }catch(Exception e) {
        	 e.printStackTrace();
         }
	}
}
