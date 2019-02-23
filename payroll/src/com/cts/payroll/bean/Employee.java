package com.cts.payroll.bean;

import java.util.Date;

public class Employee {

	private int id;
	private String name;
	private Date dateOfBirth;
	private String gender;
	private int salary;
	private String email;
	private String skills;
	private Address address;
	private Department department;

	public Employee(int id, String name, Date dateOfBirth, int salary, String email, Address address, Department department) {
		super();
		this.id = id;
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.salary = salary;
		this.address = address;
		this.email = email;
		this.department = department;
	}

	public Employee() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getSkills() {
		return skills;
	}

	public void setSkills(String skills) {
		this.skills = skills;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Employee [id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append(", dateOfBirth=");
		builder.append(dateOfBirth);
		builder.append(", salary=");
		builder.append(salary);
		builder.append(", address=");
		builder.append(address);
		builder.append(", department=");
		builder.append(department);
		builder.append("]");
		return builder.toString();
	}

}
