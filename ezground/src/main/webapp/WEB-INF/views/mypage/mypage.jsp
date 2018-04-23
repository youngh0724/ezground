<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>
<head>
<title>Insert title here</title>
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
		<section id = "banner">
			<div class="content">
				<h2>My Page</h2>
								
		<div class="row" style="margin-bottom: 30;">
			<div class="col-sm-6 col-lg-6">
				<h4>내 예약 정보</h4>		
				<table border="1">
				<tr>
					<th>구장 이름</th>					
						<tr>
							<td></td>							
						</tr>				
				</table>				
			</div>
			<div class="col-sm-6 col-lg-6">
				<h4>내 팀 정보</h4>
				<table border="1">
					<tr>
						<th>팀 이름</th>
					</tr>
					<c:forEach var="team" items="${list}">
						<tr>
							<td><a href="${pageContext.request.contextPath}/team/teamDetail?teamNo=${team.teamNo}&sportEntriesNo=${sportEntriesNo}">${team.teamName}</a></td>							
						</tr>
					</c:forEach>
				</table>
			</div>
			<div class="col-sm-6 col-lg-6">
				<h4>내 게시글</h4>
				<table border="1">
					<tr>
						<td>게시글</td>
					</tr>
				</table>
			</div>
			<div class="col-sm-6 col-lg-6">
				<h4>내가 단 댓글</h4>
				<table border="1">
					<tr>
						<td>댓글</td>
					</tr>
				</table>
			</div>
		</div>

</div>
</section>
	</div>

		</div>	
		
					<!-- Sidebar -->
					<div id="sidebar">
						<div class="inner">
									<jsp:include page="/WEB-INF/views/module/sidebar.jsp" />
						</div>
					</div>

			</div>
			<jsp:include page="/WEB-INF/views/module/footLink.jsp" />
			
	</body>
	
	
<script type = "text/javascript">
function btn_team_join() {
	if(confirm("가입 신청 메세지를 보내시겠습니까?") == true) {
	   location.href = "${pageContext.request.contextPath}/teamMember/teamMemberInsert?teamNo=${team.teamNo}&calendarNo=2"
	}else{
	   return;
	}
}
</script>

</html>

		
