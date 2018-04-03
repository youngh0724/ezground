<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
										<h2>시설 등록 수정 페이지</h2>		
											<form action = "${pageContext.request.contextPath}/facility/facilityInsertUpdate" method="post">
												<table class="table table-striped">
														<tr>
															<td>시설 이름</td>
															<td><input type = "text" name = "facilityName" id = "facilityName" value = "${facility.facilityName}"></td>
														</tr>
														<tr>	
															<td>시설 전화번호</td>
															<td><input type = "text" name = "facilityPhone" id = "facilityPhone" value = "${facility.facilityPhone}"></td>
														</tr>
														<tr>
															<td>시설 주소</td>
															<td><input type = "text" name = "facilityAddress" id = "facilityAddress" value = "${facility.facilityAddress}"></td>
														</tr>
														<tr>	
															<td>공지 사항</td>
															<td><input type = "text" name = "facilityNotice" id = "facilityNotice" value = "${facility.facilityNotice}"></td>
														</tr>
														<tr>	
															<td>상세 정보</td>
															<td><input type = "text" name = "facilityDetail" id = "facilityDetail" value = "${facility.facilityDetail}"></td>
														</tr>
														<tr>	
															<td>가격 정보</td>
															<td><input type = "text" name = "facilityPrice" id = "facilityPrice" value = "${facility.facilityPrice}"></td>
														</tr>
														<tr>	
															<td>환불 규정</td>
															<td><input type = "text" name = "facilityRefund" id = "facilityRefund" value = "${facility.facilityRefund}"></td>
														</tr>
														<tr>	
															<td>이용규칙</td>
															<td><input type = "text" name = "facilityRule" id = "facilityRule" value = "${facility.facilityRule}"></td>
														</tr>
														<tr>	
															<td>사업자 번호</td>
															<td><input type = "text" name = "facilityLicenseeNo" id = "facilityLicenessNo" value = "${facility.facilityLicenseeNo}"></td>
														</tr>
														<tr>	
															<td>반려 지적사항</td>
															<td><input type = "text" name = "facilityReturn" id = "facilityReturn" value = "${facility.facilityReturn}"></td>
														</tr>
														<tr>
															<td><input type = "hidden" name = "facilityNo" id = "facilituNo" value = "${facility.facilityNo}"></td>
														</tr>
														<tr>
															<td><input type = "submit" value = "수정"></td>
														</tr>
														<tr>
															<td><input type = "submit" value = "삭제"></td>
														</tr>
												</table>
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