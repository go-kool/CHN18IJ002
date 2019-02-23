package com.cts.payroll.app;

import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.cts.payroll.model.Employee;
import com.cts.payroll.model.TaxCategory;
import com.cts.payroll.model.Under60TaxCategory;
import com.cts.payroll.model.Above60Under80TaxCategory;
import com.cts.payroll.model.Above80TaxCategory;

public class TaxCalculator {
	
	public void processTax() {
		try {
			EmployeeFileReader reader = 
				new EmployeeFileReader("D:\\employee1.csv");

			ArrayList<Employee> employeeList = reader.getEmployeeList();
			/*ArrayList<TaxCalculatorThread> threads = 
				new ArrayList<TaxCalculatorThread>();*/
			ExecutorService executor = Executors.newFixedThreadPool(1000);
			for (Employee employee : employeeList) {
				int age = employee.getAge();
				TaxCategory taxCategory = null;
				if (age < 60) {
					taxCategory = new Under60TaxCategory();
				} else if (age > 60 &&  age < 80) {
					taxCategory = new Above60Under80TaxCategory();
				} else if (age > 80) {
					taxCategory = new Above80TaxCategory();
				}
				float annualIncome = employee.getAnnualIncome();
				TaxCalculatorThread thread = 
					new TaxCalculatorThread(taxCategory, employee);
				executor.execute(thread);
				//thread.start();
				//threads.add(thread);
			}
			/*for (TaxCalculatorThread thread : threads) {
				try {
					thread.join();
				} catch(InterruptedException e) {
					e.printStackTrace();
				}
			}*/
			executor.shutdown();
			while(!executor.isTerminated()) {
			}

			/*Collections.sort(employeeList, new EmployeeNameComparator());
			for (Employee employee: employeeList) {
				System.out.println(employee);
			}*/
		} catch (PayrollAppException e) {
			e.printStackTrace();
			System.out.println("Inside PayrollAppException.");
			try {
				ErrorLogWriter.logError(e.getMessage());
			} catch (PayrollAppException pe) {
			}
		}
	}
	
	public static void main(String args[]) {
		long start = System.currentTimeMillis();
		TaxCalculator taxCalculator = new TaxCalculator();
		taxCalculator.processTax();
		long end = System.currentTimeMillis();
		
		System.out.println(((end - start) / 1000) + " Seconds");
	}
}
