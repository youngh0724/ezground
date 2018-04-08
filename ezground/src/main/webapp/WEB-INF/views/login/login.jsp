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
										<div class="cantainer">
										<div class="col-lg-6">
						                    <div class="panel panel-default">
						                        <div class="panel-heading">
						                           	Log In
						                        </div>
						                        <div class="panel-body">
						                            <div class="row">
						                                <div class="col-lg-12">
									
							                            <!-- Nav tabs -->
							                            <ul class="nav nav-tabs">
							                                <li class="active"><a href="#user" data-toggle="tab">사용자</a></li>
							                                <li><a href="#business" data-toggle="tab">사업자</a></li>
							                                <li><a href="#admin" data-toggle="tab">관리자</a></li>  
							                            </ul>	
							                             <!-- Tab panes -->
							                            <div class="tab-content">
							                                <div class="tab-pane fade in active" id="user">
							                                <h2>사용자 로그인</h2>								
																<form action="${pageContext.request.contextPath}/login" method="post" id="loginInfo1">
																<p id='help1' class="help-block">로그인 정보를 입력하세요</p>
																	<table>
																		<tr>
																			<td>ID</td>
																			<td><input id="memberId1" name="memberId" type="text" value="guest"/></td>
																		</tr>
																		<tr>
																			<td>PW</td>
																			<td><input id="memberPw1" name="memberPw" type="text" value="1234"/></td>
																		</tr>
																	</table>
																	<input type="hidden" id="memberLevel1" name="memberLevel" value="user">
																	<input class="btn btn-default" id="login1" type="button" value="login">
																</form>
							                                  </div>
							                                  
							                                <div class="tab-pane fade" id="business">
							                                <h2>사업자 로그인</h2>								
																<form action="${pageContext.request.contextPath}/login" method="post" id="loginInfo2">
																<p id='help2' class="help-block">로그인 정보를 입력하세요</p>
																	<table>
																		<tr>
																			<td>ID</td>
																			<td><input id="memberId2" name="memberId" type="text" value="business"/></td>
																		</tr>
																		<tr>
																			<td>PW</td>
																			<td><input id="memberPw2" name="memberPw" type="text" value="1234"/></td>
																		</tr>
																	</table>
																	<input type="hidden" id="memberLevel2" name="memberLevel" value="business">
																	<input class="btn btn-default" id="login2" type="button" value="login">
																</form>
							                               </div>
							                               
							                                <div class="tab-pane fade" id="admin">
							                                <h2>관리자 로그인</h2>								
																<form action="${pageContext.request.contextPath}/login" method="post" id="loginInfo3">
																<p id='help3' class="help-block">로그인 정보를 입력하세요</p>
																	<table>
																		<tr>
																			<td>ID</td>
																			<td><input id="memberId3" name="memberId" type="text" value="admin"/></td>
																		</tr>
																		<tr>
																			<td>PW</td>
																			<td><input id="memberPw3" name="memberPw" type="text" value="1234"/></td>
																		</tr>
																	</table>
																	<input type="hidden" id="memberLevel3" name="memberLevel" value="admin">
																	<input class="btn btn-default" id="login3" type="button" value="login">
																</form>
							                                </div>							                             
							                            </div>
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
			
	<script type="text/javascript">


    $('#login1').click(function(){
    	console.log("jquery 실행")
    	if ($('#memberId1').val() == "") {
			//값이 공백이면
			$('#help1').text("");
			$('#help1').text("아이디를 입력하세요");
			$('#memberId1').focus();
		} else if ($('#memberPw1').val() == ""){
			//값이 공백이면
			$('#help1').text("");
			$('#help1').text("비밀번호를 입력하세요");
			$('#memberPw1').focus();
		} else {
			//값이 공백이 아닐시
			$.post('${pageContext.request.contextPath}/loginCheck', 
					{ memberId : $('#memberId1').val(), memberPw : $('#memberPw1').val(), memberLevel : $('#memberLevel1').val()},
					function(data) {
				
				console.log(data);
				//브라우저 코솔창에 받아온 데이터를 출력한다. 
				if (data == "0") {
					//받아온 데이터의 값이 0이면실행
					$('#help1').text("");
					$('#help1').text("없는 아이디 입니다.");					
					$('#memberId1').focus();
					
				} else if (data == "1") {
					
					$('#help1').text("");
					$('#help1').text("비밀번호가 일치하지 않습니다.");	
					$('#memberPw1').focus();
				} else if (data == "2") {
					$('#loginInfo1').submit();
				}
			});
		}
    });   

    
    
    $('#login2').click(function(){
    	console.log("jquery 실행")
    	if ($('#memberId2').val() == "") {
			//값이 공백이면
			$('#help2').text("");
			$('#help2').text("아이디를 입력하세요");
			$('#memberId2').focus();
		} else if ($('#memberPw2').val() == ""){
			//값이 공백이면
			$('#help2').text("");
			$('#help2').text("비밀번호를 입력하세요");
			$('#memberPw2').focus();
		} else {
			//값이 공백이 아닐시
			$.post('${pageContext.request.contextPath}/loginCheck', 
					{ memberId : $('#memberId2').val(), memberPw : $('#memberPw2').val(), memberLevel : $('#memberLevel2').val()},
					function(data) {
				
				console.log(data);
				//브라우저 코솔창에 받아온 데이터를 출력한다. 
				if (data == "0") {
					//받아온 데이터의 값이 0이면실행
					$('#help2').text("");
					$('#help2').text("없는 아이디 입니다.");					
					$('#memberId2').focus();
					
				} else if (data == "1") {
					
					$('#help2').text("");
					$('#help2').text("비밀번호가 일치하지 않습니다.");	
					$('#memberPw2').focus();
				} else if (data == "2") {
					$('#loginInfo2').submit();
				}
			});
		}
    }); 
    
    $('#login3').click(function(){
    	console.log("jquery 실행")
    	if ($('#memberId1').val() == "") {
			//값이 공백이면
			$('#help3').text("");
			$('#help3').text("아이디를 입력하세요");
			$('#memberId3').focus();
		} else if ($('#memberPw3').val() == ""){
			//값이 공백이면
			$('#help3').text("");
			$('#help3').text("비밀번호를 입력하세요");
			$('#memberPw3').focus();
		} else {
			//값이 공백이 아닐시
			$.post('${pageContext.request.contextPath}/loginCheck', 
					{ memberId : $('#memberId3').val(), memberPw : $('#memberPw3').val(), memberLevel : $('#memberLevel3').val()},
					function(data) {
				
				console.log(data);
				//브라우저 코솔창에 받아온 데이터를 출력한다. 
				if (data == "0") {
					//받아온 데이터의 값이 0이면실행
					$('#help3').text("");
					$('#help3').text("없는 아이디 입니다.");					
					$('#memberId3').focus();
					
				} else if (data == "1") {
					
					$('#help3').text("");
					$('#help3').text("비밀번호가 일치하지 않습니다.");	
					$('#memberPw3').focus();
				} else if (data == "2") {
					$('#loginInfo3').submit();
				}
			});
		}
    });
    
    
    </script>		
			
	</body>
</html>			
