<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>${MemberLogin.memberId }님이 ${MemberLogin.memberLevel }권한으로 로그인중...</h3>
	<h3>시설물 등록 요청</h3>
	<form action="${pageContext.request.contextPath}/facility/facilityInsert" method="post" enctype="multipart/form-data">
		<table>
			<tr>
				<td>시설 이름</td>
				<td><input type = "text" id = "facilityName" name = "facilityName"></td>
			</tr>
			<tr>	
				<td>시설 번호</td>
				<td><input type = "text" id = "facilityPhone" name = "facilityPhone"></td>
			</tr>
			<tr>
				<td>시설 주소</td>
				<td><input type = "text" id = "facilityAddress" name = "facilityAddress"></td>
			</tr>	
			<tr>
				<td>공지사항</td>
				<td><input type = "text" id = "facilityNotice" name = "facilityNotice"></td>
			</tr>
			<tr>
				<td>상세정보</td>
				<td><input type = "text" id = "facilityDetail" name = "facilityDetail"></td>
			</tr>
			<tr>
				<td>가격정보</td>
				<td><input type = "text" id = "facilityPrice" name = "facilityPrice"></td>
			</tr>
			<tr>	
				<td>환불규정</td>
				<td><input type = "text" id = "facilityRefund" name = "facilityRefund"></td>
			</tr>
			<tr>	
				<td>이용규칙</td>
				<td><input type = "text" id = "facilityRule" name = "facilityRule"></td>
			</tr>
			<tr>	
				<td>사업자 번호</td>
				<td><input type = "text" id = "facilityLicenseeNo" name = "facilityLicenseeNo"></td>
			</tr>
			<!-- 글의 상태  -->
			<tr>	
				<td><input type = "hidden" id = "facilityStatus" name = "facilityStatus" value="승인 요청"></td>
			</tr>
			<tr>
				<td>파일</td>
			</tr>
			<tr>
				<td><input type = "file" name = "files" multiple = "multiple"></td>
			</tr>
			<tr>
			<td><input Type = "submit" value = "등록요청"></td>
			</tr>
		</table>
	</form>
</body>
</html>