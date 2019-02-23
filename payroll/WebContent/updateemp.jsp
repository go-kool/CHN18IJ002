<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h1>Update Employee</h1>
	
	<c:out value="${error}"/>
	<c:out value="${success}"/>
	<form name="employeeForm" method="POST" action="modifyemployee">
	<table width="100%">
		<tr>
			<td>Name</td><td>Date of Birth</td><td>Gender</td><td>Salary</td>
		</tr>
		<tr>
			<td>
				<input type="hidden" name="employeeId" value="${employee.id}">
				<input type="text" name="name" value="${employee.name}">
			</td>
			<td>
				<input type="text" name="dateOfBirth" value="${employee.dateOfBirth}">
			</td>
			<td>
				<c:if test="${employee.gender == 'Male'}">
					<input type="radio" name="gender" value="Male" checked> Male
					<input type="radio" name="gender" value="Female"> Female
				</c:if>
				<c:if test="${employee.gender == 'Female'}">
					<input type="radio" name="gender" value="Male"> Male
					<input type="radio" name="gender" value="Female" checked> Female
				</c:if>
			</td>
			<td><input type="text" name="salary" value="${employee.salary}"></td>
		</tr>
		<tr>
			<td>Department</td>
			<td>Address Line 1</td>
			<td>Address Line 2</td>
			<td>Locality</td>
		</tr>
		<tr>
			<td>
				<select name="department">
					<option>[Select Department]</option>
					<c:forEach items="${departments}" var="department">
					<c:if test="${ employee.department.id == department.id }">
						<option value="${department.id}" selected>${department.name}</option>
					</c:if>
					<c:if test="${ employee.department.id != department.id }">
						<option value="${department.id}">${department.name}</option>
					</c:if>
					</c:forEach>
				</select>
			</td>
			<td>
				<input type="hidden" name="addressId" value="${employee.address.id}">
				<input type="text" name="addressLine1" value="${employee.address.line1}">
			</td>
			<td><input type="text" name="addressLine2" value="${employee.address.line2}"></td>
			<td><input type="text" name="locality" value="${employee.address.locality}"></td>
		</tr>
		<tr>
			<td>City</td><td>Pincode</td>
		</tr>
		<tr>
			<td><input type="text" name="city" value="${employee.address.city}"></td>
			<td><input type="text" name="pincode" value="${employee.address.pincode}"></td>
		</tr>
		<tr>
			<td>Skills</td>
		</tr>
		<tr>
			<td colspan="4">
				<c:forEach items="${skills}" var="skill">
				<c:if test="${fn:containsIgnoreCase(employee.skills, skill.name)}">
				<input type="checkbox" name="skill" value="${skill.id}" checked> ${skill.name}
				</c:if>
				<c:if test="${!fn:containsIgnoreCase(employee.skills, skill.name)}">
				<input type="checkbox" name="skill" value="${skill.id}"> ${skill.name}
				</c:if>
				</c:forEach>
			</td>
		</tr>
	</table>
	<input type="submit" value="Save Employee">
	</form>

</body>
</html>