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
									
									<h2>회원 가입 페이지</h2>
										<div class="row">
											<div class="col-lg-6">
												<div class="panel panel-default">
													<div class="panel-heading">회원 가입 정보 입력</div>
													<div class="panel-body">
														<div class="row">
															<div class="col-lg-12">
																<form role="form" action="${pageContext.request.contextPath}/memberInsert" method="post">
																	<p id='help' class="help-block"></p>
																	<div class="form-group">
							                                            <label>아이디<button id="idOverlapCheck" type="button">중복체크</button></label>							                                           
							                                            <input id="memberId" name="memberId" type="text" class="form-control" placeholder="">
							                                        </div>
							                                        <div class="form-group">
							                                            <label>비밀번호</label>							                                           
							                                            <input id="memberPw" name="memberPw" type="password" class="form-control" placeholder="">
							                                        </div>
							                                        <div class="form-group">
							                                            <label>비밀번호 확인</label>							                                           
							                                            <input id="memberPwCheck" name="memberPwCheck" type="password" class="form-control" placeholder="">
							                                        </div>
							                                        <div class="form-group">
							                                            <label>이름</label>							                                           
							                                            <input id="memberName" name="memberName" type="text" class="form-control" placeholder="">
							                                        </div>
							                                        <div class="form-group">
							                                            <label>나이</label>							                                           
							                                            <input id="memberAge" name="memberAge" type="text" class="form-control" placeholder="">
							                                        </div>
							                                        <div class="form-group">
							                                        	<label>성별</label>
								                                        <label class="radio-inline"><input type="radio" name="memberGender" id="memberGender1" value="남" checked>남자</label>
								                                        <label class="radio-inline"><input type="radio" name="memberGender" id="memberGender2" value="여">여자</label>
								                                    </div>
								                                    <div class="form-group">
							                                            <label>전화번호</label>							                                           
							                                            <input id="memberPhone" name="memberPhone" type="text" class="form-control" placeholder="">
							                                        </div>
							                                        <div class="form-group">
							                                            <label>이메일</label>							                                           
							                                            <input id="memberEmail" name="memberEmail" type="text" class="form-control" placeholder="">
							                                        </div>
							                                        <div class="form-group">
							                                            <label>주소</label>							                                           
							                                            <input id="memberAddress" name="memberAddress" type="text" class="form-control" placeholder="">
							                                        </div>
							                                        <input id="memberInsert" name="memberInsert" type="button" value="회원가입">
																</form>
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
	<script type="text/javascript">

	let check = false;

    $('#idOverlapCheck').click(function(){
    	if ($('#memberId').val() == "") {
			//값이 공백이면
			$('#help').text("");
			$('#help').text("아이디를 입력하세요");
			$('#memberId').focus();
		} else {
			//값이 공백이 아닐시
			$.post('${pageContext.request.contextPath}/idOverlapCheck', { memberId : $('#memberId').val()}, function(data) {
				//입력받은 id값을  idCheckApi.jsp로 넘겨주고 Ajax로 받아온다 (Json파일)
				console.log(data);
				//브라우저 코솔창에 받아온 데이터를 출력한다. 
				if (data == 0) {
					//받아온 데이터의 member_no값이 0이면실행
					$('#help').text("");
					$('#help').text("사용가능한 아이디입니다.");					
					check = true;
					//중복검사를 실행하고 사용가능한 아이디이면(테이블에 중복되는 아이디가 없으면) check변수값을 true로 바꾼다.
				} else {
					//member_no감이 0이 아니면 실행
					$('#help').text("");
					$('#help').text("중복된 아이디입니다.");					
					$('#idOverlapCheck').val("");
					$('#idOverlapCheck').focus();
				}
			});
		}

	});
       
    
    $('#memberInsert').click(function() {
	
		if (check) {
		
			if($('#memberPw').val() == ""){
				
				alert("비밀번호를 입력하세요");
				$('#memberPw').focus();
				
			} else {
				
				if ($("#memberPw").val() != $("#memberPwCheck").val()) {
								
					alert("입력한 비밀번호와 비밀번호 확인이 일치하지 않습니다.");
				
					$("#memberPwCheck").val("");
					$("#memberPwCheck").focus();
				} else if ($("#memberPw").val() == $("#memberPwCheck").val()) {
					//입력받은 비밀번호의 값이 일치하면
					alert("회원가입 성공!");
					$('form').submit();

				}
			}

		} else {
			alert("중복검사를 실행하십시오!")
		}

	});


</script>
</html>			
