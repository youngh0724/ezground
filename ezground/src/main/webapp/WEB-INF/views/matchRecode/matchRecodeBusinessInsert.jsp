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
										<h2>경기 기록등록 페이지 </h2>
											<input id="addRecodeLine" type="button" value="추가">								
										<form action="${pageContext.request.contextPath}/matchRecode/matchRecodeBusinessInsert" method="post">
											<table id="recodeLine" border="1">
												<thead>
													<tr>
														<th>세트</th>
														<th>게임</th>
														<th>시간</th>
														<th>점수</th>																							
														<th>득점 맴버</th>
														<th>폼 삭제</th>
													</tr>	
												</thead>
												<tbody>												
														<tr>
															<td><input id="" name="scoreSet" type="text"></td>
															<td><input id="" name="scoreGame" type="text"></td>
															<td><input id="" name="scoreTime" type="text"></td>
															<td><input id="" name="scoreRecode" type="text"></td>													
															<td>
																<select name="matchJoinMemberNo">
																	<c:forEach var="memberList" items="${reservationInfo.matchJoinMemberList}">
																	    <option value="${memberList.matchJoinMemberNo}">
																	        ${memberList.memberName}
																	    </option>
																 	</c:forEach>
																</select>
																<input id="" name="matchNoticeNo" type="hidden" value="${reservationInfo.reservation.matchNoticeNo }">
																<input id="" name="sportEntriesNo" type="hidden" value="${reservationInfo.reservation.sportEntriesNo }">
																<input id="" name="teamNo" type="hidden" value="${reservationInfo.reservation.teamNo }">
																<input id="" name="reservationNo" type="hidden" value="${reservationInfo.reservation.reservationNo }">
															</td>
															<td></td>
														</tr>													
												</tbody>
												</table>									
											<input type="submit" value="경기 기록 등록">
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
	
	<script type="text/javascript">
	
		$('#addRecodeLine').click(function(){
			var inputForm = '<tr>'
								+'<td><input id="" name="scoreSet" type="text"></td>'
								+'<td><input id="" name="scoreGame" type="text"></td>'
								+'<td><input id="" name="scoreTime" type="text"></td>'
								+'<td><input id="" name="scoreRecode" type="text"></td>'											
								+'<td>'
									+'<select name="matchJoinMemberNo">'
										+'<c:forEach var="memberList" items="${reservationInfo.matchJoinMemberList}">'
										    +'<option value="${memberList.matchJoinMemberNo}">'
										        +'{memberList.memberName}'
										    +'</option>'
									 	+'</c:forEach>'
									+'</select>'
									+'<input id="" name="matchNoticeNo" type="hidden" value="${reservationInfo.reservation.matchNoticeNo }">'
									+'<input id="" name="sportEntriesNo" type="hidden" value="${reservationInfo.reservation.sportEntriesNo }">'
									+'<input id="" name="teamNo" type="hidden" value="${reservationInfo.reservation.teamNo }">'
									+'<input id="" name="reservationNo" type="hidden" value="${reservationInfo.reservation.reservationNo }">'
								+'</td>'
								+'<td><input id="deleteRecodeLine" type="button" value="삭제"></td>'
							+'</tr>';
			$('#"recodeLine" > tbody:last').append(inputForm);
		});
		
		$('#deleteRecodeLine').click(function(){
			$('#"recodeLine" > tbody:last > tr:last').remove();
		});
	
	</script>
	
	</html>