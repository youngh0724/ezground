<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>
<head>
	<meta charset="utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
	<!--[if lte IE 8]><script src="assets/js/ie/html5shiv.js"></script><![endif]-->
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/assets/css/main.css" />
	<!--[if lte IE 9]><link rel="stylesheet" href="assets/css/ie9.css" /><![endif]-->
	<!--[if lte IE 8]><link rel="stylesheet" href="assets/css/ie8.css" /><![endif]-->
	<jsp:include page="/WEB-INF/views/module/headLink.jsp" />

<title>Insert title here</title>
</head>

<body>
<!-- Wrapper -->
			<div id="wrapper">

				<!-- Main -->
					<div id="main">
						<div class="inner">
						<jsp:include page="/WEB-INF/views/module/header.jsp" />
		<h2>My Team List</h2>
		<div class="row" style="margin-bottom: 30;">
			<div class="col-sm-6 col-lg-6">

				<table style="width: 100%">
					<tr>
						<td>
							<div>
								<select name="rowPerPage" onchange="location.href=this.value">
									<option value="#">보여줄 개수 선택</option>
									<option value="${pageContext.request.contextPath}/team/teamList?rowPerPage=5">5개 보여주기</option>
									<option value="${pageContext.request.contextPath}/team/teamList?rowPerPage=10">10개 보여주기</option>
									<option value="${pageContext.request.contextPath}/team/teamList?rowPerPage=20">20개 보여주기</option>
								</select><br>
							</div>
						</td>

						<td style="margin: auto; text-align: right;">
							<!--SELECT COUNT OPTION 시작 -->
							<div>
								<a class="btn btn-default" href="${pageContext.request.contextPath}/team/teamInsert">팀 생성</a>
							</div>
						</td>
					</tr>
					<!--SELECT COUNT OPTION 끝 -->
				</table>
				
				<table border="1">
					<thead>
						<tr>
							<th>팀 번호</th>
							<th>종목</th>
							<th>팀 이름</th>
							<th>수정</th>
							<th>삭제</th>
						</tr>
					</thead>
					<tbody>
						
						<c:forEach var="team" items="${list}">
							<tr>
								<td>${team.teamNo}</td>
								<td>${team.sportEntriesNo}</td>
								<td><a href="${pageContext.request.contextPath}/team/teamDetail?teamNo=${team.teamNo}">${team.teamName}</a></td>
								<td><a href="${pageContext.request.contextPath}/team/teamUpdate?teamNo=${team.teamNo}">수정</a></td>
								<td><a href="${pageContext.request.contextPath}/team/teamDelete?teamNo=${team.teamNo}">삭제</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>

				<!-- 이전, 다음 버튼 시작 -->
				<div class="col-sm-12" style="margin-bottom: 10; text-align: center">
					<div>
						<a
							href="<c:if test="${currentPage>1}">${pageContext.request.contextPath}/team/teamList?currentPage=${currentPage-1}&rowPerPage=${rowPerPage}</c:if>">
							<button type="button" class="btn btn-labeled btn-default">
								<span class="btn-label"> <i class="fa fa-arrow-left"></i>
								</span>이전
							</button></a> ${currentPage} <a
							href="<c:if test="${currentPage<lastPage}">${pageContext.request.contextPath}/team/teamList?currentPage=${currentPage+1}&rowPerPage=${rowPerPage}</c:if>">
							<button type="button" class="btn btn-labeled btn-default">
								다음<span class="btn-label btn-label-right"> <i class="fa fa-arrow-right"></i>
								</span>
							</button></a>
					</div>
					
					<div class="input-group" style="margin: auto;">
						<form class="navbar-form" role="search" action="${pageContext.request.contextPath}/team/teamList" method="get">
							<input type="text" class="form-control" placeholder="Search" name="searchWord"> <span class="input-group-btn">
								<button class="btn btn-default" type="submit">검색</button>
							</span>
						</form>
					</div>
				</div>
				<!-- 이전, 다음 버튼 끝 -->
			</div>
		</div>
			<!-- Sidebar -->
			</div>
			</div>
			
					<div id="sidebar">
						<div class="inner">
									<jsp:include page="/WEB-INF/views/module/sidebar.jsp" />
						</div>
					</div>

			</div>
			<jsp:include page="/WEB-INF/views/module/footLink.jsp" />
			
	</body>
	</html>
		
		
