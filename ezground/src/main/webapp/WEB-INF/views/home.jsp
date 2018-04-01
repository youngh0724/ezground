<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>Home</title>
<jsp:include page="/WEB-INF/views/module/topLink.jsp" />
</head>
<body>

<div id="wrapper">

	<!-- Navigation Start -->
        <jsp:include page="/WEB-INF/views/module/navigation.jsp" />
	<!-- Navigation End -->
	
        <!-- Page Content -->
        <div id="page-wrapper">
        <jsp:include page="/WEB-INF/views/module/sport_entries.jsp" />
            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-12">
                        <h1 class="page-header">Blank</h1>
                        
                        <h3>${MemberLogin.memberId }님이 ${MemberLogin.memberLevel }권한으로 로그인중...</h3>
						<h3>현재 선택된 종목은 :${currentSportEntry.getSportEntriesName() }</h3>
                        
                        
                        <h1>

						<!-- 예약 페이지 --> 
						<a href ="${pageContext.request.contextPath}/reservation/reservationTest" >예약 페이지</a> 
						
						<br>
						<!-- 종목 이름 -->
						<a href = "${pageContext.request.contextPath}/login/logined">종목</a>
						<br>
						<!-- 시설 등록페이지 -->					
						<a href ="${pageContext.request.contextPath}/facility/facilityTest" >시설 등록요청 페이지</a>
						<br>					
						<!-- 시설 등록요청 리스트 페이지 -->					
						<a href="${pageContext.request.contextPath}/facility/memberFacilityInsertStatusListForm">시설 등록요청 리스트 페이지(개인용)</a>	
						<br>					
						<!-- 팀 관리 페이지 -->					
						<a href="${pageContext.request.contextPath}/team/teamList">팀</a>	
						</h1>
                        
                        
                        
                    </div>
                    <!-- /.col-lg-12 -->
                </div>
                <!-- /.row -->
            </div>
            <!-- /.container-fluid -->
        </div>
        <!-- /#page-wrapper -->

    </div>
    <!-- /#wrapper -->

<jsp:include page="/WEB-INF/views/module/footerLink.jsp" />
</body>
</html>
