<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
		<title>EZ Ground</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
		<!--[if lte IE 8]><script src="assets/js/ie/html5shiv.js"></script><![endif]-->
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/assets/css/main.css" />
		<!--[if lte IE 9]><link rel="stylesheet" href="assets/css/ie9.css" /><![endif]-->
		<!--[if lte IE 8]><link rel="stylesheet" href="assets/css/ie8.css" /><![endif]-->
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
										<h2>시설 등록 페이지</h2>
											<form action="${pageContext.request.contextPath}/facility/facilityInsert" method="post" enctype="multipart/form-data">
												<table class="table table-striped">
													<tr>
														<td>시설 이름</td>
														<td><input type = "text" id = "facilityName" name = "facilityName"></td>
													</tr>
													<tr>	
														<td>시설 번호</td>
														<td><input type = "text" id = "facilityPhone" name = "facilityPhone"></td>
													</tr>
													<tr>
														<td>시설 주소</td>
														<td><input type = "text" id = "facilityAddress" name = "facilityAddress"></td>
													</tr>	
													<tr>
														<td>공지사항</td>
														<td><input type = "text" id = "facilityNotice" name = "facilityNotice"></td>
													</tr>
													<tr>
														<td>상세정보</td>
														<td><input type = "text" id = "facilityDetail" name = "facilityDetail"></td>
													</tr>
													<tr>
														<td>가격정보</td>
														<td><input type = "text" id = "facilityPrice" name = "facilityPrice"></td>
													</tr>
													<tr>	
														<td>환불규정</td>
														<td><input type = "text" id = "facilityRefund" name = "facilityRefund"></td>
													</tr>
													<tr>	
														<td>이용규칙</td>
														<td><input type = "text" id = "facilityRule" name = "facilityRule"></td>
													</tr>
													<tr>	
														<td>사업자 번호</td>
														<td><input type = "text" id = "facilityLicenseeNo" name = "facilityLicenseeNo"></td>
													</tr>
													<!-- 글의 상태  -->
													<tr>
														<td>파일</td>
														<td><input type = "file" name = "files" multiple = "multiple"></td>
													</tr>
														<input type = "hidden" id = "facilityStatus" name = "facilityStatus" value="승인 요청">
												</table>
									<input id="facilityCreat" type="submit" value="등록요청">
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
			