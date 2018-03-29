<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Insert title here</title>
</head>

<body>

		<h2>Team List</h2>
		<div class="row" style="margin-bottom: 30;">
			<div class="col-sm-12 col-lg-12">
				
				<table border="1">
			
					<thead>
						<tr>
							<th>팀 번호</th>
							<th>종목</th>
							<th>팀 이름</th>
						</tr>
						<tr>
						
							<td>${team.teamNo}</td>
							<td>${team.sportEntriesNo}</td>
							<td>${team.teamName}</td>
					
						</tr>
						<tr>							
							<th>활동 지역</th>
							<th>나이대</th>
							<th>팀 수준</th>							
						</tr>
						<tr>
							<td>${team.teamRegion}</td>
							<td>${team.teamAges}</td>
							<td>${team.teamLevel}</td>
						</tr>
						<tr>
							<th>승</th>
							<th>무</th>
							<th>패</th>	
												
						</tr>
						<tr>
							<td>${team.teamWin}</td>
							<td>${team.teamDraw}</td>
							<td>${team.teamLose}</td>
							
						</tr>						
						<tr>							
							<th>승점</th>	
							<th>게임 횟수</th>
							<th>팀 생성일</th>
						</tr>				
						<tr>
							<td>${team.teamVictoryPoint}</td>
							<td>${team.teamGameCount}</td>
							<td>${team.teamCreatedDate}</td>
						</tr>
						<tr>
							<th colspan="3">팀 소개ddddd</th>
						</tr>
						<tr>
							<td colspan="3">${team.teamIntro}</td>
					</thead>
					<tbody>						
							
					</tbody>
				
				</table>
				<a class="btn btn-default" href="${pageContext.request.contextPath}/team/teamList">리스트로 돌아가기</a>
				
				<script type = "text/javascript">
					function btn_team_join() {
						if(confirm("가입 신청 메세지를 보내시겠습니까?") == true) {
						   location.href = "${pageContext.request.contextPath}/teamMember/teamMemberInsert?teamNo=${team.teamNo}"
						}else{
						   return;
						}
					}
				</script>
				<input type="button" value="팀 가입하기" onclick="btn_team_join();">
			</div>
		</div>
		
<jsp:include page="/WEB-INF/views/module/footer.jsp" />

		
