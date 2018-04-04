<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
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
		var f_sel = f.SportEntriesName;
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
		var f_sel = f.SportEntriesName;
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

<body onload = "init(this.form);">	
										<h2>구장 등록 페이지</h2>		
											<form name="form" action = "${pageContext.request.contextPath}/facility/fieldInsert" method="post">>
												<table class="table table-striped">
													<tr>
													<td>종목</td>
													<td><select id = "SportEntriesName" name ="SportEntriesName" onchange="itemChange(this.form);" ></select></td>
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
													<input type = "hidden" name = "facilityNo" id = "facilityNo" value="${FacilityNo}">
												</table>
												<input type = "submit" value = "등록">
											</form>	
</body>
</html>
