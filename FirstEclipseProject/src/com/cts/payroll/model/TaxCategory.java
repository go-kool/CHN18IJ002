package com.cts.payroll.model;

import com.cts.payroll.app.PayrollAppException;

public abstract class TaxCategory {
	private Slab[] slabs;
	
	//abstract public float calculateTaxNew();
	
	public TaxCategory(Slab[] slabs) {
		this.slabs = slabs;
	}
	
	public float calculateTax(float annualIncome)
			throws PayrollAppException {
		float totalTax = 0.0f;
		
		for (Slab slab : slabs) {
			totalTax += slab.calculateTax(annualIncome);
		}
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
			throw new PayrollAppException("Thread interrupted");
		}
		
		return totalTax;
	}
}
