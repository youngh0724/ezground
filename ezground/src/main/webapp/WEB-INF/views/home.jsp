<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>

<!-- 예약 페이지 --> 
<a href ="${pageContext.request.contextPath}/reservation/reservationTest" >예약 페이지</a> 
<br>
<a href ="${pageContext.request.contextPath}/login" >로그인 페이지</a> 
<br>
<a href ="${pageContext.request.contextPath}/memberInsert" >회원가입 페이지</a> 
<br>
<!-- 종목 이름 -->
<a href = "${pageContext.request.contextPath}/login/logined">종목</a>
<br>
<!-- 시설 등록페이지 -->					
<a href ="${pageContext.request.contextPath}/facility/facilityTest" >시설 등록요청 페이지</a>
<br>					
<!-- 시설 등록요청 리스트 페이지 -->					
<a href="${pageContext.request.contextPath}/facility/memberFacilityInsertStatusListForm">시설 등록요청 리스트 페이지(개인용)</a>	
<br>					
<!-- 팀 관리 페이지 -->					
<a href="${pageContext.request.contextPath}/team/teamList">팀</a>	
				

</h1>
</body>
</html>
