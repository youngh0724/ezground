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
<jsp:include page="/WEB-INF/views/module/fullcalendar.jsp" />
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

						<h2>팀원 소속 매치 검색 페이지</h2>
						<form
							action="${pageContext.request.contextPath}/match/matchSelectTeam"
							method="post" id="searchForm">
							<table>
								<tr>
									<td>매치종류</td>
									<td><select id="matchKinds" name="matchKinds">
											<option value="all">종류 무관</option>
											<option value="team">팀전</option>
											<option value="free">자유</option>
									</select></td>
								</tr>
								<tr>
									<td>날짜</td>
									<td><input id="matchExpectedDay" name="matchExpectedDay"
										type="date" />이후 경기</td>
								</tr>
								<tr>
									<td>팀당 최소인원수</td>
									<td><select id="matchMemberCount" name="matchMemberCount">
											<option value="0">선택</option>
											<option value="3">3 vs 3</option>
											<option value="4">4 vs 4</option>
											<option value="5">5 vs 5</option>
									</select></td>
								</tr>
							</table>
							<input class="btn btn-default" id="search" type="submit"
								value="search">
						</form>
						<br>
						<table border="1">
							<thead>
								<tr>
									<th>매치 종류</th>
									<th>매치 팀당 최소 인원수</th>
									<th>매치 상태</th>
									<th>매치 지역</th>
									<th>매치 예정일</th>
									<th>매치 예정시간대</th>
									<th>매치 상세 정보</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="matchNoticeInfo" items="${matchNoticeList}">
									<tr>
										<td>${matchNoticeInfo.matchKinds }</td>
										<td>${matchNoticeInfo.matchMemberCount }</td>
										<td>${matchNoticeInfo.matchNoticeStatus }</td>
										<td>${matchNoticeInfo.matchNoticeRegion }</td>
										<td>${matchNoticeInfo.matchExpectedDay }</td>
										<td>${matchNoticeInfo.matchExpectedStartTime}~${matchNoticeInfo.matchExpectedEndTime}</td>
										<td><a
											href="${pageContext.request.contextPath}/match/matchNoticeInfomation?matchNoticeNo=${matchNoticeInfo.matchNoticeNo}">상세보기</a></td>
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


