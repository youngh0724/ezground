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

						<h2>팀원 소개</h2>

						<div class="col-lg-12">
							<div class="panel panel-default">
								<div class="panel-heading">
									<h1 class="page-header">팀원 소개</h1>
								</div>
								<div class="panel-body">
									<div class="row">

										<!-- 이영현 소개 시작 -->
										<div class="col-lg-4">
											<div class="panel panel-default">
												<div class="panel-heading">
													<h4>
														<strong>이영현</strong>
													</h4>
													<small>팀장</small>
												</div>
												<div class="panel-body">구현 기능</div>
												<div class="panel-footer">
													<a class="btn btn-social btn-github btn-sm" href="#"
														class="btn btn-danger btn-block"><i
														class="fa fa-github"></i>Git</a> <a
														class="btn btn-social btn-bitbucket btn-sm" href="#"
														class="btn btn-danger btn-block"><i
														class="fa fa-h-square"></i>Host</a>
												</div>
											</div>
										</div>
										<!-- 이영현 소개 끈 -->
										
										<!-- 안준철 소개 시작 -->
										<div class="col-lg-4">
											<div class="panel panel-default">
												<div class="panel-heading">
													<h4>
														<strong>안준철</strong>
													</h4>
													<small>팀원</small>
												</div>
												<div class="panel-body">구현 기능</div>
												<div class="panel-footer">
													<a class="btn btn-social btn-github btn-sm" href="#"
														class="btn btn-danger btn-block"><i
														class="fa fa-github"></i>Git</a> <a
														class="btn btn-social btn-bitbucket btn-sm" href="#"
														class="btn btn-danger btn-block"><i
														class="fa fa-h-square"></i>Host</a>
												</div>
											</div>
										</div>
										<!-- 안준철 소개 끝 -->										
										
			                			<!-- 박범진 소개 시작 -->
										<div class="col-lg-4">
											<div class="panel panel-default">
												<div class="panel-heading">
													<h4>
														<strong>박범진</strong>
													</h4>
													<small>팀원</small>
												</div>
												<div class="panel-body">구현 기능</div>
												<div class="panel-footer">
													<a class="btn btn-social btn-github btn-sm" href="#"
														class="btn btn-danger btn-block"><i
														class="fa fa-github"></i>Git</a> <a
														class="btn btn-social btn-bitbucket btn-sm" href="#"
														class="btn btn-danger btn-block"><i
														class="fa fa-h-square"></i>Host</a>
												</div>
											</div>
										</div>
										<!-- 박범진 소개 끝 -->										
										
									</div>
								</div>
							</div>
						</div>
					
					<div class="col-lg-12">
						<br>
						<div class="panel panel-default">
							<div class="panel-heading">
								<h1 class="page-header">교육 과정</h1>
							</div>
							<!-- /.panel-heading -->
							<div class="panel-body">
								<div class="panel-group">
									<div class="panel panel-default">
										<div class="panel-heading">
											<h4 class="panel-title">교육 기관</h4>
										</div>
										<div class="panel-collapse collapse in">
											<div class="panel-body">한국스마트정보교육원</div>
										</div>
									</div>
								</div>
								<div class="panel-group" id="accordion">
									<div class="panel panel-default">
										<div class="panel-heading">
											<h4 class="panel-title">교육명</h4>
										</div>
										<div class="panel-collapse collapse in">
											<div class="panel-body">국가 기간/전략 산업 직종 훈련 (NCS) - 웹/어플
												제품 SW개발자양성 (응용SW 및 DB엔지니어링 융합)</div>
										</div>
									</div>
								</div>
								<div class="panel-group" id="accordion">
									<div class="panel panel-default">
										<div class="panel-heading">
											<h4 class="panel-title">교육 내용</h4>
										</div>
										<div class="panel-collapse collapse in">
											<div class="panel-body">
												1. 웹/모바일웹 화면 개발언어 : HTML5, JavaScript, JQuery, JQuery
												Mobile, Json 등 <br /> 2. 웹/모바일웹 서버측 개발언어 : Java, JSP,
												Servlet 등 <br /> 3. Framework : Spring, Mybatis 등 <br /> 4.
												Model : Model1, Model2, MVC <br /> 5. 팀프로젝트 실무
											</div>
										</div>
									</div>
								</div>
								<div class="panel-group" id="accordion">
									<div class="panel panel-default">
										<div class="panel-heading">
											<h4 class="panel-title">교육 기간</h4>
										</div>
										<div class="panel-collapse collapse in">
											<div class="panel-body">2017.10.16 ~ 2018.04.20</div>
										</div>
									</div>
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
	</html>
			
			