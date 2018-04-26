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
						<h2>공지 게시판</h2>


						<div class="row">
							<div class="col-lg-10">
								<table class="table table-striped">
									<tr>
										<td>
											<div>
												<select class="col-sm-3" name="rowPerPage"
													onchange="location.href=this.value">
													<option value="#">보여줄 개수 선택</option>
													<option	value="${pageContext.request.contextPath}/board/boardList?boardCategoryNo=${boardList.boardCategoryNo}&rowPerPage=5">5개 보여주기</option>
													<option value="${pageContext.request.contextPath}/board/boardList?boardCategoryNo=${boardList.boardCategoryNo}&rowPerPage=10">10개 보여주기</option>
													<option value="${pageContext.request.contextPath}/board/boardList?boardCategoryNo=${boardList.boardCategoryNo}&rowPerPage=20">20개 보여주기</option>
												</select><br>
											</div>
										</td>

										<td style="margin: auto; text-align: right;">
											<!--SELECT COUNT OPTION 시작 -->
											<div>
												<a class="btn btn-default" href="${pageContext.request.contextPath}/board/boardWrite?boardCategoryNo=${boardList.boardCategoryNo}&">글 쓰기</a> 											
											</div>
										</td>
									</tr>
									<!--SELECT COUNT OPTION 끝 -->
								</table>

								<table border="1">
									<thead>
										<tr>
											<th>게시글 번호</th>											
											<th>카테고리 이름</th>
											<th>제목</th>											
											<th>작성자 맴버아이디</th>
											<th>작성일</th>
											<th>조회수</th>
										</tr>
									</thead>
									<tbody>

										<c:forEach var="boardList" items="${boardList.list}">
											<tr>
												<td>${boardList.boardNo}</td>												
												<td>${boardList.boardCategoryName}</td>
												<td>
													<a href="${pageContext.request.contextPath}/board/boardDetail?boardNo=${boardList.boardNo}">
														${boardList.boardTitle}
													</a>
												</td>												
												<td>${boardList.memberId}</td>
												<td>${boardList.boardRegDate}</td>
												<td>${boardList.boardViewCount}</td>
											</tr>
										</c:forEach>
									</tbody>
								</table>

								<!-- 이전, 다음 버튼 시작 -->
								<div class="col-sm-12" style="margin-bottom: 10; text-align: center">
									<div>
										<a href="<c:if test="${boardList.boardPage.currentPage > 1}">${pageContext.request.contextPath}/board/boardList?boardCategoryNo=${boardList.boardCategoryNo}&currentPage=${boardList.boardPage.currentPage-1}&rowPerPage=${boardList.boardPage.rowPerPage}</c:if>">
											<button type="button" class="btn btn-labeled btn-default">
												<span class="btn-label"><i class="fa fa-arrow-left"></i></span>이전
											</button> </a> ${boardList.boardPage.currentPage} 
										<a href="<c:if test="${boardList.boardPage.currentPage < boardList.boardPage.lastPage}">${pageContext.request.contextPath}/board/boardList?boardCategoryNo=${boardList.boardCategoryNo}&currentPage=${boardList.boardPage.currentPage+1}&rowPerPage=${boardList.boardPage.rowPerPage}</c:if>">
											<button type="button" class="btn btn-labeled btn-default">다음
												<span class="btn-label btn-label-right"><i class="fa fa-arrow-right"></i></span>
											</button></a>
									</div>

									<div class="input-group" style="margin: auto;">
										<form class="navbar-form" role="search" action="${pageContext.request.contextPath}/board/boardList?boardCategoryNo=${boardList.boardCategoryNo}" method="get">
											<input type="text" class="form-control" placeholder="Search" name="searchWord">
											<input name="boardCategoryNo" type="hidden" value="${boardList.boardCategoryNo }">
											 <span class="input-group-btn">
												<button class="btn btn-default" type="submit">검색</button>
											</span>
										</form>
									</div>
								</div>
								<!-- 이전, 다음 버튼 끝 -->
							</div>
						</div>
					</div>
				</section>
			</div>
		</div>
		<!-- end main -->
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