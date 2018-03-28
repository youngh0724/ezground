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

<h2>매치 검색 페이지</h2>


	<table border="1">
		<thead>
			<tr>
				<th>매치 종류</th>
				<th>매치 팀당 최소 인원수</th>
				<th>매치 상태</th>
				<th>매치 지역</th>
				<th>매치 예정일</th>
				<th>매치 예정시간대</th>
				<th>매치 상세 정보</th>
			</tr>	
		</thead>
		<tbody>
			<c:forEach var="matchNoticeInfo" items="${matchNoticeList}">
				<tr>
					<td>${matchNoticeInfo.matchKinds }</td>
					<td>${matchNoticeInfo.matchMemberCount }</td>
					<td>${matchNoticeInfo.matchNoticeStatus }</td>
					<td>${matchNoticeInfo.matchNoticeRegion }</td>
					<td>${matchNoticeInfo.matchExpectedDay }</td>
					<td>${matchNoticeInfo.matchExpectedStartTime}~${matchNoticeInfo.matchExpectedEndTime}</td>
					<td><a href ="${pageContext.request.contextPath}/match/matchNoticeInfomation?matchNoticeNo=${matchNoticeInfo.matchNoticeNo}" >상세보기</a></td>
				</tr>	
			</c:forEach>					
		</tbody>
	</table>




</body>
</html>