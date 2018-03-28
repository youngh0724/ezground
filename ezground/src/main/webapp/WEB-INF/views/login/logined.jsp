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

<h2>member Logined Page</h2>

<h3>${MemberLogin.memberId }님이 ${MemberLogin.memberLevel }권한으로 로그인중...</h3>
<h3>현재 선택된 종목은 :${currentSportEntry.getSportEntriesName() }</h3>


			<table border="1">
					<thead>
						<tr>
							<th>경기 종목</th>												
						</tr>
					</thead>
					<tbody>
						<c:forEach var="entry" items="${list}">
							<tr>						
								<td><a href="${pageContext.request.contextPath}/login/logined?entryNo=${entry.sportEntriesNo-1}">${entry.sportEntriesName}</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>

<br>
<a href ="${pageContext.request.contextPath}/creatMatch?entryNo=${currentSportEntry.getSportEntriesNo()}" >매치 생성하기</a> 
<br>
<a href ="${pageContext.request.contextPath}/match/matchSelect" >매치 검색 페이지로..</a>

</body>
</html>