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
										<h2>매치 생성하기 페이지</h2>

								<form action="${pageContext.request.contextPath}/creatMatch" method="post">
									<table class="table table-striped">		
										<tr>
											<td>일정</td>
											<td><input id="matchExpectedDay" name="matchExpectedDay" type="date"/></td>
										</tr>
										<tr>
											<td>시간대</td>
											<td><!-- <input id="matchExpectedStartTime" name="matchExpectedStartTime" type="time"/>~
												<input id="matchExpectedEndTime" name="matchExpectedEndTime" type="time"/> -->
											</td>
										</tr>
										<tr>
											<td>풀 캘린더 모달창 띄우기</td>
											<td><button id="fullcalendarModal">풀캘린더</button></td>
										</tr>
													
										<tr>
											<td>매치 종류</td>
											<td><select name="matchKinds">
												    <option value="team">팀전</option>
												    <option value="free">자유</option>					   		    
												</select>
											</td>
										</tr>
										<tr>
											<td>지역 선택</td>
											<td>
												<select name="matchNoticeRegion">
												    <option value="seoul">서울</option>
												    <option value="gyeong-gi">경기</option>
												    <option value="gang-won">강원</option>
												    <option value="chung-cheong">충청</option>
												    <option value="jeon-ra">전라</option>
												    <option value="je-ju">제주</option>
												    <option value="gyeong-sang">경상</option>					    
												</select>			
											</td>
										</tr>
										<tr>
											<td>한 팅당 최소 참여 인원수</td>
											<td><input id="matchMemberCount" name="matchMemberCount" type="text"/></td>
										</tr>	
									</table>		
									<input id="matchCreat" type="submit" value="매치생성">
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
			
			
			