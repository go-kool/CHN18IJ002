package com.cts.payroll.bean;

public class Address {

	private int id;
	private String line1;
	private String line2;
	private String locality;
	private String city;
	private String pincode;

	public Address() {

	}

	public Address(int id, String line1, String line2, String locality, String city, String pincode) {
		super();
		this.id = id;
		this.line1 = line1;
		this.line2 = line2;
		this.locality = locality;
		this.city = city;
		this.pincode = pincode;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLine1() {
		return line1;
	}

	public void setLine1(String line1) {
		this.line1 = line1;
	}

	public String getLine2() {
		return line2;
	}

	public void setLine2(String line2) {
		this.line2 = line2;
	}

	public String getLocality() {
		return locality;
	}

	public void setLocality(String locality) {
		this.locality = locality;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Address [id=");
		builder.append(id);
		builder.append(", line1=");
		builder.append(line1);
		builder.append(", line2=");
		builder.append(line2);
		builder.append(", locality=");
		builder.append(locality);
		builder.append(", city=");
		builder.append(city);
		builder.append(", pincode=");
		builder.append(pincode);
		builder.append("]");
		return builder.toString();
	}

}
