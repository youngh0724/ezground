<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<!-- jQuery UI CSS파일 --> 
<link rel="stylesheet" href="http://code.jquery.com/ui/1.8.18/themes/base/jquery-ui.css" type="text/css" />  
<!-- jQuery 기본 js파일 -->
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>  
<!-- jQuery UI 라이브러리 js파일 -->
<script src="http://code.jquery.com/ui/1.8.18/jquery-ui.min.js"></script>

<h1>예약페이지 테스트</h1>
<h3>입력날짜클릭 -> 날짜선택 -> 입력된 날짜 받음</h3>

   <!-- Javascript -->
      <script>
         $(function() {
            $( "#datepicker-3" ).datepicker({
               appendText:"(yy-mm-dd)",
               dateFormat:"yy-mm-dd",
               dayNamesMin: [ "일", "월", "화", "수", "목", "금", "토" ],
               altField: "#datepicker-4",
               altFormat: "DD, d MM, yy"
            });
         });
      </script>
   </head>
   
   <body>
      <!-- HTML --> 
      <p>입력 날짜: <input type = "text" id = "datepicker-3"></p>
      <p>Alternate Date: <input type = "text" id = "datepicker-4"></p>
   </body>
</html>