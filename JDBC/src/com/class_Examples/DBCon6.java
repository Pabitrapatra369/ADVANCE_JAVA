package com.class_Examples;
import java.sql.*;
public class DBCon6 {
	public static void main(String[] args) {
        try {
        	Class.forName("oracle.jdbc.driver.OracleDriver");
        	Connection con = DriverManager.getConnection
        	("jdbc:oracle:thin:@localhost:1521:xe","system","tiger");
        	System.out.println("*******************Statement******************");
        	Statement stm = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
        			ResultSet.CONCUR_READ_ONLY);
        	ResultSet rs1 = stm.executeQuery("select * from Product69");
        	System.out.println("======row-3========");
        	rs1.absolute(3);
        	System.out.println(rs1.getString(1)+"\t"+rs1.getString(2)+"\t"
        			+rs1.getFloat(3)+"\t"+rs1.getInt(4));
        	System.out.println("======relative(+2)========");
        	rs1.relative(+2);
        	System.out.println(rs1.getString(1)+"\t"+rs1.getString(2)+"\t"
        			+rs1.getFloat(3)+"\t"+rs1.getInt(4));
        	System.out.println("======relative(-1)========");
        	rs1.relative(-1);
        	System.out.println(rs1.getString(1)+"\t"+rs1.getString(2)+"\t"
        			+rs1.getFloat(3)+"\t"+rs1.getInt(4));
        	System.out.println("=====first row======");
        	rs1.first();
        	System.out.println(rs1.getString(1)+"\t"+rs1.getString(2)+"\t"
        			+rs1.getFloat(3)+"\t"+rs1.getInt(4));
        	System.out.println("=====last row======");
        	rs1.last();
        	System.out.println(rs1.getString(1)+"\t"+rs1.getString(2)+"\t"
        			+rs1.getFloat(3)+"\t"+rs1.getInt(4));
        	System.out.println("*************PreparedStatement***************");
        	PreparedStatement ps = con.prepareStatement("select * from Product69",
        			ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
        	ResultSet rs2 = ps.executeQuery();
        	rs2.afterLast();
        	System.out.println("-----Product details in reverse-------");
        	while(rs2.previous()) {
        		System.out.println(rs2.getString(1)+"\t"+rs2.getString(2)+"\t"
            			+rs2.getFloat(3)+"\t"+rs2.getInt(4));
        	}//end of loop
        	con.close();
        }catch(Exception e) {
        	e.printStackTrace();
        }
	}
}


