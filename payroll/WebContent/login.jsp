<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!doctype html>

<html>
<head>
<title>Payroll - Login</title>
</head>

<body>
	<h1>Login</h1>
	<c:out value="${error}"/>
	<form action="authenticate" method="post">
		<table>
			<tr>
				<td>Username</td>
				<td><input type="text" name="username" value="${userName}"></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="password" name="password"></td>
			</tr>
		</table>
		<input type="submit" value="Login">
	</form>

</body>

</html>