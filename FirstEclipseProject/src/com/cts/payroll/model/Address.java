package com.cts.payroll.model;

public class Address {

	private String addressLine1;
	private String addressLine2;
	private String locality;
	private String city;
	private String pincode;
	
	public Address(String[] data) {
		this.addressLine1 = data[5];
		this.addressLine2 = data[6];
		this.locality = data[7];
		this.city = data[8];
		this.pincode = data[9];
	}

	public Address(String addressLine1, String addressLine2, String locality, String city, String pincode) {
		super();
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.locality = locality;
		this.city = city;
		this.pincode = pincode;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
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
		builder.append("Address [addressLine1=");
		builder.append(addressLine1);
		builder.append(", addressLine2=");
		builder.append(addressLine2);
		builder.append(", locality=");
		builder.append(locality);
		builder.append(", city=");
		builder.append(city);
		builder.append(", pincode=");
		builder.append(pincode);
		builder.append("]");
		return builder.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((addressLine1 == null) ? 0 : addressLine1.hashCode());
		result = prime * result + ((addressLine2 == null) ? 0 : addressLine2.hashCode());
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((locality == null) ? 0 : locality.hashCode());
		result = prime * result + ((pincode == null) ? 0 : pincode.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Address other = (Address) obj;
		if (addressLine1 == null) {
			if (other.addressLine1 != null)
				return false;
		} else if (!addressLine1.equals(other.addressLine1))
			return false;
		if (addressLine2 == null) {
			if (other.addressLine2 != null)
				return false;
		} else if (!addressLine2.equals(other.addressLine2))
			return false;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (locality == null) {
			if (other.locality != null)
				return false;
		} else if (!locality.equals(other.locality))
			return false;
		if (pincode == null) {
			if (other.pincode != null)
				return false;
		} else if (!pincode.equals(other.pincode))
			return false;
		return true;
	}
	
	public static void main(String args[]) {
		Address address = new Address("address1", "address 2", 
				"locality", "city", "pincode");
		
		System.out.println(address);
	}
	
}
