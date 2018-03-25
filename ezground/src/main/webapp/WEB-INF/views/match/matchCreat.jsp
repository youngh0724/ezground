<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<h2>매치 생성하기 페이지</h2>

<form action="${pageContext.request.contextPath}/creatMatch" method="post">
		<table class="table table-striped">		
			<tr>
				<td>일정</td>
				<td><input id="calendar" name="calendar" type="date"/></td>
			</tr>
			<tr>
				<td>시간</td>
				<td><input id="time" name="time" type="text"/></td>
			</tr>
			<tr>
				<td>지역 선택</td>
				<td>
					<select name="matchNoticeRegion">
					    <option value="seoul">서울</option>
					    <option value="gyeong-gi">경기</option>
					    <option value="gang-won">강원</option>
					    <option value="chung-cheong">충청</option>
					    <option value="jeon-ra">전라</option>
					    <option value="je-ju">제주</option>
					    <option value="gyeong-sang">경상</option>					    
					</select>			
				</td>
			</tr>
			<tr>
				<td>한 팅당 최소 참여 인원수</td>
				<td><input id="matchMemberCount" name="matchMemberCount" type="text"/></td>
			</tr>	
		</table>
		<input id="teamNo" name="teamNo" type="hidden" value="${teamNo}" }/>
		<input id="matchCreat" type="submit" value="매치생성">
	</form>	







</body>
</html>