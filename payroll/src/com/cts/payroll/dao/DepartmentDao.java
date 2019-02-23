package com.cts.payroll.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cts.payroll.app.PayrollException;
import com.cts.payroll.bean.Department;

public class DepartmentDao {

	private static final String GET_ALL_DEPT_QUERY = 
			"select * from department";
	
	public List<Department> getDepartments() 
			throws PayrollException {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		List<Department> departments = new ArrayList<Department>();
		try {
			connection = ConnectionManager.getConnection();
			statement = connection.prepareStatement(GET_ALL_DEPT_QUERY);
			resultSet = statement.executeQuery();
			
			while (resultSet.next()) {
				Department department = new Department();
				department.setId(resultSet.getInt("DP_ID"));
				department.setName(resultSet.getString("DP_NAME"));
				departments.add(department);
				System.out.println(department);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new PayrollException("Error when getting all departments. " 
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

		return departments;
	}
}
