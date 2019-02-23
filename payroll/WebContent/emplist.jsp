<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>

<html>
<head>
<title>Payroll - Employee List</title>
</head>

<body>
	<h1>Employee List</h1>
	<table border="1">
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Date of Birth</th>
			<th>Salary</th>
			<th>Gender</th>
			<th>Email</th>
			<th>Department</th>
			<th>Skills</th>
			<th>Address</th>
		</tr>
		<c:forEach items="${employees}" var="employee">
		<tr>
			<td>${employee.id}</td>
			<td>${employee.name}</td>
			<td>${employee.dateOfBirth}</td>
			<td>${employee.salary}</td>
			<td>${employee.gender}</td>
			<td>${employee.email}</td>
			<td>${employee.department.name}</td>
			<td>${employee.skills}</td>
			<td>${employee.address.line1}, 
				${employee.address.line2}, 
				${employee.address.locality}, 
				${employee.address.city} - ${employee.address.pincode}</td>
			<td><a href="showemployee?id=${employee.id}">Edit</a> <a>Delete</a></td>
		</tr>
		</c:forEach>
	</table>
</body>

</html>