<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="../resources/jquery-3.3.1.min.js"></script>
</head>
<body>

	<div class="container">
	

		<h2>팀 정보 수정</h2>
		<div class="row">
			<div class="col-sm-6 col-lg-6">
				<form action="${pageContext.request.contextPath}/team/teamUpdate"
					method="post">
					<table class="table table-striped" data-effect="fade">	
						<tr>
							<td>팀 번호</td>
							<td><input type="number" id="teamNo" name="teamNo" value="${team.teamNo}" readonly="readonly"></td>						</tr>				
						<tr>
							<td>팀 이름</td>
							<td><input type="text" id="teamName" name="teamName" value="${team.teamName}"></td>
						</tr>
						<tr>
							<td>지역</td>
							<td><input type="text" name="teamRegion" value="${team.teamRegion}"></td>
						</tr>
						<tr>
							<td>나이대</td>
							<td><input type="text" name="teamAges" value="${team.teamAges}"></td>
						</tr>
						<tr>
							<td>팀 소개</td>
							<td><input type="text" name="teamIntro" value="${team.teamIntro}"></td>
						</tr>
					</table>
					<input id="update" type="button" value="수정">
				</form>
				<script>
					$('#update').click(function() {
						if ($('#teamName').val() == '') {
							alert('팀 이름을 입력하세요');
							$('#teamName').focus();
						}if ($('#teamRegion').val() == '') {
							alert('지역을 입력하세요');
							$('#teamRegion').focus();
						}if ($('#teamAges').val() == '') {
							alert('나이대를 입력하세요');
							$('#teamAges').focus();
						}if ($('#teamIntro').val() == '') {
							alert('팀 소개를 입력하세요');
							$('#teamIntro').focus();
						}else {
							$('form').submit();
						}
					})
				</script>
			</div>
		</div>
	</div>
</body>

