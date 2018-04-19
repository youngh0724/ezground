<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
						<h2>구장 일정 리스트</h2>
						<form action = "${pageContext.request.contextPath}/facility/fieldCalendarInsertForm" method="post">
							<table>
								<thead>
									<tr>
										<th>시작 시간</th>
										<th>종료 시간</th>
										<th>상 태 </th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="List" items="${List}">
										<tr>
											<td>${List.calendarStartTime}</td>
											<td>${List.calendarEndTime}</td>
											<td>${List.calendarDate}</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
							<input type = "hidden" id = "facilityNo" name = "facilityNo" value = "${facilityNo}">
							<input type = "hidden" id = "fieldNo" name = "fieldNo" value = "${fieldNo}">
							<input type = "hidden" id = "date" name = "date" value = "${Date}">
							<input type = "submit" value = "등록">
						</form>
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
