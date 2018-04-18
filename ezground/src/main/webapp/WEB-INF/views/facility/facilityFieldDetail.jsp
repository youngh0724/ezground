<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>
<head>


<title>구장 상세정보 페이지</title>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, user-scalable=no" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/assets/css/main.css" />
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<jsp:include page="/WEB-INF/views/module/headLink.jsp" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.4/js/bootstrap.min.js"></script>
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.4/css/bootstrap.min.css"
	rel="stylesheet" />
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
						<h2>구장 상세정보</h2>

						<div class="row" style="margin-bottom: 30;">
							<div class="col-sm-12 col-lg-12">

								<table border="1">

									<tr>
										<td><h4>${field.fieldName}</h4> ${field.facilityAddress}
										</td>
									</tr>
									<tr>
										<td><h4>♦ 공지사항 ♦</h4> ${field.facilityNotice}
											<h4>♦ 상세정보 ♦</h4> ${field.facilityNotice}
											<h4>♦ 이용비용 ♦</h4> ${field.facilityPrice}
											<h4>♦ 환불규정 ♦</h4> ${field.facilityRefund}
											<h4>♦ 이용규칙 ♦</h4> ${field.facilityRule}</td>

									</tr>

								</table>
								<a class="btn btn-default"
									href="${pageContext.request.contextPath}/facility/facilityFieldList">리스트로
									돌아가기</a> 
									<input type="button" class="btn btn-defalut" value="예약 하기" onclick="btn_reserv();">
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


<script type="text/javascript">
	function btn_reserv() {
		if (confirm("예약 화면으로 이동하시겠습니까?") == true) {
			location.href = "${pageContext.request.contextPath}/reservation/reservationInsert?fieldNo=${field.fieldNo}&calendarNo=2";
		} else {
			return;
		}
	}


</script>
</html>

