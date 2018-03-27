<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>

<script src="${pageContext.request.contextPath}/resources/jquery-3.3.1.min.js"></script>
<body>

<h2>회원 가입 페이지</h2>

	<form action="${pageContext.request.contextPath}/memberInsert" method="post">
	<table border="1">
		<tr>
			<td></td>
			<td><span id="checkMsg"></span></td>
		</tr>
		<tr>
			<td>아이디 <button id="idOverlapCheck" type="button">중복체크</button></td>			
			<td><input id="memberId" name="memberId" type="text" value=""></td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td><input id="memberPw" name="memberPw" type="password" value=""></td>
		</tr>
		<tr>
			<td>비밀번호 확인</td>
			<td><input id="memberPwCheck" name="memberPwCheck" type="password" value=""></td>
		</tr>
		<tr>
			<td>이름</td>
			<td><input id="memberName" name="memberName" type="text" value=""></td>
		</tr>
		<tr>
			<td>나이</td>
			<td><input id="memberAge" name="memberAge" type="text" value=""></td>
		</tr>
		<tr>
			<td>성별</td>
			<td><input id="memberGender" name="memberGender" type="text" value=""></td>
		</tr>
		<tr>
			<td>전화번호</td>
			<td><input id="memberPhone" name="memberPhone" type="text" value=""></td>
		</tr>
		<tr>
			<td>이메일</td>
			<td><input id="memberEmail" name="memberEmail" type="text" value=""></td>
		</tr>
		<tr>
			<td>주소</td>
			<td><input id="memberAddress" name="memberAddress" type="text" value=""></td>
		</tr>
	</table>
	<input id="memberInsert" name="memberInsert" type="submit" value="회원가입">
	</form>

</body>

<script type="text/javascript">

    $('#idOverlapCheck').click(function(){
    	$.ajax({
            type: 'POST',
            url: '/idOverlapCheck',
            data: {
                memberId : $('#memberId').val()
            },
            success: function(data){
                if($.trim(data) == 0){
                    $('#checkMsg').html('<p style="color:blue">사용가능</p>');
                }
                else{
                    $('#checkMsg').html('<p style="color:red">사용불가능</p>');
                }
            }
    });
       


</script>













</html>