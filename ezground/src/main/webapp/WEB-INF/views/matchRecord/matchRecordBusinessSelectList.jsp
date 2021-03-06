<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE HTML>

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
										<h2>사업자용 자신의 시설구장 날짜별 예약 리스트</h2>
										
										<c:set var="matchRecord" value="${matchRecordFieldList}"></c:set>
										<c:if test = "${!empty matchRecord}">
										<p>${matchRecordFieldList.get(0).calendarDate }일 구장별 열린 경기 일정</p>
										</c:if>
										<c:if test = "${empty matchRecord}">
										<p>찾으시는 날짜의 구장별 열린 경기 일정이 없습니다.</p>
										</c:if>
										<form action="${pageContext.request.contextPath}/matchRecord/matchRecordBusinessSelectList" method="post">
											<input type="date" name="reservationDay">
											<button type="submit">경기 조회</button>
										</form> 
										
										<table border="1">
										<thead>
											<tr>
												<th>시설이름</th>
												<th>구장이름</th>
												<th>예약번호</th>
												<th>매치 시작 시간</th>																							
												<th>매치 기록 작성하기</th>
											</tr>	
										</thead>
										<tbody>
											<c:forEach var="matchRecordFieldList" items="${matchRecordFieldList}">
												<tr>
													<td>${matchRecordFieldList.facilityName }</td>
													<td>${matchRecordFieldList.fieldName }</td>
													<td>${matchRecordFieldList.reservationNo }</td>
													<td>${matchRecordFieldList.calendarStartTime } ~ ${matchRecordFieldList.calendarEndTime }</td>													
													<td><a href ="${pageContext.request.contextPath}/matchRecord/matchRecordBusinessInsert?reservationNo=${matchRecordFieldList.reservationNo }" >기록 작성하기</a></td>
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