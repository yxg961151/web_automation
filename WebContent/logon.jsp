<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Logon Sample System</title>
</head>
<body>
	<form action="sample_login" method="post">
		<table style="with: 50%">
			<tr>
				<td>UserName</td>
				<td><input type="text" name="username" /></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="password" name="password" /></td>
			</tr>
			<tr>
				<td><a href="/Web_Application/register.jsp"> Sign Up </a></td>				
			</tr>
			
		</table>
		<input type="submit" value="Login" />
	</form>
</body>
</html>