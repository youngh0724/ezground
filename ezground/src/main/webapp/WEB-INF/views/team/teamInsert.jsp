<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<script src="../resources/jquery-3.3.1.min.js"></script>
	
</head>
<body>

	<h2>Team insert form</h2>
	<div class="row">
          <div class="col-sm-6 col-lg-6">
	<form action="${pageContext.request.contextPath}/team/teamInsert" method="post">
		<table class="table table-striped" data-effect="fade">
			<tr>
				<td>종목</td>
				<td><input id="sportEntries" name="sportEntries" type="text"/></td>
			</tr>
			<tr>
				<td>팀 이름</td>
				<td><input id="teamName" name="teamName" type="text"/></td>
			</tr>		
			<tr>
				<td>지역</td>
				<td><input id="teamRegion" name="teamRegion" type="text"/></td>
			</tr>
			<tr>
				<td>나이대</td>
				<td><input id="teamAges" name="teamAges" type="text"/></td>
			</tr>
			<tr>
				<td>팀 소개</td>
				<td><textarea id="teamIntro" name="teamIntro"></textarea></td>				
			</tr>			
				
		</table>
		<input id="insert" type="button" value="추가">
	</form>	
	
	<script>
		$('#insert').click(function(){
			if($('#teamName').val() == ''){
				alert('팀 이름을 입력하세요');
				$('#teamName').focus();
			}else if($('#teamRegion').val() == ''){
				alert('지역을 입력하세요');
				$('#teamRegion').focus();
			}else if($('#teamAges').val() == ''){
				alert('지역을 나이대를 선택하세요');
				$('#teamAges').focus();
			}else{
				$('form').submit();
			}
		})
		
	</script>
	</div>
	</div>
</body>



