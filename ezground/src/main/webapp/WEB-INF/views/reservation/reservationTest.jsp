<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<!-- jQuery UI CSS���� --> 
<link rel="stylesheet" href="http://code.jquery.com/ui/1.8.18/themes/base/jquery-ui.css" type="text/css" />  
<!-- jQuery �⺻ js���� -->
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>  
<!-- jQuery UI ���̺귯�� js���� -->
<script src="http://code.jquery.com/ui/1.8.18/jquery-ui.min.js"></script>

<h1>���������� �׽�Ʈ</h1>
<h3>�Է³�¥Ŭ�� -> ��¥���� -> �Էµ� ��¥ ����</h3>

   <!-- Javascript -->
      <script>
         $(function() {
            $( "#datepicker-3" ).datepicker({
               appendText:"(yy-mm-dd)",
               dateFormat:"yy-mm-dd",
               altField: "#datepicker-4",
               altFormat: "DD, d MM, yy"
            });
         });
      </script>
   </head>
   
   <body>
      <!-- HTML --> 
      <p>�Է� ��¥: <input type = "text" id = "datepicker-3"></p>
      <p>Alternate Date: <input type = "text" id = "datepicker-4"></p>
   </body>
</html>