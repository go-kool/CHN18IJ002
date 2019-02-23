package com.cts.payroll.model;

public class Above60Under80TaxCategory extends TaxCategory {

	private static final Slab[] ABOVE_60_UNDER_80 = {
			new Slab(0f, 300000f, 0f),
			new Slab(300001f, 500000f, 0.05f),
			new Slab(500001f, 1000000f, 0.2f),
			new Slab(1000000f, Float.MAX_VALUE, 0.3f)
		};

	public Above60Under80TaxCategory() {
		super(Above60Under80TaxCategory.ABOVE_60_UNDER_80);
	}

}
