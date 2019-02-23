package com.cts.payroll.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.cts.payroll.app.PayrollException;
import com.cts.payroll.bean.Address;

public class EmployeeSkillDao {

	private static final String DELETE_EMP_SKILLS = 
			"delete from employee_skill where es_em_id = ?";

	private static final String INSERT_EMP_SKILL = 
			"insert into employee_skill (es_em_id, es_sk_id) values (?, ?)";

	public void deleteEmployeeSkills(int employeeId) throws PayrollException {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			connection = ConnectionManager.getConnection();
			statement = connection.prepareStatement(DELETE_EMP_SKILLS);
			statement.setInt(1, employeeId);
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new PayrollException("Error when deleting skills. " 
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

	public void insertEmployeeSkills(int employeeId, String[] skillIds) 
			throws PayrollException {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			connection = ConnectionManager.getConnection();
			statement = connection.prepareStatement(INSERT_EMP_SKILL);
			for (String skillId : skillIds) {
				statement.setInt(1, employeeId);
				statement.setInt(2, Integer.parseInt(skillId));
				statement.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new PayrollException("Error when deleting skills. " 
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
