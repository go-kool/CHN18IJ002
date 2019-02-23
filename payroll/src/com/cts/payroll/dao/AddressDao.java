package com.cts.payroll.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.cts.payroll.app.PayrollException;
import com.cts.payroll.bean.Address;

public class AddressDao {
	
	private static final String UPDATE_ADDRESS_QUERY = 
			"update address set ad_line1 = ?, ad_line2 = ?, " +
			"ad_locality = ?, ad_city = ?, ad_pincode = ? where ad_id = ?";

	public void updateAddress(Address address) throws PayrollException {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			connection = ConnectionManager.getConnection();
			statement = connection.prepareStatement(UPDATE_ADDRESS_QUERY);
			statement.setString(1, address.getLine1());
			statement.setString(2, address.getLine2());
			statement.setString(3, address.getLocality());
			statement.setString(4, address.getCity());
			statement.setString(5, address.getPincode());
			statement.setInt(6, address.getId());
			statement.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new PayrollException("Error when updating address. " 
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
