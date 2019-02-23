package com.cts.payroll.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cts.payroll.app.PayrollException;
import com.cts.payroll.bean.Address;
import com.cts.payroll.bean.Department;
import com.cts.payroll.bean.Employee;
import com.cts.payroll.dao.AddressDao;
import com.cts.payroll.dao.DepartmentDao;
import com.cts.payroll.dao.EmployeeDao;
import com.cts.payroll.dao.EmployeeSkillDao;
import com.cts.payroll.dao.SkillDao;

@WebServlet("/modifyemployee")
public class ModifyEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ModifyEmployeeServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String error = "";
		Employee employee = new Employee();
		employee.setId(Integer.parseInt(request.getParameter("employeeId")));
		employee.setName(request.getParameter("name"));
		employee.setGender(request.getParameter("gender"));
		employee.setSalary(Integer.parseInt(request.getParameter("salary")));
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			employee.setDateOfBirth(sdf.parse(request.getParameter("dateOfBirth")));
		} catch (ParseException e) {
			e.printStackTrace();
			error = "Invalid date format";
			RequestDispatcher rd = request.getRequestDispatcher("updateemp.jsp");
			rd.forward(request, response);
			return;
		}
		employee.setEmail(request.getParameter("name"));
		
		Address address = new Address();
		address.setId(Integer.parseInt(request.getParameter("addressId")));
		address.setLine1(request.getParameter("addressLine1"));
		address.setLine2(request.getParameter("addressLine2"));
		address.setLocality(request.getParameter("locality"));
		address.setCity(request.getParameter("city"));
		address.setPincode(request.getParameter("pincode"));
		employee.setAddress(address);
		
		Department department = new Department();
		department.setId(Integer.parseInt(request.getParameter("department")));
		employee.setDepartment(department);
		
		String[] skillIds = request.getParameterValues("skill");
		
		EmployeeDao employeeDao = new EmployeeDao();
		AddressDao addressDao = new AddressDao();
		EmployeeSkillDao employeeSkillDao = new EmployeeSkillDao();
		DepartmentDao departmentDao = new DepartmentDao();
		SkillDao skillDao = new SkillDao();
		try {
			employeeDao.updateEmployee(employee);
			addressDao.updateAddress(address);
			int employeeId = employee.getId();
			employeeSkillDao.deleteEmployeeSkills(employeeId);
			employeeSkillDao.insertEmployeeSkills(employeeId, skillIds);
			request.setAttribute("employee", employeeDao.getEmployee(employeeId));
			request.setAttribute("departments", departmentDao.getDepartments());
			request.setAttribute("skills", skillDao.getSkills());
			request.setAttribute("success", "Employee details saved successfully.");
		} catch (PayrollException e) {
			error = "System Error. Please retry or contact system administrator.";
		}
		request.setAttribute("error", error);
		RequestDispatcher rd = request.getRequestDispatcher("updateemp.jsp");
		rd.forward(request, response);
	}

}
