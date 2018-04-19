<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE HTML>
<html>
<head>
<title>Insert title here</title>
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
						<h2>구장 예약</h2>

						<div class="row" style="margin-bottom: 30;">
							<div class="col-sm-12 col-lg-12">	
									
								<div class="panel panel-default">
									<div class="panel-body">
								    	<form name="frmJoin" action=""  onSubmit="return CheckForm(this)">
								  	
											<div class="col-sm-6"><h4>개인정보 제 3자 제공 방침 및 시설 이용 약관</h4> 									
												<textarea id="appointment1" style="width:75%;height:200px;border:1;overflow:visible;text-overflow:ellipsis;">											
												</textarea>
												<input type="checkbox" id="agree1" name="agree1" />
   												<label for="agree1"><span></span>위의 개인정보 취급 방침에 동의합니다.</label>
											</div>
																			
											<div class="col-sm-6"><h4>&nbsp;</h4>
												<textarea id="appointment2" style="width:75%;height:200px;border:1;overflow:visible;text-overflow:ellipsis;">										
												</textarea>	
												<input type="checkbox" id="agree2" name="agree2" />
		   										<label for="agree2"><span></span>위의 시설 이용 약관에 동의합니다.</label>									
											</div>
								
											<div class="col-sm-6">
												<br><h4>예약 정보 확인</h4><br>										
												구장 이름 : ${reserv.get(0).fieldName} <br>
												위치 : ${reserv.get(0).facilityAddress} <br>
												예약 일자 : <fmt:formatDate value="${reserv.get(0).calendarDate}" pattern="yyyy-MM-dd" /> <br>
												경기 시간 : ${reserv.get(0).calendarStartTime}~${reserv.get(0).calendarEndTime}	
																						
											</div>
											<div class="col-sm-6">
												<br><h4>결제 정보 확인</h4><br>
												이용 비용 : ${reserv.get(0).fieldPrice} <br>												
											</div>										
								</form>								
									</div>
								</div>
								
								<a class="btn btn-default"
									href="${pageContext.request.contextPath}/facility/facilityFieldList">리스트로 돌아가기</a> 
									<input type="button" class="btn btn-defalut" value="예약하기" onclick="btn_reserv();">
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
		var chk1=document.frmJoin.agree1.checked;
		var chk2=document.frmJoin.agree2.checked;
		if(!chk1){
            alert('약관1에 동의해 주세요');
            return false;
        } 
        if(!chk2) {
            alert('약관2에 동의해 주세요');
            return false;
        }	
		if (confirm("예약 화면으로 이동하시겠습니까?") == true) {
			location.href = "${pageContext.request.contextPath}/reservation/reservationInsert?fieldNo=${field.fieldNo}&calendar"
		} else {
			return;
		}
	}

	$(document).ready(function() {
	$('#appointment1').text('대관 서비스 개인정보 제3자 제공 방침 \n\n'
					+'1. 수집 항목 : 실명, 휴대전화번호, 이메일, 주소, 생년월일, ID 등\n'
					+'2. 수집 목적 : 시설 대관 관리 \n'
					+'3. 보관 기간 : 대관 일시로부터 1년 \n'
					+'4. 제공 받는 자 : 해당 체육시설 대관 서비스 개인정보 제3자 제공 방침에 동의하지 않을 수 있습니다. \n'
					+'본 방침에 동의하지 않을 시 해당 시설과 대관 서비스를 이용 하실 수 없습니다.');
	$('#appointment2').text('시설 이용 약관 \n\n'
			+'1. 건물 내부 및 근처에서 절대 금연입니다.\n'
			+'2. 체육시설 내 음식물, 주류, 음료 반입 금지합니다.\n'
			+'3. 시설 이용 중 시설물 및 기물 파손은 즉각 담당자에게 보고해야하며, 대관 신청자가 원상복구 혹은 변상해야 합니다.\n'
			+'4. 시설물 및 기물의 용도와 위치의 변경, 광고물(현수막 등) 설치 등은 반드시 관리자에게 사전 승인을 받아야합니다.\n'
			+'5. 해당 시설을 이용한 상업 행위, 유료 강습, 이윤추구는 엄격하게 금지되어 있습니다.\n'
			+'6. 시설 이용 후 폐기물, 오물 등 뒷정리 및 원상복구 해주셔야 합니다.\n'
			+'7. 대관 확정 후 시설의 급한 사정으로 인해 대관이 취소 될 수 있으며, 이점 협조 부탁드립니다.\n'
			+'8. 과도한 소음 및 소란 행위는 금지되어 있습니다.\n'
			+'9. 체육 경기 외 목적(행사 진행 등)으로 이용 시 담당자에게 사전 승인을 받아야합니다.\n'
			+'10. 미풍양속을 해치는 행위, 풍기문란 행위, 노상방뇨 등은 금지되어 있습니다.\n'
			+'11. 본 시설은 시설 이용 시 발생 할 수 있는 부상 및 사고 발생 등 모든 재해에 책임지지 않습니다.\n'
			+'12. 본 시설을 대관 한 후 타인에게 무단 양도하는 행위는 엄격히 금지되어 있습니다.\n'
			+'13. 본 내용을 위반 하였을 시, 이용 취소 및 제재가 가해지며 이로 인한 손해는 전적으로 책임자 및 해당 팀에게 있습니다.\n'
			+'14. 시설 물 이용 중 모든 이용자에게 선량한 관리자의 의무가 부여됩니다. 허가받지 않은 제 3자의 무단이용, 홍보행위, 기물 파손, 소음 발생 등의 행위를 제지해주십시오.\n'
			+'15. 본 시설은 애완동물 출입 및 바퀴달린 운동기구 이용이 금지되어 있습니다.\n'
			+'16. 본 내용에 대한 동의 서명은 생략하며, 서비스 내 동의 버튼으로 이를 대체합니다.');
	
	
	});

</script>



</html>

