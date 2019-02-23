package com.cts.payroll.app;

import java.util.HashSet;
import com.cts.payroll.model.Employee;

public class HashSetTest {
	
	public static void main(String args[]) {
		Employee e1 = new Employee("1,John,31/07/2000,500000,john@email.com,51 Ram Street,Venkat Nagar,Thoraipakkam,Chennai,600001");
		Employee e2 = new Employee("2,Smith,31/07/2000,500000,john@email.com,51 Ram Street,Venkat Nagar,Thoraipakkam,Chennai,600001");
		Employee e3 = new Employee("3,James,31/07/2000,500000,john@email.com,51 Ram Street,Venkat Nagar,Thoraipakkam,Chennai,600001");
		Employee e4 = new Employee("1,James,31/07/2000,500000,john@email.com,51 Ram Street,Venkat Nagar,Thoraipakkam,Chennai,600001");
		
		HashSet<Employee> employees = new HashSet<Employee>();
		employees.add(e1);
		employees.add(e2);
		employees.add(e3);
		employees.add(e4);
		
		System.out.println(employees);
	}
}