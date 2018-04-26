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
		<section id = "banner">
			<div class="content">
				<h2>시설 목록</h2>
					
					
			<div class="row">
				<div class="col-lg-12">
				<table class="table table-striped">
					<tr>
						<td>
							<div>
								<select name="rowPerPage" onchange="location.href=this.value">
									<option value="#">보여줄 개수 선택</option>
									<option value="${pageContext.request.contextPath}/facility/facilityFieldList?rowPerPage=5">5개 보여주기</option>
									<option value="${pageContext.request.contextPath}/facility/facilityFieldList?rowPerPage=10">10개 보여주기</option>
									<option value="${pageContext.request.contextPath}/facility/facilityFieldList?rowPerPage=20">20개 보여주기</option>
								</select><br>
							</div>
						</td>					
					</tr>
					<!--SELECT COUNT OPTION 끝 -->
				</table>				

											
						<c:forEach var="field" items="${fieldlist}">
							    													
								<div style="border-radius: 7px; border:solid #dedede; float:left; width: 33%; height:295px; padding:10px; text-align:center;">
									<img src="${pageContext.request.contextPath}/resources/images/field/${field.fieldNo}.jpg" style='height: 100%; width: 100%; object-fit: contain; vertical-align: bottom;'>
									${field.fieldName}
								</div>
								<div style="border-radius: 7px; border:solid #dedede; float:left; width: 55%; height:295px; padding:10px;">
									구장 위치 : ${field.facilityAddress} <br>
									구장 크기 : ${field.fieldSize} <br>
									적정 인원 : ${field.fieldPeopleNumber} <br>									
									<a href="${pageContext.request.contextPath}/facility/facilityFieldDetail?fieldNo=${field.fieldNo}">상세보기</a>										
								</div>	
													
						</c:forEach>
		
		

				<!-- 이전, 다음 버튼 시작 -->
				<div class="col-sm-12" style="margin-bottom: 10; text-align: center">
					<div>
						<a href="<c:if test="${currentPage>1}">${pageContext.request.contextPath}/facility/facilityFieldList?currentPage=${currentPage-1}&rowPerPage=${rowPerPage}</c:if>">
							<button type="button" class="btn btn-labeled btn-default" >
								<span class="btn-label"> <i class="fa fa-arrow-left"></i>
								</span>이전
							</button></a>
							${currentPage} <a href="<c:if test="${currentPage<lastPage}">${pageContext.request.contextPath}/facility/facilityFieldList?currentPage=${currentPage+1}&rowPerPage=${rowPerPage}</c:if>">
							<button type="button" class="btn btn-labeled btn-default">
								다음<span class="btn-label btn-label-right"> <i class="fa fa-arrow-right"></i>
								</span>
							</button></a>
					</div>
					
					<div class="input-group" style="margin: auto;">
						<form class="navbar-form" role="search" action="${pageContext.request.contextPath}/facility/facilityFieldList" method="get">
							<input type="text" class="form-control" placeholder="Search" name="searchWord"> <span class="input-group-btn">
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