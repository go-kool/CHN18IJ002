package com.cts.payroll.app;

import java.util.Comparator;

import com.cts.payroll.model.Employee;

public class EmployeeNameComparator implements Comparator<Employee> {
	
	public int compare(Employee e1, Employee e2) {
		String name1 = e1.getName();
		String name2 = e2.getName();
		return name1.compareTo(name2);
	}

}