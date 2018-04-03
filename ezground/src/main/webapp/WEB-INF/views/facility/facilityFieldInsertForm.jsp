<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
		var f_sel = f.sportEntriesName;
		var s_sel = f.FieldSize;
		var t_sel = f.fieldNumber;

		f_sel.options[0] = new Option("선택", "");
		s_sel.options[0] = new Option("선택", "");
		t_sel.options[0] = new Option("선택", "");

		for(var i =0; i<f_selbox.length; i++){
			f_sel.options[i+1] = new Option(f_selbox[i], f_selbox[i]);
		}
	}

	function itemChange(f){
		var f_sel = f.sportEntriesName;
		var s_sel = f.FieldSize;
		var t_sel = f.fieldNumber;

		var sel = f_sel.selectedIndex; //1
		for(var i=s_sel.length; i>=0; i--){ // 
			s_sel.options[i] = null;
			t_sel.options[i] = null;
		}	

		s_sel.options[0] = new Option("선택", "");
		t_sel.options[0] = new Option("선택", "");

		if(sel != 0){
			for(var i=0; i<s_selbox[sel-1].length; i++){
				s_sel.options[i+1] = new Option(s_selbox[sel-1][i], s_selbox[sel-1][i]);
			}
		}
		// 3번쨰 셀박
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
   <title>Home</title>
</head>

<body onload = "init(this.form);">	
	<form name="form" action ="${pageContext.request.contextPath}/facility/facilityFieldInsert" method="post">
		<table>
		<tr>
		<td>구장 이름</td> 
		<td><input type = "text" id = "facilityFieldName" name = "facilityFieldName"></td>
		</tr>
		<tr>
		<td>종목 </td>
		<td><select id = "sportEntriesName" name = "sportEntriesName" onchange = "itemChange(this.form);"></select></td>
		</tr>
		<tr>
		<td>구장 크기</td>
		<td><select id = "FieldSize" name= "FieldSize"></select><td>
		</tr>
		<tr>
		<td>사용 가격</td>
		<td><input type = "text" id = "fieldPrice" name = "fieldPrice">
		</tr>
		<tr>
		<td>구장 적정인원</td>
		<td><select id = "fieldNumber" name = "fieldNumber"></select></td>
		</tr>
		<tr>
		<td><input type = "submit" value = "등록"></td>
		</tr>
		</table>
	</form>
</body>
</html>