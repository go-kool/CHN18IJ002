package com.cts.payroll.model;

public class Under60TaxCategory extends TaxCategory {

	private static final Slab[] UNDER_60 = {
			new Slab(0f, 250000f, 0f),
			new Slab(250001f, 500000f, 0.05f),
			new Slab(500001f, 1000000f, 0.2f),
			new Slab(1000000f, Float.MAX_VALUE, 0.3f)
		};

	public Under60TaxCategory() {
		super(Under60TaxCategory.UNDER_60);
	}

}
