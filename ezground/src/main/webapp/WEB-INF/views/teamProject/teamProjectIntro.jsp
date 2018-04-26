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
					<div class="col-lg-12">
						<br>
						<div class="panel panel-default">
							<div class="panel-heading">
								<h1 class="page-header">프로젝트 소개</h1>
							</div>
							<!-- /.panel-heading -->
							<div class="panel-body">
								<div class="panel-group">
									<div class="panel panel-default">
										<div class="panel-heading">
											<h4 class="panel-title">주제</h4>
										</div>
										<div class="panel-collapse collapse in">
											<div class="panel-body">
												영유아 교육기관 통합 관리 시스템 (Kindergarten Total Management System)
												&nbsp; <a href="/Login" class="btn btn-app"><i
													class="fa fa-play"></i>프로젝트 시작</a>
											</div>
										</div>
									</div>
								</div>
								<div class="panel-group" id="accordion">
									<div class="panel panel-default">
										<div class="panel-heading">
											<h4 class="panel-title">목표</h4>
										</div>
										<div class="panel-collapse collapse in">
											<div class="panel-body">영유아 교육기관의 업무 부담 감소로 인한 교육의 질적
												향상 도모</div>
										</div>
									</div>
								</div>
								<div class="panel-group" id="accordion">
									<div class="panel panel-default">
										<div class="panel-heading">
											<h4 class="panel-title">기대효과</h4>
										</div>
										<div class="panel-collapse collapse in">
											<div class="panel-body">
												<table class="table">
													<tbody>
														<tr>
															<td>1</td>
															<td>지면서류로 이루어지는 여러 작업을 하나의 시스템으로 통합 해 업무 시간을 단축한다.</td>
														</tr>
														<tr>
															<td>2</td>
															<td>유치원 현황 정보를 시스템 내에서 즉각 확인함으로써 편리함과 동시에 원할한 관리가
																가능해진다.</td>
														</tr>
														<tr>
															<td>3</td>
															<td>교육부 지정 유아 교육기관 평가 인증 대비에 도움을 준다.</td>
														</tr>
													</tbody>
												</table>
											</div>
										</div>
									</div>
								</div>
								<div class="panel-group" id="accordion">
									<div class="panel panel-default">
										<div class="panel-heading">
											<h4 class="panel-title">개발환경</h4>
										</div>
										<div class="panel-collapse collapse in">
											<div class="panel-body">
												<table class="table table-striped">
													<tbody>
														<tr>
															<td><strong>OS</strong></td>
															<td>Windows 10</td>
														</tr>
														<tr>
															<td><strong>Web Browser</strong></td>
															<td>Chrome</td>
														</tr>
														<tr>
															<td><strong>WAS</strong></td>
															<td>apache-tomcat 8.5</td>
														</tr>
														<tr>
															<td><strong>DB</strong></td>
															<td>MySQL 5.5.17</td>
														</tr>
														<tr>
															<td><strong>DB Tool</strong></td>
															<td>HeidiSQL 9.5.0</td>
														</tr>
														<tr>
															<td><strong>Development Tool</strong></td>
															<td>Spring Tool Suite 3.9.2</td>
														</tr>

														<tr>
															<td><strong>Language</strong></td>
															<td>Java 1.8, Javascript, jquery3.1, JSP, HTML 5</td>
														</tr>
														<tr>
															<td><strong>Framework</strong></td>
															<td>jQuery 2.2.4, Json, Ajax, Mybatis 3.4.5,
																bootStrap 3.3.7, Spring 4.3.12, Maven 2.5.1, tiles 3.0.5</td>
														</tr>
														<tr>
															<td><strong>API</strong></td>
															<td>JSTL 1.2, EL, Gson 2.8.2, Log4j 1.2.17,
																Mybatis-Spring 1.3.1, Datatables, Daum 지도 , postcodify
																도로명주소</td>
														</tr>
													</tbody>
												</table>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="col-lg-12">
						<div class="panel panel-default">
							<div class="panel-heading">
								<h2>프로젝트 관련 자료</h2>
							</div>
							<div class="panel-body">
								<div class="table-responsive">
									<table class="table table-striped">
										<tbody>
											<tr>
												<td><strong>GITHUB</strong></td>
												<td><a
													href="https://github.com/hanboa1026/kindergarten.git"
													class="btn btn-social btn-github"> <i
														class="fa fa-github"></i>
														https://github.com/hanboa1026/kindergarten.git
												</a></td>
											</tr>
											<tr>
												<td><strong>ERD</strong></td>
												<td><a class="btn btn-default"
													href="/resources/vendor/files/ERD_logical.png">논리ERD</a><b></b>
													<a class="btn btn-default"
													href="/resources/vendor/files/ERD_physical.png">물리ERD</a></td>
											</tr>
											<tr>
												<td><strong>DOCUMENT</strong></td>
												<td><a class="btn btn-danger" id="filedown">개발문서
														다운로드</a></td>
											</tr>
										</tbody>
									</table>
								</div>
							</div>
						</div>
					</div>

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

<!-- Custom Theme JavaScript -->
<script src="resources/vendor/js/sb-admin-2.js"></script>
	<script>
		$(document).ready(function() {
			$(document).on('click', '#filedown', function(e) {
				var answer = confirm("다운로드 하시겠습니까 ?")
				if (answer) {
					 e.preventDefault();
			         window.open("/resources/vendor/files/kindergartenManagementSystem.pptx", "_blank");
				}
			});
		});
</script>


</html>

