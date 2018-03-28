<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>	
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<h2>매치 상세보기 페이지</h2>

	<table border="1">		
		<tr>
			<td>매치 예정일</td>
			<td>${matchNotice.matchExpectedDay }</td>
		</tr>
		<tr>
			<td>매치 예정 시간대</td>
			<td>${matchNotice.matchExpectedStartTime }~${matchNotice.matchExpectedEndTime }</td>
		</tr>
		<tr>
			<td>매치 종류</td>
			<td>${matchNotice.matchKinds }</td>
		</tr>
		<tr>
			<td>매치 예정 지역</td>
			<td>${matchNotice.matchNoticeRegion }</td>
		</tr>
		<tr>
			<td>팀당 인원 설정</td>
			<td>${matchNotice.matchMemberCount }</td>
		</tr>
		<tr>
			<td>매치 상태</td>
			<td>${matchNotice.matchNoticeStatus }</td>
		</tr>
		<tr>
			<td>매치 생성일</td>
			<td>${matchNotice.matchNoticeInsertDate }</td>
		</tr>
	</table>
	
	<table border="1">
		<thead>
			<tr>			
				<th>홈팀 참가자</th>							
			</tr>
		</thead>
		<tbody>
			<c:forEach var="matchJoinMember" items="${homeTeamMember}">
				<tr>
					<td>${matchJoinMember }</td>					
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<table border="1">
		<thead>
			<tr>			
				<th>원정팀 참가자</th>							
			</tr>
		</thead>
		<tbody>
			<c:forEach var="matchJoinMember" items="${awayTeamMember}">
				<tr>
					<td>${matchJoinMember }</td>					
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<br>
	<a href ="${pageContext.request.contextPath}/match/matchJoin?matchNoticeNo=${matchNotice.matchNoticeNo}" >매치 맴버 참가 신청</a>
	<br>
	<a href ="${pageContext.request.contextPath}/match/matchSelect" >매치 검색 페이지로..</a>
	
</body>
</html>