<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<jsp:include page="/WEB-INF/views/module/headLink.jsp" />
<jsp:include page="/WEB-INF/views/module/fullcalendar.jsp" />
<script>
$(document).ready(function() {
    $('#calendar').fullCalendar({
    	
	header: {
        left: 'prev,next today',
        center: 'title',
        right: 'month,agendaWeek,agendaDay,list'
      },
      locale: 'ko',
      lang : 'ko',
      editable: true,
      navLinks: true, // 
      eventLimit: true, // 
      events: '${pageContext.request.contextPath}/'
    });
  });
  
</script>
<style type='text/css'>

	body{
		margin-top: 40px;
		text-align: center;
		font-size: 14px;
	}
	#calendar{
		width: 900px;
		margin:0 auto;
	}
</style>
<body>
	<h2>시설 일정 스케줄</h2>
	<div id='calendar'></div>
</body>
</html>