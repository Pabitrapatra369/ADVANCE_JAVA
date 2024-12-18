package com.class_Examples;
import java.io.*;
import java.sql.*;
import java.util.*;
public class DBCon8 
{
	public static void main(String[] args) 
	{
         Scanner s = new Scanner(System.in);
         try(s;){
        	 Class.forName("oracle.jdbc.driver.OracleDriver");
        	 Connection con = DriverManager.getConnection
        			 ("jdbc:oracle:thin:@localhost:1521:xe","system","tiger");
        	 PreparedStatement ps = con.prepareStatement
        			 ("select * from StreamTab69 where id=?");
        	 System.out.println("Enter the id to retrieve image:");
        	 String id = s.nextLine();
        	 ps.setString(1, id);
        	 ResultSet rs = ps.executeQuery(); 
        	 if(rs.next()) {
        		 Blob b = rs.getBlob(2);
        		 byte by[] = b.getBytes(1, (int)b.length());
        		 System.out.println("Enter the fPath with name to store image(destination):");
        		 String fPath = s.nextLine();
        		 File f = new File(fPath);
        		 FileOutputStream fos = new FileOutputStream(f);
        		 fos.write(by);
        		 System.out.println("Image retrived Successfully....");
        		 fos.close();
        	 }else {
        		 System.out.println("Invalid id...");
        	 }
         }catch(Exception e) {
        	 e.printStackTrace();
         }
	}
}
