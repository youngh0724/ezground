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
																<form action="${pageContext.request.contextPath}/login" method="post" id="loginInfo">
																<p id='help' class="help-block">로그인 정보를 입력하세요</p>
																	<table>
																		<tr>
																			<td>ID</td>
																			<td><input id="memberId" name="memberId" type="text" value="user"/></td>
																		</tr>
																		<tr>
																			<td>PW</td>
																			<td><input id="memberPw" name="memberPw" type="text" value="1234"/></td>
																		</tr>
																	</table>
																	<input type="hidden" id="memberLevel" name="memberLevel" value="user">
																	<input class="btn btn-default" id="login" type="button" value="login">
																</form>
							                                  </div>
							                                  
							                                <div class="tab-pane fade" id="business">
							                                <h2>사업자 로그인</h2>								
																<form action="${pageContext.request.contextPath}/login" method="post" id="loginInfo">
																<p id='help' class="help-block">로그인 정보를 입력하세요</p>
																	<table>
																		<tr>
																			<td>ID</td>
																			<td><input id="memberId" name="memberId" type="text" value="business"/></td>
																		</tr>
																		<tr>
																			<td>PW</td>
																			<td><input id="memberPw" name="memberPw" type="text" value="1234"/></td>
																		</tr>
																	</table>
																	<input type="hidden" id="memberLevel" name="memberLevel" value="business">
																	<input class="btn btn-default" id="login" type="button" value="login">
																</form>
							                               </div>
							                               
							                                <div class="tab-pane fade" id="admin">
							                                <h2>관리자 로그인</h2>								
																<form action="${pageContext.request.contextPath}/login" method="post" id="loginInfo">
																<p id='help' class="help-block">로그인 정보를 입력하세요</p>
																	<table>
																		<tr>
																			<td>ID</td>
																			<td><input id="memberId" name="memberId" type="text" value="admin"/></td>
																		</tr>
																		<tr>
																			<td>PW</td>
																			<td><input id="memberPw" name="memberPw" type="text" value="1234"/></td>
																		</tr>
																	</table>
																	<input type="hidden" id="memberLevel" name="memberLevel" value="admin">
																	<input class="btn btn-default" id="login" type="button" value="login">
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

    $('#login').click(function(){
    	if ($('#memberId').val() == "") {
			//값이 공백이면
			$('#help').text("");
			$('#help').text("아이디를 입력하세요");
			$('#memberId').focus();
		} else if ($('#memberPw').val() == ""){
			//값이 공백이면
			$('#help').text("");
			$('#help').text("비밀번호를 입력하세요");
			$('#memberPw').focus();
		} else {
			//값이 공백이 아닐시
			$.post('${pageContext.request.contextPath}/loginCheck', 
					{ memberId : $('#memberId').val(), memberPw : $('#memberPw').val()},
					function(data) {
				//입력받은 id값을  idCheckApi.jsp로 넘겨주고 Ajax로 받아온다 (Json파일)
				console.log(data);
				//브라우저 코솔창에 받아온 데이터를 출력한다. 
				if (data == "0") {
					//받아온 데이터의 member_no값이 0이면실행
					$('#help').text("");
					$('#help').text("없는 아이디 입니다.");					
					$('#memberId').focus();
					//중복검사를 실행하고 사용가능한 아이디이면(테이블에 중복되는 아이디가 없으면) check변수값을 true로 바꾼다.
				} else if (data == "1") {
					//member_no감이 0이 아니면 실행
					$('#help').text("");
					$('#help').text("비밀번호가 일치하지 않습니다.");	
					$('#memberPw').focus();
				} else if (data == "2") {
					$('#loginInfo').submit();
				}
			});
		}
    });
    </script>		
			
	</body>
</html>			
