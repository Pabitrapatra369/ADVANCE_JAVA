package com.class_Examples;
import java.sql.*;
public class DBCon14 {
	public static void main(String[] args) {
        try {
        	Class.forName("oracle.jdbc.driver.OracleDriver");
        	Connection con = DriverManager.getConnection
            ("jdbc:oracle:thin:@localhost:1521:xe","system","tiger");
        	System.out.println("********DatabaseMetaData********");
        	DatabaseMetaData dmd = con.getMetaData();
        	System.out.println("DB Product Name : "+dmd.getDatabaseProductName());
        	System.out.println("DB Major Version : "+dmd.getDriverMajorVersion());
        	PreparedStatement ps = con.prepareStatement
        			("update product69 set price=?,qty=? where code=?");
        	System.out.println("******ParameterMetaData*******");
        	ParameterMetaData pmd = ps.getParameterMetaData();
        	System.out.println("Parameter Count : "+pmd.getParameterCount());
        	PreparedStatement ps2 = con.prepareStatement
        			("select code,price,qty from Product68");
        	ResultSet rs = ps2.executeQuery();
        	System.out.println("-----data from ResultSet----");
        	while(rs.next()) {
        		System.out.println(rs.getString(1)+"\t"+rs.getFloat(2)+"\t"+rs.getInt(3));
        	}//end of loop
        	System.out.println("******ResultSetMetaData******");
        	ResultSetMetaData rsmd = rs.getMetaData();
        	System.out.println("Column Count : "+rsmd.getColumnCount());
        	System.out.println("2nd Column Name : "+rsmd.getColumnName(2));
        	con.close();
        }catch(Exception e) {
        	e.printStackTrace();
        }
	}
}
