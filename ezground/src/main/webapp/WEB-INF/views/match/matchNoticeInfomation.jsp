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
			<td>${conditionInfo.matchNotice.matchExpectedDay }</td>
		</tr>
		<tr>
			<td>매치 예정 시간대</td>
			<td>${conditionInfo.matchNotice.matchExpectedStartTime }~${conditionInfo.matchNotice.matchExpectedEndTime }</td>
		</tr>
		<tr>
			<td>매치 종류</td>
			<td>${conditionInfo.matchNotice.matchKinds }</td>
		</tr>
		<tr>
			<td>매치 예정 지역</td>
			<td>${conditionInfo.matchNotice.matchNoticeRegion }</td>
		</tr>
		<tr>
			<td>팀당 인원 설정</td>
			<td>${conditionInfo.matchNotice.matchMemberCount }</td>
		</tr>
		<tr>
			<td>매치 상태</td>
			<td>${conditionInfo.matchNotice.matchNoticeStatus }</td>
		</tr>
		<tr>
			<td>매치 생성일</td>
			<td>${conditionInfo.matchNotice.matchNoticeInsertDate }</td>
		</tr>
	</table>
		
	<table border="1">
		<thead>
			<tr>			
				<th>홈팀 참가자</th>							
			</tr>
		</thead>
		<tbody>
			<c:forEach var="matchJoinMember" items="${conditionInfo.homeTeamMember}">
				<tr>
					<td>${matchJoinMember.memberId }</td>					
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<c:set var="awayTeamMember" value="${conditionInfo.awayTeamMember}"></c:set>
	<c:if test = "${!empty awayTeamMember}">
	<table border="1">
		<thead>
			<tr>			
				<th>원정팀 참가자</th>							
			</tr>
		</thead>
		<tbody>
			<c:forEach var="matchJoinMember" items="${awayTeamMember}">
				<tr>
					<td>${matchJoinMember.memberId }</td>					
				</tr>
			</c:forEach>
		</tbody>
	</table>
	</c:if>
	
	<c:set var="joinAwayTeamMember" value="${conditionInfo.joinAwayTeamMember}"></c:set>
	<c:if test = "${!empty joinAwayTeamMember}">
	<table border="1">
		<thead>
			<tr>			
				<th>원정팀 참가자</th>							
			</tr>
		</thead>
		<tbody>
			<c:forEach var="matchJoinMember" items="${joinAwayTeamMember}">
				<tr>
					<td>${matchJoinMember.memberId }</td>					
				</tr>
			</c:forEach>
		</tbody>
	</table>
	</c:if>
	
	<c:set var="myTeamMember" value="${conditionInfo.myTeamMember}"></c:set>
	<c:if test = "${!empty myTeamMember}">
	<table border="1">
		<thead>
			<tr>			
				<th>원정팀 참가자</th>							
			</tr>
		</thead>
		<tbody>
			<c:forEach var="matchJoinMember" items="${myTeamMember}">
				<tr>
					<td>${matchJoinMember.memberId }</td>					
				</tr>
			</c:forEach>
		</tbody>
	</table>
	</c:if>
	
	<!-- 매치에 참가 되어있는지  -->
            <c:set var="memberLevel" value="${conditionInfo.memberLevel}"></c:set>
            <c:choose>
            	
            	<c:when test="${empty memberLevel}">
	
	<!-- 매치에 참가 되어있는지  -->
            <c:set var="isTeamMember" value="${conditionInfo.isTeamMember}"></c:set>
            <c:choose>
            	
            	<c:when test="${empty isTeamMember}">
	
	<a href ="${pageContext.request.contextPath}/match/matchJoin?matchNoticeNo=${conditionInfo.matchNotice.matchNoticeNo}" >매치 맴버 참가 신청</a>
				</c:when>
				<c:otherwise>
	<br>
	<a href ="${pageContext.request.contextPath}/match/matchJoinCancel?matchNoticeNo=${conditionInfo.matchNotice.matchNoticeNo}" >매치 맴버 참가 취소</a>			
				
				</c:otherwise>
				</c:choose>
				</c:when>
				<c:otherwise>
	<br>
	<a href ="${pageContext.request.contextPath}/match/matchNoticeDelete?matchNoticeNo=${conditionInfo.matchNotice.matchNoticeNo}" >매치 공고 삭제</a>				
				
				</c:otherwise>
				</c:choose>
	<br>
	<a href ="${pageContext.request.contextPath}/match/matchSelect" >매치 검색 페이지로..</a>
	
</body>
<script type="text/javascript">

	console.log('${conditionInfo.matchNotice}');
	console.log('${conditionInfo.memberLevel}');
	console.log('${conditionInfo.isTeamMember}');

</script>




</html>