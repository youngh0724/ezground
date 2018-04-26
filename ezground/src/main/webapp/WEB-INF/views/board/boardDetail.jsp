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
						<h2>작성된 게시글 보기</h2>
						<div class="container">						
							<div class="panel panel-default">
								<div class="panel-heading">게시글보기</div>
								<div class="panel-body">
									<table>
										<tr>
											<td class="col-sm-2">글 제목</td>
											<td class="col-sm-10">${boardDetail.board.boardTitle}</td>
										</tr>
										<tr>
											<td>본문</td>
											<td style="width:100%">${boardDetail.board.boardContent}</td>
										</tr>						
									</table>
									<c:set var="isWriter" value="${boardDetail.isWriter}"></c:set>
									<c:if test = "${!empty isWriter}">
										<a class="btn btn-default" type="button" href="${pageContext.request.contextPath}/board/boardUpdate?boardCategoryNo=${boardDetail.board.boardCategoryNo}&boardNo=${boardDetail.board.boardNo}">수정</a>
										<a class="btn btn-default" type="button" href="${pageContext.request.contextPath}/board/boardDelete?boardCategoryNo=${boardDetail.board.boardCategoryNo}&boardNo=${boardDetail.board.boardNo}">삭제</a>
									</c:if>	
										<a class="btn btn-default" type="button" href="${pageContext.request.contextPath}/board/boardList?boardCategoryNo=${boardDetail.board.boardCategoryNo}">리스트로</a>								
								</div>
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