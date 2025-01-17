package com.pk.jdbc_tasks;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

record Employee(int id, String name, int age, double salary) implements Comparable<Object> 
{

	@Override
	public int compareTo(Object o) {
		Employee e = (Employee)o;
		return (int) (e.salary-this.salary);
	}
}

public class JDBC_EMP_FILTERATION {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		try {
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","C##BATCH37","PKP");
			PreparedStatement prepareStatement1=con.prepareStatement("select * from employee");
			
			//storing employee details in list of employee objects
			List<Employee> listOfEmployee=new ArrayList();
			ResultSet rs=prepareStatement1.executeQuery();
			while(rs.next()) {
				listOfEmployee.add(new Employee(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getDouble(4)));
			}
			
			   
			//showing the employee data
			Iterator<Employee> iterator = listOfEmployee.iterator();
			iterator.forEachRemaining(System.out::println);
			
			
			//showing the employees whose salary is greater than 25000
			System.out.println("..............................................................");
			for(Employee emp:listOfEmployee) {
				if(emp.salary()>25000)
				System.out.println(emp);
			}
			System.out.println("..............................................................");

			//Sort the employees by salary in descending order.
			Collections.sort(listOfEmployee);
			for(Employee emp:listOfEmployee) {
				System.out.println(emp);
			}
			System.out.println("..............................................................");

			//displaing top two employee details
			for(int i=0;i<2;i++)
			{
				System.out.println(listOfEmployee.get(i));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}