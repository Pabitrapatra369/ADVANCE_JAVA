package com.pk.jdbc_tasks;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class JDBC_EMPLOYEE69_OPERATION {

	public static void main(String[] args) throws ClassNotFoundException {
		Scanner sc = new Scanner(System.in);
		Class.forName("oracle.jdbc.driver.OracleDriver");

		try (sc) {
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "c##batch37", "PKP");
			PreparedStatement ps1 = con.prepareStatement("select * from employee69");
			PreparedStatement ps2 = con.prepareStatement("insert into employee69 values(?,?,?,?,?,?,?)");
			PreparedStatement ps3=con.prepareStatement("select * from employee69 where eid=?");
			PreparedStatement ps4=con.prepareStatement("update employee69 set bsal=?,hra=?,da=?,totsal=? where eid=?");
			PreparedStatement ps5=con.prepareStatement("delete from employee69 where eid=?");

			Integer choice = 0;
			while (true) {
				System.out.println("Meke One choice:");
				System.out.println("             1.AddEmployee\r\n" + "             2.ViewAllEmployees\r\n"
						+ "             3.ViewEmployeeById\r\n"
						+ "             4.UpdateEmployeeById(bSal,hra,da,totSal)\r\n"
						+ "             5.DeleteEmployeeById\r\n" + "             6.exit");
				System.out.print("Enter your choice:");
				choice = Integer.parseInt(sc.nextLine());
				switch (choice) {
				case 1: {
					System.out.print("Enter Employee Id");
					Integer id = Integer.parseInt(sc.nextLine());
					System.out.print("Enter Employee Name");
					String name = sc.nextLine();
					System.out.print("Enter Employee designation");
					String degn = sc.nextLine();
					System.out.print("Enter Employee base salary");
					Double bsal = Double.parseDouble(sc.nextLine());

					Double hra = bsal * 0.91;
					Double da = bsal * 0.63;
					Double totsal = bsal + hra + da;

					ps2.setInt(1, id);
					ps2.setString(2, name);
					ps2.setString(3, degn);
					ps2.setDouble(4, bsal);
					ps2.setDouble(5, hra);
					ps2.setDouble(6, da);
					ps2.setDouble(7, totsal);

					int addEmployee = ps2.executeUpdate();
					if (addEmployee > 0)
						System.out.println("Employee Added successfully..");
					else
						System.out.println("Employee not added");
					break;

				}
				case 2: {
					ResultSet rs = ps1.executeQuery();
					while (rs.next()) {
						System.out.println(rs.getInt(1) + "--------" + rs.getString(2) + "---------" + rs.getString(3)
								+ "----------" + rs.getDouble(4) + "--------" + rs.getDouble(5) + "---------"
								+ rs.getDouble(6) + "--------" + rs.getDouble(7));
					}
					break;

				}
				case 3: {
					System.out.print("Enter the employee id:");
					int eid=Integer.parseInt(sc.nextLine());
					ps3.setInt(1, eid);
					ResultSet rs=ps3.executeQuery();
					if(rs.next()) {
						System.out.println(rs.getInt(1) + "--------" + rs.getString(2) + "---------" + rs.getString(3)
						+ "----------" + rs.getDouble(4) + "--------" + rs.getDouble(5) + "---------"
						+ rs.getDouble(6) + "--------" + rs.getDouble(7));
					}
					else {
						System.err.println("Employee id is not valid");
					}
					break;

				}
				case 4: {
					System.out.print("Enter the employee id:");
					int eid=Integer.parseInt(sc.nextLine());
					ps3.setInt(1, eid);
					ResultSet rs=ps3.executeQuery();
					if(rs.next())System.out.println("Old base sal="+rs.getDouble(4));
					
					System.out.print("Enter Employee new base salary:");
					Double bsal = Double.parseDouble(sc.nextLine());

					Double hra = bsal * 0.91;
					Double da = bsal * 0.63;
					Double totsal = bsal + hra + da;

					
					ps4.setDouble(1, bsal);
					ps4.setDouble(2, hra);
					ps4.setDouble(3, da);
					ps4.setDouble(4, totsal);
					ps4.setInt(5, eid);
					int salaryUpdated=ps4.executeUpdate();
					if(salaryUpdated>0)System.out.println("You have successfully updated the salary of "+rs.getString(2));
					else System.err.println("salary updation unsuccessfull!!!");
					break;

				}
				case 5: {
					System.out.print("Enter the employee id:");
					int eid=Integer.parseInt(sc.nextLine());
					ps3.setInt(1, eid);
					ResultSet rs=ps3.executeQuery();
					if(rs.next())System.out.println("eid:"+rs.getInt(1)+"    employee name:"+rs.getString(2));
					
					ps5.setInt(1, eid);
					int isDeleted=ps5.executeUpdate();
					
					if(isDeleted>0)System.out.println("You have successfully deleted eid: "+rs.getInt(1)+",name:"+rs.getString(2));
					else System.err.println("salary deletion unsuccessfull!!!");
					break;

				}
				case 6: {
					System.out.println("Thank you for our app!!!");
					con.close();
					System.exit(0);
					;
				}
				default:
					System.out.println("You entered a wrong choice.");
				}
				
			}
			
		} catch (

		SQLException e) {
			e.printStackTrace();
		}

	}

}
