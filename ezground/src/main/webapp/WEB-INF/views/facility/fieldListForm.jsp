<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE HTML>

<html>
<head>
<title>EZ Ground</title>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, user-scalable=no" />
<!--[if lte IE 8]><script src="assets/js/ie/html5shiv.js"></script><![endif]-->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/assets/css/main.css" />
<!--[if lte IE 9]><link rel="stylesheet" href="assets/css/ie9.css" /><![endif]-->
<!--[if lte IE 8]><link rel="stylesheet" href="assets/css/ie8.css" /><![endif]-->
<jsp:include page="/WEB-INF/views/module/headLink.jsp" />
</head>
<body>
	<!-- Wrapper -->
	<div id="wrapper">

		<!-- Main -->
		<div id="main">
			<div class="inner">
				<jsp:include page="/WEB-INF/views/module/header.jsp" />

				<!-- Banner -->
				<section id="banner">
					<div class="content">
						<h2>시설 내 구장 리스트</h2>
						<table>
							<thead>
								<tr>
									<th>종목</th>
									<th>구장이름</th>
									<th>구장크기</th>
									<th>구장사용가격</th>
									<th>구장적정인원</th>
									<th>구장 등록 날</th>
									<th>구장 일정 관리</th>
									<th>삭제 </th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="List" items="${List}">
									<tr>
										<td>${List.sportEntriesName}</td>
										<td>${List.fieldName}</td>
										<td>${List.fieldSize}</td>
										<td>${List.fieldPrice}</td>
										<td>${List.fieldPeopleNumber}</td>
										<td><fmt:formatDate value="${List.fieldWriteDate}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
										<td><a href="${pageContext.request.contextPath}/facility/fieldCalendarForm?fieldNo=${List.fieldNo}">구장 일정 관리</a></td>
										<td><a href="${pageContext.request.contextPath}/facility/fieldDelete?facilityNo=${List.facilityNo}">삭제</a></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</section>
			</div>
		</div>
		<!-- main End -->

		<!-- Sidebar -->
		<div id="sidebar">
			<div class="inner">
				<jsp:include page="/WEB-INF/views/module/sidebar.jsp" />
			</div>
		</div>

	</div>
	<jsp:include page="/WEB-INF/views/module/footLink.jsp" />

</body>
</html>