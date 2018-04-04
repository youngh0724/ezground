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
		<jsp:include page="/WEB-INF/views/module/fullcalendar.jsp" />
	</head>
	<script>

$(document).ready(function() {

    $('#calendar').fullCalendar({
    	
	header: {
        left: 'prev,next today',
        center: 'title',
        right: 'month,agendaWeek,agendaDay,list'
      },
      locale: 'ko',
      editable: true,
      navLinks: true, // can click day/week names to navigate views
      eventLimit: true, // allow "more" link when too many events
      events: '${pageContext.request.contextPath}/matchNoticeGsonList'
    	    

    });

  });
</script>

<style>

  body {
    margin: 0;
    padding: 0;
    font-family: "Lucida Grande",Helvetica,Arial,Verdana,sans-serif;
    font-size: 14px;
  }

  #script-warning {
    display: none;
    background: #eee;
    border-bottom: 1px solid #ddd;
    padding: 0 10px;
    line-height: 40px;
    text-align: center;
    font-weight: bold;
    font-size: 12px;
    color: red;
  }

  #loading {
    display: none;
    position: absolute;
    top: 10px;
    right: 10px;
  }

  #calendar {
    max-width: 600px;
    margin: 40px auto;
    padding: 0 10px;
  }

</style>
	
	<body>
	<div id='loading'>loading...</div>
	<div id='calendar' class='calendar'></div>
	

		<!-- Wrapper -->
			<div id="wrapper">

				<!-- Main -->
					<div id="main">
						<div class="inner">
						<jsp:include page="/WEB-INF/views/module/header.jsp" />
						<!-- Banner -->
								<section id="banner">
									<div class="content">
									
									<h2>매치 검색 페이지</h2>
																		
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
													<td><a href ="${pageContext.request.contextPath}/match/matchNoticeInfomation?matchNoticeNo=${matchNoticeInfo.matchNoticeNo}" >상세보기</a></td>
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
			
			
			