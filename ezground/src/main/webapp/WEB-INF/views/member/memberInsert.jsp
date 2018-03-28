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
			<td><div id="checkMsg" ></div></td>
		</tr>
		<tr>
			<td>아이디 <button id="idOverlapCheck" type="button">중복체크</button></td>			
			<td><input id="memberId" name="memberId" type="text" placeholder=""></td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td><input id="memberPw" name="memberPw" type="password" placeholder=""></td>
		</tr>
		<tr>
			<td>비밀번호 확인</td>
			<td><input id="memberPwCheck" name="memberPwCheck" type="password" placeholder=""></td>
		</tr>
		<tr>
			<td>이름</td>
			<td><input id="memberName" name="memberName" type="text" placeholder=""></td>
		</tr>
		<tr>
			<td>나이</td>
			<td><input id="memberAge" name="memberAge" type="text" placeholder=""></td>
		</tr>
		<tr>
			<td>성별</td>
			<td><input id="memberGender" name="memberGender" type="text" placeholder=""></td>
		</tr>
		<tr>
			<td>전화번호</td>
			<td><input id="memberPhone" name="memberPhone" type="text" placeholder=""></td>
		</tr>
		<tr>
			<td>이메일</td>
			<td><input id="memberEmail" name="memberEmail" type="text" placeholder=""></td>
		</tr>
		<tr>
			<td>주소</td>
			<td><input id="memberAddress" name="memberAddress" type="text" placeholder=""></td>
		</tr>
	</table>
	<input id="memberInsert" name="memberInsert" type="button" value="회원가입">
	</form>

</body>

<script type="text/javascript">

	let check = false;

    $('#idOverlapCheck').click(function(){
    	if ($('#memberId').val() == "") {
			//값이 공백이면
			alert("아이디를 입력하세요");
			$('#memberId').focus();
		} else {
			//값이 공백이 아닐시
			$.post('${pageContext.request.contextPath}/idOverlapCheck', { memberId : $('#memberId').val()}, function(data) {
				//입력받은 id값을  idCheckApi.jsp로 넘겨주고 Ajax로 받아온다 (Json파일)
				console.log(data);
				//브라우저 코솔창에 받아온 데이터를 출력한다. 
				if (data == 0) {
					//받아온 데이터의 member_no값이 0이면실행
					alert("사용가능한 아이디입니다.");
					check = true;
					//중복검사를 실행하고 사용가능한 아이디이면(테이블에 중복되는 아이디가 없으면) check변수값을 true로 바꾼다.
				} else {
					//member_no감이 0이 아니면 실행
					alert("중복된 아이디입니다.");
					$('#idOverlapCheck').val("");
					$('#idOverlapCheck').focus();
				}
			});
		}

	});
       
    
    $('#memberInsert').click(function() {
	
		if (check) {
		
			if($('#memberPw').val() == ""){
				
				alert("비밀번호를 입력하세요");
				$('#memberPw').focus();
				
			} else {
				
				if ($("#memberPw").val() != $("#memberPwCheck").val()) {
								
					alert("입력한 비밀번호와 비밀번호 확인이 일치하지 않습니다.");
				
					$("#memberPwCheck").val("");
					$("#memberPwCheck").focus();
				} else if ($("#memberPw").val() == $("#memberPwCheck").val()) {
					//입력받은 비밀번호의 값이 일치하면
					alert("회원가입 성공!");
					$('form').submit();

				}
			}

		} else {
			alert("중복검사를 실행하십시오!")
		}

	});


</script>

</html>