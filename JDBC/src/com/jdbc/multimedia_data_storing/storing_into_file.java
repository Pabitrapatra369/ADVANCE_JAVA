package com.jdbc.multimedia_data_storing;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class storing_into_file {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		try(s;){
			Class.forName("oracle.jdbc.driver.OracleDriver");
	    	   Connection con = DriverManager.getConnection
	    			   ("jdbc:oracle:thin:@localhost:1521:xe","c##batch37","PKP");
	    	   PreparedStatement ps = con.prepareStatement
	    			   ("insert into StreamTab values(?,?)");//Compilation process
	    	   System.out.println("Enter the user-id:");
	    	   String id = s.nextLine();
	    	   System.out.println("Enter the filePath with fileName(Source):");
	    	   String fPath = s.nextLine();
	    	   File f = new File(fPath);
	    	   if(f.exists()) {
	    		   FileInputStream fis = new FileInputStream(f);
	    		   
	    		   ps.setString(1, id);
	    		   ps.setBinaryStream(2, fis, f.length());
	    		   
	    		   int k = ps.executeUpdate();
	    		   if(k>0) {
	    			   System.out.println("Image stored successfully...");
	    		   }
	    	   }else {
	    		  System.out.println("invalid fPath or fName...."); 
	    	   }
	    	   con.close();

			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
