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
						<h2>시설 목록</h2>
						<form>
							<table>
								<thead>
									<tr>
										<th>시설 이름</th>
										<th>시설 전화번호</th>
										<th>시설 주소</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="List" items="${List}">
										<tr>
											<td><a
												href="${pageContext.request.contextPath}/facility/facilityInFieldListForm?facilityNo=${List.facilityNo}">${List.facilityName}</a></td>
											<td>${List.facilityPhone}</td>
											<td>${List.facilityAddress}</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
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
