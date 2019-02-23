package com.cts.payroll.app;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import com.cts.payroll.model.Employee;

public class EmployeeFileReader {
	
	private ArrayList<Employee> employeeList;
	
	public EmployeeFileReader(String fileNameWithPath) 
				throws PayrollAppException {
		FileReader fileReader = null;
		BufferedReader reader = null;
		employeeList = new ArrayList<Employee>();
		try {
			fileReader = new FileReader(fileNameWithPath);
			reader = new BufferedReader(fileReader);
			
			String line = reader.readLine();
			
			while (line != null) {
				Employee employee = new Employee(line);
				employeeList.add(employee);
				line = reader.readLine();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new PayrollAppException("Data file '" 
				+ fileNameWithPath + "' not found. Exception message: " 
				+ e.getMessage());
		} catch (IOException e) {
			e.printStackTrace();
			throw new PayrollAppException("Error when reading file '" 
				+ fileNameWithPath + "'. Exception message: " 
				+ e.getMessage());
		} finally {
			try {
				if (fileReader != null) {
					fileReader.close();
				}
				if (reader != null) {
					reader.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public ArrayList<Employee> getEmployeeList() {
		return employeeList;
	}
	
	public static void main(String args[]) throws PayrollAppException {
		EmployeeFileReader reader = 
			new EmployeeFileReader("D:\\TaxProcessor\\emp-dta.csv");
	}
}
