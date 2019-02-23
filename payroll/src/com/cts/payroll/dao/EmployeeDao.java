package com.cts.payroll.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cts.payroll.app.PayrollException;
import com.cts.payroll.bean.Address;
import com.cts.payroll.bean.Department;
import com.cts.payroll.bean.Employee;

public class EmployeeDao {
	
	private static final String GET_ALL_EMP_QUERY = 
			"select  em_id, em_name, em_gender, em_salary, dp_id, dp_name, \r\n" + 
			"        em_date_of_birth, em_email, ad_id, ad_line1, \r\n" + 
			"        ad_line2, ad_locality, ad_city, ad_pincode,\r\n" + 
			"        group_concat(distinct sk_name separator ', ') skills\r\n" + 
			"from    ((((employee inner join address on em_ad_id = ad_id) \r\n" + 
			"        inner join department on em_dp_id = dp_id)\r\n" + 
			"        inner join employee_skill on em_id = es_em_id)\r\n" + 
			"        inner join skill on sk_id = es_sk_id)\r\n" + 
			"group by em_id, em_name, em_gender, em_salary, dp_id, dp_name, \r\n" + 
			"        em_date_of_birth, em_email, ad_id, ad_line1, \r\n" + 
			"        ad_line2, ad_locality, ad_city, ad_pincode";
	
	private static final String GET_EMP_QUERY = 
			"select  em_id, em_name, em_gender, em_salary, dp_id, dp_name, \r\n" + 
			"        em_date_of_birth, em_email, ad_id, ad_line1, \r\n" + 
			"        ad_line2, ad_locality, ad_city, ad_pincode,\r\n" + 
			"        group_concat(distinct sk_name separator ', ') skills\r\n" + 
			"from    ((((employee inner join address on em_ad_id = ad_id) \r\n" + 
			"        inner join department on em_dp_id = dp_id)\r\n" + 
			"        inner join employee_skill on em_id = es_em_id)\r\n" + 
			"        inner join skill on sk_id = es_sk_id)\r\n" + 
			"where   em_id = ? " + 
			"group by em_id, em_name, em_gender, em_salary, dp_id, dp_name, \r\n" + 
			"        em_date_of_birth, em_email, ad_id, ad_line1, \r\n" + 
			"        ad_line2, ad_locality, ad_city, ad_pincode";
	
	private static final String UPDATE_EMP_QUERY = 
			"update employee set em_name = ?, em_date_of_birth = ?, " +
			"em_salary = ?, em_dp_id = ?, em_email = ?, em_gender = ? " +
			"where em_id = ?";
	
	public List<Employee> getEmployees() 
			throws PayrollException {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		List<Employee> employees = new ArrayList<Employee>();
		try {
			connection = ConnectionManager.getConnection();
			statement = connection.prepareStatement(GET_ALL_EMP_QUERY);
			resultSet = statement.executeQuery();
			
			while (resultSet.next()) {
				Employee employee = new Employee();
				employee.setId(resultSet.getInt("EM_ID"));
				employee.setName(resultSet.getString("EM_NAME"));
				employee.setDateOfBirth(resultSet.getDate("EM_DATE_OF_BIRTH"));
				employee.setSalary(resultSet.getInt("EM_SALARY"));
				employee.setGender(resultSet.getString("EM_GENDER"));
				employee.setEmail(resultSet.getString("EM_EMAIL"));
				employee.setSkills(resultSet.getString("SKILLS"));
				Address address = new Address();
				address.setId(resultSet.getInt("AD_ID"));
				address.setLine1(resultSet.getString("AD_LINE1"));
				address.setLine2(resultSet.getString("AD_LINE2"));
				address.setLocality(resultSet.getString("AD_LOCALITY"));
				address.setCity(resultSet.getString("AD_CITY"));
				address.setPincode(resultSet.getString("AD_PINCODE"));
				Department department = new Department();
				department.setId(resultSet.getInt("DP_ID"));
				department.setName(resultSet.getString("DP_NAME"));
				employee.setAddress(address);
				employee.setDepartment(department);
				employees.add(employee);
				System.out.println(employee);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new PayrollException("Error when getting user data. " + e.getMessage());
		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
				if (statement != null) {
					statement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
				throw new PayrollException("Error when closing connection. " + e.getMessage());
			}
		}

		return employees;
	}


	public Employee getEmployee(int id) throws PayrollException {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		Employee employee = null;
		try {
			connection = ConnectionManager.getConnection();
			statement = connection.prepareStatement(GET_EMP_QUERY);
			statement.setInt(1, id);
			resultSet = statement.executeQuery();
			
			if (resultSet.next()) {
				employee = new Employee();
				employee.setId(resultSet.getInt("EM_ID"));
				employee.setName(resultSet.getString("EM_NAME"));
				employee.setDateOfBirth(resultSet.getDate("EM_DATE_OF_BIRTH"));
				employee.setSalary(resultSet.getInt("EM_SALARY"));
				employee.setGender(resultSet.getString("EM_GENDER"));
				employee.setEmail(resultSet.getString("EM_EMAIL"));
				employee.setSkills(resultSet.getString("SKILLS"));
				Address address = new Address();
				address.setId(resultSet.getInt("AD_ID"));
				address.setLine1(resultSet.getString("AD_LINE1"));
				address.setLine2(resultSet.getString("AD_LINE2"));
				address.setLocality(resultSet.getString("AD_LOCALITY"));
				address.setCity(resultSet.getString("AD_CITY"));
				address.setPincode(resultSet.getString("AD_PINCODE"));
				Department department = new Department();
				department.setId(resultSet.getInt("DP_ID"));
				department.setName(resultSet.getString("DP_NAME"));
				employee.setAddress(address);
				employee.setDepartment(department);
				System.out.println(employee);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new PayrollException("Error when getting user data. " + e.getMessage());
		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
				if (statement != null) {
					statement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
				throw new PayrollException("Error when closing connection. " + e.getMessage());
			}
		}

		return employee;
	}

	public void updateEmployee(Employee employee) throws PayrollException {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			connection = ConnectionManager.getConnection();
			statement = connection.prepareStatement(UPDATE_EMP_QUERY);
			statement.setString(1, employee.getName());
			Date dateOfBirth = 
				new Date(employee.getDateOfBirth().getTime());
			statement.setDate(2, dateOfBirth);
			statement.setInt(3, employee.getSalary());
			statement.setInt(4, employee.getDepartment().getId());
			statement.setString(5, employee.getEmail());
			statement.setString(6, employee.getGender());
			statement.setInt(7, employee.getId());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new PayrollException("Error when updating employee. " 
					+ e.getMessage());
		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
				if (statement != null) {
					statement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
				throw new PayrollException("Error when closing connection. " + e.getMessage());
			}
		}
	}
}
