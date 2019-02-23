package com.cts.payroll.model;

import java.util.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.Period;
import java.text.SimpleDateFormat;
import java.text.ParseException;

public class Employee implements Comparable<Employee> {
	private int id;
	private String name;
	private LocalDate dateOfBirth;
	private float annualIncome;
	private String email;
	private float tax;
	private Address address;
	
	public Employee() {
	}

	public Employee(int id, String name, LocalDate dateOfBirth, 
			float annualIncome) {
		this.id = id;
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.annualIncome = annualIncome;
	}
	
	public Employee(String details) {
		String data[] = details.split(",");
		this.id = Integer.parseInt(data[0]);
		this.name = data[1];
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		this.dateOfBirth = LocalDate.parse(data[2], formatter);
		this.annualIncome = Float.parseFloat(data[3]);
		this.email = data[4];
		this.address = new Address(data);
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
	
	public int getAge() {
		return Period.between(dateOfBirth, LocalDate.now()).getYears();
	}
	
	public float getAnnualIncome() {
		return annualIncome;
	}
	
	public void setTax(float tax) {
		this.tax = tax;
	}
	
	public float getTax() {
		return tax;
	}
	
	public int compareTo(Employee employee) {
		int otherId = employee.getId();
		int result = 0;
		System.out.println("compareTo: " + this.id + ", " + otherId);
		if (this.id < otherId) {
			result = -1;
		}
		
		if (this.id == otherId) {
			result = 0;
		}
		
		if (this.id > otherId) {
			result = 1;
		}
		return result;
	}
	
	public String toString() {
		return 
			"[id=" + id + ";" +
			"name=" + name + ";" +
			"dateOfBirth=" + dateOfBirth + ";" +
			"age=" + getAge() + ";" +
			"annualIncome=" + annualIncome + ";" +
			"tax=" + tax + ";" +
			"address=" + address + "]" ;
	}
	
	public int hashCode() {
		System.out.println("hashCode: " + id);
		return id;
	}
	
	public boolean equals(Object object) {
		Employee employee = (Employee) object;
		System.out.println("equals: this=" + id + 
			"; other: " + employee.getId());
		/*return (this.id == employee.getId() && 
			this.name.equals(employee.getName()));*/
		return this.id == employee.getId();
		/*if (this.id == employee.getId() && 
			this.name.equals(employee.getName())) {
			return true;
		} else {
			return false;
		}*/
	}
	
	public void finalize() {
		System.out.println("inside finalize.");
	}
	
	public static void main(String args[]) {
		Employee employee = 
			new Employee("1,John,31/07/2000,500000,john@email.com,51 Ram Street,Venkat Nagar,Thoraipakkam,Chennai,600001");
		
		employee = null;
		
		System.gc();
		
		ArrayList<Transaction> transactions = TransactionReader.getTransactions();
		
		Map<String, ArrayList<Transaction>> map = 
			new HashMap<String, ArrayList<Transaction>>();

		for (Transaction transaction : transactions) {
			if (!map.containsKey(creditCardNumber)) {
				ArrayList<Transaction> cardTransactions = new ArrayList<Transaction>();
				cardTransactions.add(transaction);
				map.put(creditCardNumber, cardTransactions);
			} else {
				ArrayList<Transaction> cardTransactions = map.get(creditCardNumber);
				cardTransactions.add(transaction);
			}
		}
		
		
		map.put(creditCardNumber, 
		
		/*Employee e1 = employee;
		
		Employee e2 = new Employee("1,John,31/07/2000,500000,john@email.com,51 Ram Street,Venkat Nagar,Thoraipakkam,Chennai,600001");
		
		System.out.println("e1 == employee : " + (e1 == employee));
		
		System.out.println("e1 == e2 : " + (e1 == e2));
		
		System.out.println("e1.equals(employee) : " + (e1.equals(employee)));
		
		System.out.println("e1.equals(e2) : " + (e1.equals(e2)));*/
		//System.out.println(employee);
		
	}
}
