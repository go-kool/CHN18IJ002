package com.cts.payroll.model;

public class Slab {
	private float start;
	private float end;
	private float taxPercent;
	
	public Slab(float start, float end, float taxPercent) {
		this.start = start;
		this.end = end;
		this.taxPercent = taxPercent;
	}
	
	public float calculateTax(float annualIncome) {
		float tax = 0.0f;
		
		if (annualIncome > start && annualIncome < end) {
			tax = (annualIncome - start) * taxPercent;
		}
		
		if (annualIncome > end) {
			tax = (end - start) * taxPercent;
		}
		
		return tax;
	}
}