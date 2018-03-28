<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>관리자용 시설 등록신청 리스트 페이지</h3>
	
	<table class="table table-striped" data-effect="fade">
					<thead>
						<tr>
							<th>회원 번호</th>
							<th>이름</th>
							<th>시설번호</th>
							<th>시설 이름</th>
							<th>시설 전화번호</th>
							<th>시설 주소</th>
							<th>공지 사항</th>
							<th>상세 정보</th>
							<th>가격 정보</th>
							<th>환불 규정</th>
							<th>이용규칙</th>
							<th>사업자 번호</th>
							<th>반려 지적사항</th>
							<th>승인/거절</th>
							<th>등록 날짜</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="facilityAndMemberList" items="${facilityAndMember.list}">
							<tr>
								<td>${facilityAndMemberList.memberNo}</td>
								<td>${facilityAndMemberList.memberName}</td>
								<td>${facilityAndMember.facilityNo}</td>
								<td>${facilityAndMember.facilityName}</td>
								<td>${facilityAndMember.facilityPhone}</td>
								<td>${facilityAndMember.facilityAddress}</td>
								<td>${facilityAndMember.facilityNotice}</td>
								<td>${facilityAndMember.facilityDetail}</td>
								<td>${facilityAndMember.facilityPrice}</td>
								<td>${facilityAndMember.facilityRefund}</td>
								<td>${facilityAndMember.facilityRule}</td>
								<td>${facilityAndMember.facilityLicenseeNo}</td>
								<td>${facilityAndMember.facilityReturn}</td>
								<td>${facilityAndMember.facilityStatus}</td>
								<td>${facilityAndMember.facilityWriteDate}</td>
								
								<td><a
									href="${pageContext.request.contextPath}/idol/idolUpdate?idolId=${I.idolId}">수정</a></td>
								<td><a
									href="${pageContext.request.contextPath}/idol/idolDelete?idolId=${I.idolId}">삭제</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
</body>
</html>