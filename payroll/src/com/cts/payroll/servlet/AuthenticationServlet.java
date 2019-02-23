package com.cts.payroll.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cts.payroll.app.PayrollException;
import com.cts.payroll.bean.Employee;
import com.cts.payroll.bean.User;
import com.cts.payroll.dao.EmployeeDao;
import com.cts.payroll.dao.UserDao;

public class AuthenticationServlet extends HttpServlet {
	
	public void init() throws ServletException {
		System.out.println("inside init() method");
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
				throws IOException, ServletException {
		String forwardUrl = "login.jsp";
		String error = "";
		try {
			System.out.println("Inside doPost()");
			String userName = request.getParameter("username");
			String password = request.getParameter("password");
			
			UserDao dao = new UserDao();
			User user = dao.getUser(userName);
			
			if (user != null && user.getPassword().equals(password)) {
				EmployeeDao employeeDao = new EmployeeDao();
				List<Employee> employees = employeeDao.getEmployees();
				System.out.println(employees.size());
				request.setAttribute("employees", employees);
				forwardUrl = "emplist.jsp";
			} else {
				error = "Invalid Username or Password.";
				request.setAttribute("userName", userName);
			}
		} catch (PayrollException e) {
			forwardUrl = "login.jsp";
			error = "System Error. Please retry or contact admin.";
		}
		request.setAttribute("error", error);
		RequestDispatcher rd = request.getRequestDispatcher(forwardUrl);
		rd.forward(request, response);
	}

	public void destroy() {
		System.out.println("inside destroy() method");
	}
	
}
