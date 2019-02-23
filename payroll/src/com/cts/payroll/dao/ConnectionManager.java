package com.cts.payroll.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.cts.payroll.app.PayrollException;

public class ConnectionManager {
	
	public static Connection getConnection() throws PayrollException {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = 
				DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/payroll",
					"root",
					"root"
				);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new PayrollException("Error when loading JDBC driver. " 
					+ e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new PayrollException("Error when connecting to DB. " 
					+ e.getMessage());
		}
		return connection;
	}

}
