package com.cts.payroll.model;

public class Above80TaxCategory extends TaxCategory {

	private static final Slab[] ABOVE_80 = {
			new Slab(0f, 500000f, 0f),
			new Slab(500001f, 1000000f, 0.2f),
			new Slab(1000000f, Float.MAX_VALUE, 0.3f)
		};

	public Above80TaxCategory() {
		super(Above80TaxCategory.ABOVE_80);
	}

}
