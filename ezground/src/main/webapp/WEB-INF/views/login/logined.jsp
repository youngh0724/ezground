<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<h2>member Logined Page</h2>

<h3>${MemberLogin.memberId }님이 ${MemberLogin.memberLevel }권한으로 로그인중...</h3>


<br>
<a href ="${pageContext.request.contextPath}/creatMatch" >매치 생성하기</a> 



</body>
</html>