package com.cts.payroll.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cts.payroll.app.PayrollException;
import com.cts.payroll.bean.Department;
import com.cts.payroll.bean.Skill;

public class SkillDao {

	private static final String GET_ALL_SKILL_QUERY = 
			"select * from skill";
	
	public List<Skill> getSkills() 
			throws PayrollException {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		List<Skill> skills = new ArrayList<Skill>();
		try {
			connection = ConnectionManager.getConnection();
			statement = connection.prepareStatement(GET_ALL_SKILL_QUERY);
			resultSet = statement.executeQuery();
			
			while (resultSet.next()) {
				Skill skill = new Skill();
				skill.setId(resultSet.getInt("SK_ID"));
				skill.setName(resultSet.getString("SK_NAME"));
				skills.add(skill);
				System.out.println(skill);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new PayrollException("Error when getting all skills. " 
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

		return skills;
	}
}
