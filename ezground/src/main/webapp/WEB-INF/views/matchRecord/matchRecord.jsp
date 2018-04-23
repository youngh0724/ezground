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
										<div class="panel panel-default">
											<div class="panel-heading">내가 소속된 팀 전적</div>
											<div class="panel-body">
									    		<table>
									    			<tr>
									    				<td class="col-sm-2">운동 종목</td>
									    				<td>${currentSportEntry.sportEntriesName }</td>
									    			</tr>
									    			<tr>
									    				<td class="col-sm-2">팀 이름</td>
									    				<td>${teamRecord.myTeamName }</td>
									    			</tr>
									    			<tr>
									    				<td class="col-sm-2">팀 전적</td>
									    				<td>
									    					<span class="col-sm-2" style="text-align:right;">${teamRecord.record }</span>
									    					<span class="col-sm-1">전</span>
									    					<span class="col-sm-2" style="text-align:right;">${teamRecord.win }</span>
									    					<span class="col-sm-1">승</span>
									    					<span class="col-sm-2" style="text-align:right;">${teamRecord.draw }</span>
									    					<span class="col-sm-1">무</span>
									    					<span class="col-sm-2" style="text-align:right;">${teamRecord.lose }</span>
									    					<span class="col-sm-1">패</span>
									    				</td>
									    			</tr>
									    		</table>								      
											</div>
									    </div>
										<div class="panel panel-default">
											<div class="panel-heading">내가 참여한 경기 기록</div>
											<div class="panel-body">
											<div>
												<span class="col-sm-2" style="text-align:right;">${memberRecord.record }</span>
										    	<span class="col-sm-1">전</span>
										  		<span class="col-sm-2" style="text-align:right;">${memberRecord.win }</span>
										  		<span class="col-sm-1">승</span>
										   		<span class="col-sm-2" style="text-align:right;">${memberRecord.draw }</span>
										   		<span class="col-sm-1">무</span>
										   		<span class="col-sm-2" style="text-align:right;">${memberRecord.lose }</span>
										 		<span class="col-sm-1">패</span>
									 		</div><br>
											<table style="text-align:center;">
												<thead>
									    		<tr>
									    			<td class="col-sm-3"> vs 팀</td>
									    			<td class="col-sm-3"> 스코어</td>
									    			<td class="col-sm-3">결과</td>
									    			<td class="col-sm-3">상제보기</td>									    			
									    		</tr>
									    		</thead>
									    		<tbody>
									    			<c:forEach var="matchRecord" items="${memberRecord.resultList}">
									    			<tr>
										    			<td class="col-sm-3">${matchRecord.vsTeamName }</td>
										    			<td class="col-sm-3">${matchRecord.score }</td>
										    			<td class="col-sm-3">${matchRecord.winLose }</td>
										    			<td class="col-sm-3">상제보기</td>									    			
										    		</tr> 
										    		</c:forEach>									    		
									    		</tbody>
									    	</table>
											</div>
										</div>
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