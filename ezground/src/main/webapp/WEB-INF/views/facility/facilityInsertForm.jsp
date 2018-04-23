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
										<h2>시설 등록 페이지</h2>		
											<form id="facil_insert" action="${pageContext.request.contextPath}/facility/facilityInsert" method="post" enctype="multipart/form-data">
												<table class="table table-striped">													
													<tr>
														<td>시설 이름</td>
														<td><input type = "text" id = "facilityName" name = "facilityName"></td>
													</tr>
													<tr>
														<td>전화번호</td>
														<td><input type =  "text" id = "facilityPhone" name = "facilityPhone"></td>
													</tr>
													<tr>
														<td>주소</td>
														<td><input type = "text" id = "facilityAddress" name = "facilityAddress"></td>
													</tr>	
													<tr>
														<td>공지사항</td>
														<td><textarea id = "facilityNotice" name = "facilityNotice"></textarea></td>
													</tr>
													<tr>
														<td>상세정보</td>
														<td><textarea id = "facilityDetail" name = "facilityDetail"></textarea></td>
													</tr>
													<tr>
														<td>가격정보</td>
														<td><input type = "text" id = "facilityPrice" name = "facilityPrice"></td>
													</tr>
													<tr>	
														<td>환불규정</td>
														<td><textarea id = "facilityRefund" name = "facilityRefund"></textarea></td>
													</tr>
													<tr>	
														<td>이용규칙</td>
														<td><textarea id = "facilityRule" name = "facilityRule"></textarea></td>
													</tr>
													<tr>	
														<td>사업자 번호</td>
														<td><input type = "text" id = "facilityLicenseeNo" name = "facilityLicenseeNo"></td>
													</tr>
													<!-- 글의 상태  -->
													<tr>	
														<td><input type = "hidden" id = "facilityStatus" name = "facilityStatus" value="승인 요청"></td>
													</tr>
													<tr>
														<td>파일</td>
														<td><input type = "file" name = "files" multiple = "multiple"></td>
													</tr>
													<tr>
													<td><input type="button" class="btn btn-defalut" value="등록하기" onclick="btn_insert();"></td>
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
											


<script>

	function btn_insert() {
		var str = $('#facilityNotice').val();
		var str1 = $('#facilityDetail').val();
		var str2 = $('#facilityRefund').val();
		var str3 = $('#facilityRule').val();
		str = str.replace(/(?:\r\n|\r|\n)/g, '<br />');
		str1 = str1.replace(/(?:\r\n|\r|\n)/g, '<br />');
		str2 = str2.replace(/(?:\r\n|\r|\n)/g, '<br />');
		str3 = str3.replace(/(?:\r\n|\r|\n)/g, '<br />');		
		$('#facilityNotice').val(str);
		$('#facilityDetail').val(str1);
		$('#facilityRefund').val(str2);
		$('#facilityRule').val(str3);		
		$('#facil_insert').submit();
		str = str.split('<br />').join("\r\n");
		$('#facilityNotice').val(str);
		$('#facilityDetail').val(str1);
		$('#facilityRefund').val(str2);
		$('#facilityRule').val(str3);
	};
	

</script>
</body>
</html>