package com.pk.basics;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

class Employee{
	int id;
	String name;
	int age;
	double salary;
	public Employee(int id, String name, int age, double salary) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", age=" + age + ", salary=" + salary + "]";
	}
	
	
	
}
public class JDBC_EMPLOYEE_STORE_APP {
	public static void main(String[] args) {
		List<Employee> empData=new ArrayList<>();
		try {
			Connection con =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","C##BATCH37","PKP");
			Statement smt=con.createStatement();
			ResultSet rs=smt.executeQuery("select * from Employee");
			while(rs.next())
			{
				
				empData.add(new Employee(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getDouble(4)));
				
			}
		
			System.out.println(empData);
			//empData.forEach(i->System.out.println(i));
		}
		catch(Exception e)
		{
		e.printStackTrace();	
		}
	}
}
