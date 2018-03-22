<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Insert title here</title>
</head>

<body>

		<h2>Movie List</h2>
		<div class="row" style="margin-bottom: 30;">
			<div class="col-sm-12 col-lg-12">

				<table style="width: 100%">
					<tr>
						<td>
						<!--SELECT COUNT OPTION 시작 -->
							<div>
								<select name="rowPerPage" onchange="location.href=this.value">
									<option value="#">보여줄 개수 선택</option>
									<option value="${pageContext.request.contextPath}/movie/movieList?rowPerPage=5">5개 보여주기</option>
									<option value="${pageContext.request.contextPath}/movie/movieList?rowPerPage=10">10개 보여주기</option>
									<option value="${pageContext.request.contextPath}/movie/movieList?rowPerPage=20">20개 보여주기</option>
								</select><br>
							</div>
						</td>

						<td style="margin: auto; text-align: right;">
							<div>
								<a class="btn btn-default" href="${pageContext.request.contextPath}/movie/movieInsert">영화 추가</a>
							</div>
						</td>
					</tr>
					<!--SELECT COUNT OPTION 끝 -->
				</table>
				
				<table class="table table-striped" data-effect="fade">
					<thead>
						<tr>
							<th>팀 번호</th>
							<th>종목</th>
							<th>팀 이름</th>
						</tr>
						<tr>							
							<th>활동 지역</th>
							<th>나이대</th>
							<th>팀 수준</th>
						</tr>
						<tr>
							<th>승</th>
							<th>무</th>
							<th>패</th>
							<th>승점</th>
						</tr>
						<tr>
							<th>게임 횟수</th>
							<th>팀 생성일</th>
						</tr>
					</thead>
				
				</table>
				<a class="btn btn-default" href="${pageContext.request.contextPath}/team/teamList">리스트로 돌아가기</a>
			</div>
		</div>
		
