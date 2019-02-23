package com.cts.payroll.app;
import com.cts.payroll.model.TaxCategory;
import com.cts.payroll.model.Employee;

public class TaxCalculatorThread extends Thread {
	
	private static int counter = 0;
	
	private TaxCategory taxCategory;
	private Employee employee;
	
	public TaxCalculatorThread(TaxCategory taxCategory, 
			Employee employee) {
		this.taxCategory = taxCategory;
		this.employee = employee;
	}

	public void run() {
		try {
			float annualIncome = employee.getAnnualIncome();
			float tax = taxCategory.calculateTax(annualIncome);
			employee.setTax(tax);
			synchronized (TaxCalculator.class) {
				System.out.print(++counter + " ");
			}
		} catch(PayrollAppException e) {
			e.printStackTrace();
		}
	}

}
