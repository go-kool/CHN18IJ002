package com.cts.payroll.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.cts.payroll.app.PayrollException;
import com.cts.payroll.bean.User;

public class UserDao {

	public User getUser(String userName) throws PayrollException {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		User user = null;
		try {
			connection = ConnectionManager.getConnection();
			String query = "select * from user where us_username = ?";
			statement = connection.prepareStatement(query);
			statement.setString(1, userName);
			resultSet = statement.executeQuery();
			
			if (resultSet.next()) {
				user = new User();
				user.setId(resultSet.getInt("US_ID"));
				user.setUserName(resultSet.getString("US_USERNAME"));
				user.setPassword(resultSet.getString("US_PASSWORD"));
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

		return user;
	}

}
