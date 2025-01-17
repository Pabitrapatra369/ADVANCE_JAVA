package com.jdbc.scrollable_nonscrollable;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PRODUCT_APP_SCROLLABLE {

	public static void main(String[] args) {
		try {
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","c##batch37","PKP");
			PreparedStatement ps2=con.prepareStatement("select * from product",ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			
			ResultSet rs=ps2.executeQuery();
		    rs.last();
		    System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"
        			+rs.getFloat(3)+"\t"+rs.getInt(4));
		   //printing product in forward direction
		    rs.beforeFirst();
		    while(rs.next()) {
		    	System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"
	        			+rs.getFloat(3)+"\t"+rs.getInt(4));
		    }
		    //rrinting product int reverse direction
		    while(rs.previous()) {
		    	System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"
	        			+rs.getFloat(3)+"\t"+rs.getInt(4));
		    }
//		    4.Retrieve 3rd record from top.
		    rs.relative(+3);
		    System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"
        			+rs.getFloat(3)+"\t"+rs.getInt(4));
//	          5.Retrieve 3rd record from bottom. 
		    rs.last();
		    rs.relative(-3);
		    System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"
        			+rs.getFloat(3)+"\t"+rs.getInt(4));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
