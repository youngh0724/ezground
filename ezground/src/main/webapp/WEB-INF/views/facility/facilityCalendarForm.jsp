<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

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
	  dayClick : function(date, jsEvent, view){
		  console.log("년도 : "+date.format("YYYY"));
		  console.log("월 : "+date.format("MM"));
		  console.log("일 : "+date.format("DD"));
		  $('#CalendarModal123').modal('show');
	  }   
    });
  });
  
  
</script>
<style type='text/css'>

	body{
		margin-top: 40px;
		text-align: center;
		font-size: 14px;
	}
	  #calendar {
        max-width: 900px;
        margin: 0 auto;
    }

</style>
<body>
	<h2>시설 일정 스케줄</h2>
	<div id='calendar'></div>
	
		<!-- Modal -->
	<div id="CalendarModal123" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" >
		<div class="head">
			<span>일정 기능</span>
			<div>
				<table>
					<tr>
						<td><input class="input input-rect" id="title" name="title" style="width: 612px" maxlength="100" placeholder="제목"/></td>
					</tr>
				</table>	
				<div>
					<a href="#" id="writeBtn" class="btn btn-gray btn-small">일정 보기</a>
					<a href="#" id="writeClose" class="btn btn-gray btn-small">일정 등록</a>
				</div>
			</div>
		</div>
	</div>
	<!-- /modal -->
	
</body>
</html>