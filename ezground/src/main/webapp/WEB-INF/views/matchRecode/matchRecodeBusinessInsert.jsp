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
										<h2>?구장 ?일 ?경기 기록등록 페이지 </h2>
																			
										<form action="${pageContext.request.contextPath}/matchRecode/matchRecodeBusinessInsert" method="post">
											<table border="1">
												<thead>
													<tr>
														<th>세트</th>
														<th>게임</th>
														<th>시간</th>
														<th>점수</th>																							
														<th>득점 맴버</th>
													</tr>	
												</thead>
												<tbody>												
														<tr>
															<td>1</td>
															<td>2</td>
															<td>3</td>
															<td>4</td>													
															<td><select name="matchJoinMember">
																	<c:forEach var="memberList" items="${reservationInfo.matchJoinMemberList}">
																	    <option value="${memberList.memberNo}">
																	        ${memberList.memberNo}
																	    </option>
																 	</c:forEach>
																</select></td>
														</tr>													
												</tbody>
												</table>									
											
											<button type="submit">경기 기록 등록</button>
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