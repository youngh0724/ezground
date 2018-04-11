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
									<h2>매치 상세보기 페이지</h2>
									<table border="1">		
										<tr>
											<td>매치 예정일</td>
											<td>${conditionInfo.matchNotice.matchExpectedDay }</td>
										</tr>
										<tr>
											<td>매치 예정 시간대</td>
											<td>${conditionInfo.matchNotice.matchExpectedStartTime }~${conditionInfo.matchNotice.matchExpectedEndTime }</td>
										</tr>
										<tr>
											<td>매치 종류</td>
											<td>${conditionInfo.matchNotice.matchKinds }</td>
										</tr>
										<tr>
											<td>매치 예정 지역</td>
											<td>${conditionInfo.matchNotice.matchNoticeRegion }</td>
										</tr>
										<tr>
											<td>팀당 인원 설정</td>
											<td>${conditionInfo.matchNotice.matchMemberCount }</td>
										</tr>
										<tr>
											<td>매치 상태</td>
											<td>${conditionInfo.matchNotice.matchNoticeStatus }</td>
										</tr>
										<tr>
											<td>매치 생성일</td>
											<td>${conditionInfo.matchNotice.matchNoticeInsertDate }</td>
										</tr>
									</table>
										
									<table border="1">
										<thead>
											<tr>			
												<th>홈팀 참가자</th>							
											</tr>
										</thead>
										<tbody>
											<c:forEach var="matchJoinMember" items="${conditionInfo.homeTeamMember}">
												<tr>
													<td>${matchJoinMember.memberId }</td>					
												</tr>
											</c:forEach>
										</tbody>
									</table>
									
									<c:set var="awayTeamMember" value="${conditionInfo.awayTeamMember}"></c:set>
									<c:if test = "${!empty awayTeamMember}">
									<table border="1">
										<thead>
											<tr>			
												<th>매치 성사된 원정팀 참가자</th>							
											</tr>
										</thead>
										<tbody>
											<c:forEach var="matchJoinMember" items="${awayTeamMember}">
												<tr>
													<td>${matchJoinMember.memberId }</td>					
												</tr>
											</c:forEach>
										</tbody>
									</table>
									</c:if>
									
									<c:set var="joinAwayTeamMember" value="${conditionInfo.joinAwayTeamMember}"></c:set>
									<c:if test = "${!empty joinAwayTeamMember}">
									<table border="1">
										<thead>
											<tr>			
												<th>매치 신청한 원정팀 참가자</th>							
											</tr>
										</thead>
										<tbody>
											<c:forEach var="matchJoinMember" items="${joinAwayTeamMember}">
												<tr>
													<td>${matchJoinMember.memberId }</td>					
												</tr>
											</c:forEach>
										</tbody>
									</table>
									</c:if>
									
									<c:set var="myTeamMember" value="${conditionInfo.myTeamMember}"></c:set>
									<c:if test = "${!empty myTeamMember}">
									<table border="1">
										<thead>
											<tr>			
												<th>자신이 소속한 팀의 원정팀 참가자</th>							
											</tr>
										</thead>
										<tbody>
											<c:forEach var="matchJoinMember" items="${myTeamMember}">
												<tr>
													<td>${matchJoinMember.memberId }</td>					
												</tr>
											</c:forEach>
										</tbody>
									</table>
									</c:if>
								
									<!-- 매치에 참가 되어있는지  -->
									<c:set var="isMatchJoinMember"
										value="${conditionInfo.isMatchJoinMember}"></c:set>
									<c:choose>
								
										<c:when test="${!empty isMatchJoinMember}">
								
											<!-- 매치에 참가된 자신의 맴버 레벨에 따라 선택 버튼 분화  -->
											<c:set var="MatchJoinMemberLevel"
												value="${conditionInfo.MatchJoinMemberLevel}"></c:set>
											<c:choose>
								
												<c:when test="${MatchJoinMemberLevel eq 'maker'}">
													<c:set var="joinAwayTeamMember" value="${conditionInfo.joinAwayTeamMember}"></c:set>
													<c:if test="${empty joinAwayTeamMember}">
														<a type="button" class="btn btn-primary" href="${pageContext.request.contextPath}/match/matchNoticeDelete?matchNoticeNo=${conditionInfo.matchNotice.matchNoticeNo}">매치 공고 삭제</a>
														<br>
													</c:if>
													<c:if test="${!empty joinAwayTeamMember}">
														<a type="button" class="btn btn-primary" href="${pageContext.request.contextPath}/match/matchRequestPermit?matchNoticeNo=${conditionInfo.matchNotice.matchNoticeNo}&memberNo=${joinAwayTeamMember.get(0).memberNo}">매치 요청 수락</a>
														<br>
													</c:if>
													<c:set var="MatchJoinMemberCount" value="${conditionInfo.MatchJoinMemberCount}"></c:set>
													<c:if test="${MatchJoinMemberCount eq 'count'}">
														<a type="button" class="btn btn-primary" href="${pageContext.request.contextPath}/match/matchNoticeNotice?matchNoticeNo=${conditionInfo.matchNotice.matchNoticeNo}">매치 공고 개방하기</a>
													</c:if>
												</c:when>
												<c:otherwise>
													<br>
													<c:set var="MatchJoinMemberLevel" value="${conditionInfo.MatchJoinMemberLevel}"></c:set>
													<c:if test="${conditionInfo.MatchJoinMemberCount eq 'count'}">
														<a type="button" class="btn btn-primary" href="${pageContext.request.contextPath}/match/matchRequestHomeTeam?matchNoticeNo=${conditionInfo.matchNotice.matchNoticeNo}">매치 요청하기</a>
														<br>
														<a type="button" class="btn btn-primary" href="${pageContext.request.contextPath}/match/matchJoinCancel?matchNoticeNo=${conditionInfo.matchNotice.matchNoticeNo}">매치 맴버 참가 취소</a>
													</c:if>
												</c:otherwise>
											</c:choose>
										</c:when>
										<c:otherwise>
											<br>
											<a type="button" href="${pageContext.request.contextPath}/match/matchJoin?matchNoticeNo=${conditionInfo.matchNotice.matchNoticeNo}">매치 맴버 참가 신청</a>
										</c:otherwise>
									</c:choose>
									<br>
									<a type="button" class="btn btn-primary" href ="${pageContext.request.contextPath}/match/matchSelect" >매치 검색 페이지로..</a><br>
									<a type="button" class="btn btn-primary" href="${pageContext.request.contextPath}/match/matchSelectTeam">팀 소속 매치 검색</a>	
									
									</div>
									<span class="image object">
										<img src="${pageContext.request.contextPath}/resources/images/admin/image01.jpg" alt="" />
									</span>
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
	<script type="text/javascript">

	console.log('${conditionInfo.matchNotice}');
	console.log('${conditionInfo.isMatchJoinMember}');
	console.log('${conditionInfo.MatchJoinMemberLevel}');
	console.log('${conditionInfo.homeTeamMember}');
	console.log('${conditionInfo.awayTeamMember}');
	console.log('${conditionInfo.joinAwayTeamMember}');
	console.log('${conditionInfo.MatchJoinMemberCount}');
	</script>
</html>
			
