<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
 	<!-- jQuery -->
    <script src="${pageContext.request.contextPath}/resources/sbAdmin2/vendor/jquery/jquery.min.js"></script>
       <SCRIPT language=JavaScript>
	
	var f_selbox = new Array('풋살', '테니스', '배드민턴');

	var s_selbox = new Array();
	s_selbox[0] = new Array('20m:38m', '22m:40m', '25m:42m');
	s_selbox[1] = new Array('8.27m:23.78m(단식)', '10.97m:23.78(복식)');
	s_selbox[2] = new Array('6.10m:13,40m(단식or 복식)');
	
	var t_selbox = new Array();
	t_selbox[0] = new Array('3:3', '4:4', '5:5');
	t_selbox[1] = new Array('단식', '복식');
	t_selbox[2] = new Array('단식', '복식');
	

	function init(f){
		var f_sel = f.sprotEntriesName;
		var s_sel = f.fieldSize;
		var t_sel = f.fieldNumber;

		f_sel.options[0] = new Option("선택", "");
		s_sel.options[0] = new Option("선택", "");
		t_sel.options[0] = new Option("선택", "");

		for(var i =0; i<f_selbox.length; i++){
			f_sel.options[i+1] = new Option(f_selbox[i], f_selbox[i]);
		}
	}

	function itemChange(f){
		var f_sel = f.sprotEntriesName;
		var s_sel = f.fieldSize;
		var t_sel = f.fieldNumber;
		// 1번째셀렉트 박스
		var sel = f_sel.selectedIndex;
		
		// 2번째 셀렉트 박스
		for(var i=s_sel.length; i>=0; i--){
			s_sel.options[i] = null;
		}

		s_sel.options[0] = new Option("선택", "");
		t_sel.options[0] = new Option("선택", "");

		if(sel != 0){
			for(var i=0; i<s_selbox[sel-1].length; i++){
				s_sel.options[i+1] = new Option(s_selbox[sel-1][i], s_selbox[sel-1][i]);
			}
		}
		// 3번째 셀렉트 박스
		for(var i=t_sel.length; i>=0; i--){
			t_sel.options[i] = null;
		}
		t_sel.options[0] = new Option("선택", "");
		if(sel != 0){
			for(var i=0; i<t_selbox[sel-1].length; i++){
				t_sel.options[i+1] = new Option(t_selbox[sel-1][i], t_selbox[sel-1][i]);
			}
		}
	}

   </SCRIPT>
<head>
		<title>EZ Ground</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
		<!--[if lte IE 8]><script src="assets/js/ie/html5shiv.js"></script><![endif]-->
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/assets/css/main.css" />
		<!--[if lte IE 9]><link rel="stylesheet" href="assets/css/ie9.css" /><![endif]-->
		<!--[if lte IE 8]><link rel="stylesheet" href="assets/css/ie8.css" /><![endif]-->
</head>

<body onload = "init(this.form);">	

		<!-- Wrapper -->
			<div id="wrapper">

				<!-- Main -->
					<div id="main">
						<div class="inner">
						<jsp:include page="/WEB-INF/views/module/header.jsp" />
						<!-- Banner -->
								<section id="banner">
									<div class="content">
										<h2>구장 등록 페이지</h2>		
											<form name="form">
												<table class="table table-striped">
													<tr>
													<td>종목</td>
													<td><select id = "sprotEntriesName" name ="sprotEntriesName" onchange="itemChange(this.form);" ></select></td>
													</tr>
													<tr>
													<td>구장 이름</td>
													<td><input type = "text" id = "fieldName" name = "fieldName"></td>
													</tr>
													<tr>
													<td>구장 규격</td>
													<td><select id = "fieldSize" name = "fieldSize" ></select></td>
													</tr>
													<tr>
													<td>구장 가격</td>
													<td><input type = "text" id = "fieldPrice" name = "fieldPrice"></td>
													</tr>
													<tr>
													<td>적정 인원</td>
													<td><select id = "fieldNumber" name = "fieldNumber"></select></td>
													</tr>
													<c:forEach var="FacilityNo" items="${FacilityNo}">
													<input type = "hidden" id = "facilityNo" name = "facilityNo" value = "">
													</c:forEach>
												</table>
												<input type = "submit" value = "등록">
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

</body>
</html>