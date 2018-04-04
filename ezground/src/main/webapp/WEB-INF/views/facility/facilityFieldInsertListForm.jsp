<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
		<title>EZ Ground</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
		<!--[if lte IE 8]><script src="assets/js/ie/html5shiv.js"></script><![endif]-->
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/assets/css/main.css" />
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
										<h2>사업자 시설 등록신청 리스트 페이지</h2>
											<form>		
											<table class="table table-striped" data-effect="fade">
												<thead>
													<tr>
														<th>시설 이름</th>
														<th>시설 전화번호</th>
														<th>시설 주소</th>
														<th>사업자 번호</th>
														<th>승인/거절</th>
														<th>등록 날짜</th>
														<th>구장 등록</th>
													</tr>
												</thead>
												<tbody>
													<c:forEach var="List" items="${List}">
														<tr>
															<td>${List.facilityName}</td>
															<td>${List.facilityPhone}</td>
															<td>${List.facilityAddress}</td>
															<td>${List.facilityLicenseeNo}</td>
															<td>${List.facilityStatus}</td>
															<td><fmt:formatDate value="${List.facilityWriteDate}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
															<td><a href="${pageContext.request.contextPath}/facility/facilityFieldInsertForm?facilityNo=${List.facilityNo}">구장 등록</a></td>
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