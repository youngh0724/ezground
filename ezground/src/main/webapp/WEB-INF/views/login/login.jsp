<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<h2>member Login Form</h2>

	<form action="${pageContext.request.contextPath}/login" method="post">
		<table>
			<tr>
				<td>ID</td>
				<td><input id="memberId" name="memberId" type="text" value="guest"/></td>
			</tr>
			<tr>
				<td>PW</td>
				<td><input id="memberPw" name="memberPw" type="text" value="1234"/></td>
			</tr>
		</table>
		<input type="hidden" id="memberLevel" name="memberLevel" value="user">
		<input class="btn btn-default" id="login" type="submit" value="login">
	</form>


</body>
</html>