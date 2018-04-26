<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
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
		<jsp:include page="/WEB-INF/views/module/headLink.jsp" />
		<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>	
</head>

<script>
$( document ).ready(function() {	
	
	
	var str = "${facility.facilityNotice}";
	var str1 = "${facility.facilityDetail}";
	var str2 = "${facility.facilityRefund}";
	var str3 = "${facility.facilityRule}";

	console.log("변환 실행전 ");
	
	str = str.replace(/<br\s*[\/]?>/gi, '\r\n');	
	str1 = str1.replace(/<br\s*[\/]?>/gi, '\r\n');
	str2 = str2.replace(/<br\s*[\/]?>/gi, '\r\n');
	str3 = str3.replace(/<br\s*[\/]?>/gi, '\r\n');	
	
	document.getElementById("facilityNotice").value = str;
	document.getElementById("facilityDetail").value = str1;
	document.getElementById("facilityRefund").value = str2;
	document.getElementById("facilityRule").value = str3;
	
	console.log("실행완료");
});

</script>

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
											<form id="facil_update" action = "${pageContext.request.contextPath}/facility/facilityInsertUpdate" method="post">
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
															<td><textarea name = "facilityNotice" id = "facilityNotice"></textarea></td>
														</tr>
														<tr>	
															<td>상세 정보</td>
															<td><textarea name = "facilityDetail" id = "facilityDetail"></textarea></td>
														</tr>
														<tr>	
															<td>가격 정보</td>
															<td><input type = "text" name = "facilityPrice" id = "facilityPrice" value = "${facility.facilityPrice}"></td>
														</tr>
														<tr>	
															<td>환불 규정</td>
															<td><textarea name = "facilityRefund" id = "facilityRefund"></textarea></td>
														</tr>
														<tr>	
															<td>이용규칙</td>
															<td><textarea name = "facilityRule" id = "facilityRule"></textarea></td>
														</tr>
														<tr>	
															<td>사업자 번호</td>
															<td><input type = "text" name = "facilityLicenseeNo" id = "facilityLicenessNo" value = "${facility.facilityLicenseeNo}"></td>
														</tr>
														<tr>	
															<td>반려 지적사항</td>
															<td><textarea name = "facilityReturn" id = "facilityReturn"></textarea></td>
														</tr>
														<tr>
															<td><input type = "hidden" name = "facilityNo" id = "facilituNo" value = "${facility.facilityNo}"></td>
														</tr>
														<tr>
															<td><input type="button" class="btn btn-defalut" value="수정" onclick="btn_update();">
														
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
	

	function btn_update() {
		var str = $('#facilityNotice').val();
		var str1 = $('#facilityDetail').val();
		var str2 = $('#facilityRefund').val();
		var str3 = $('#facilityRule').val();
		var str4 = $('#facilityReturn').val();
		str = str.replace(/(?:\r\n|\r|\n)/g, '<br />');
		str1 = str1.replace(/(?:\r\n|\r|\n)/g, '<br />');
		str2 = str2.replace(/(?:\r\n|\r|\n)/g, '<br />');
		str3 = str3.replace(/(?:\r\n|\r|\n)/g, '<br />');	
		str4 = str4.replace(/(?:\r\n|\r|\n)/g, '<br />');
		$('#facilityNotice').val(str);
		$('#facilityDetail').val(str1);
		$('#facilityRefund').val(str2);
		$('#facilityRule').val(str3);
		$('#facilityReturn').val(str4);
		$('#facil_update').submit();
		str = str.split('<br />').join('\r\n');
		str1 = str1.split('<br />').join('\r\n');
		str2 = str2.split('<br />').join('\r\n');
		str3 = str3.split('<br />').join('\r\n');
		str4 = str4.split('<br />').join('\r\n');
		$('#facilityNotice').val(str);
		$('#facilityDetail').val(str1);
		$('#facilityRefund').val(str2);
		$('#facilityRule').val(str3);
		$('#facilityReturn').val(str4);
	};	
</script>
</body>

</html>