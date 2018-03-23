<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>

<!-- 예약 페이지 --> 
<a href ="${pageContext.request.contextPath}/reservation/reservationTest" >예약 페이지</a> 
</h1>

<P>  The time on the server is ${serverTime}. </P>
</body>
</html>
