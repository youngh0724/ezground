<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<title>Insert title here</title>
</head>
<body>
	<h2>부대 시설 여부</h2>
		<table>
			<thead>
				<tr>
					<th>부대 시설 번호</th>
					<th>부대시설 이름</th>
					<th>등록</th>
					<th>삭제</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach var="subList" items="${List}">
			<tr>
				<td>${subList.subNo}</td>
				<td>${subList.subName}</td>
				<td><a id = "insert" href ="${pageContext.request.contextPath}/facility/facilitySubInsert?facilitySubNo=${subList.subNo}&facilityNo=${Facility.facilityNo}">등록</a></td>
				<td><a href ="${pageContext.request.contextPath}/facility/facilitySubDelete?facilitySubNo=${subList.subNo}&facilityNo=${facility.facilityNo}" >삭제</a></td>
			</tr>
			</c:forEach>
			</tbody>
		</table>
		<table>
			<thead>
				<tr>
				<th>시설 번호</th>
				<th>부대 시설 번호</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach var="facilityAndFacilitySubList" items="${facilityAndFacilitySub}">
			<tr>
				<td>${facilityAndFacilitySubList.facilityNo}</td>
				<td>${facilityAndFacilitySubList.subNo}</td>
			</tr>
			</c:forEach>	
			</tbody>
		</table>
		<script> $("insert").click(function () { 
			$(this).next().removeAttr("disabled")
			.focus() 
			}); 
		</script>

</body>
</html>