package com.cts.payroll.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cts.payroll.app.PayrollException;
import com.cts.payroll.dao.DepartmentDao;
import com.cts.payroll.dao.EmployeeDao;
import com.cts.payroll.dao.SkillDao;

@WebServlet("/showemployee")
public class ShowEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ShowEmployeeServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) 
			throws ServletException, IOException {
		int employeeId = Integer.parseInt(request.getParameter("id"));
		EmployeeDao employeeDao = new EmployeeDao();
		DepartmentDao departmentDao = new DepartmentDao();
		SkillDao skillDao = new SkillDao();
		String error = "";
		try {
			request.setAttribute("employee", employeeDao.getEmployee(employeeId));
			request.setAttribute("departments", departmentDao.getDepartments());
			request.setAttribute("skills", skillDao.getSkills());
		} catch (PayrollException e) {
			e.printStackTrace();
			error = "System error. Retry or call administrator.";
		}
		request.setAttribute("error", error);
		RequestDispatcher rd = request.getRequestDispatcher("updateemp.jsp");
		rd.forward(request, response);
	}

}
