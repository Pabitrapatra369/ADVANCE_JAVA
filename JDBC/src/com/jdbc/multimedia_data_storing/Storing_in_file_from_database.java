package com.jdbc.multimedia_data_storing;

import java.io.File;
import java.io.FileOutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Storing_in_file_from_database {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		try(s;){
	   	 Class.forName("oracle.jdbc.driver.OracleDriver");
	   	 Connection con = DriverManager.getConnection
	   			 ("jdbc:oracle:thin:@localhost:1521:xe","C##BATCH37","PKP");
	   	 PreparedStatement ps = con.prepareStatement
	   			 ("select * from StreamTab where id=?");
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
