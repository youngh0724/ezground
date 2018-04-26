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
						<h2>새글 작성하기</h2>
						<div class="container">						
							<div class="panel panel-default">
								<div class="panel-heading">새글 작성하기</div>
								<div class="panel-body">
									<form action="${pageContext.request.contextPath}/board/boardInsert" method="post">
										<table>
											<tr>
												<td class="col-sm-2">글 제목</td>
												<td class="col-sm-10"><input name="boardTitle" type="text"></td>
											</tr>
											<tr>
												<td>본문</td>
												<td><textarea name="boardContent" rows="15" ></textarea></td>
											</tr>						
										</table>
										<input name="boardCategoryNo" type="hidden" value="${boardCategoryNo }">
										<input type="submit" value="등록"><button id="" >취소</button><a type="button" href="#" >취소</a>								
									</form>								
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