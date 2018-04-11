<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 위 3개의 메타 태그는 *반드시* head 태그의 처음에 와야합니다; 어떤 다른 콘텐츠들은 반드시 이 태그들 *다음에* 와야 합니다 -->
<!-- 부트스트랩 -->
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

<!-- 부가적인 테마 -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">

<link
	href='https://fullcalendar.io/releases/fullcalendar/3.9.0/fullcalendar.min.css'
	rel='stylesheet' />
<link
	href='https://fullcalendar.io/releases/fullcalendar/3.9.0/fullcalendar.print.css'
	rel='stylesheet' media='print' />

<!-- IE8 에서 HTML5 요소와 미디어 쿼리를 위한 HTML5 shim 와 Respond.js -->
<!-- WARNING: Respond.js 는 당신이 file:// 을 통해 페이지를 볼 때는 동작하지 않습니다. -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
<!-- jQuery (부트스트랩의 자바스크립트 플러그인을 위해 필요합니다) -->
<script
	src='https://fullcalendar.io/releases/fullcalendar/3.9.0/lib/moment.min.js'></script>
<script
	src='https://fullcalendar.io/releases/fullcalendar/3.9.0/lib/jquery.min.js'></script>
<script
	src='https://fullcalendar.io/releases/fullcalendar/3.9.0/fullcalendar.min.js'></script>
<!-- 모든 컴파일된 플러그인을 포함합니다 (아래), 원하지 않는다면 필요한 각각의 파일을 포함하세요 -->
<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
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
	      navLinks: false, //
	      eventLimit: true, // 
	      dayClick: function(date, jsEvent, view) {
	    	  $('#myModal').modal();
	    	 var yy=date.format("YYYY");
	    	 var mm=date.format("MM");
	    	 var dd=date.format("DD");
	    	 var date=yy+'.'+mm+'.'+dd;
	    	  console.log(yy);
	    	  console.log(mm);
	    	  console.log(dd);
	    	  console.log(date);
	    	  $('#car-date').text(date);
	    	    // change the day's background color just for fun
	    	    $(this).css('background-color', 'red');
	    	  } 
	    });
	  });
	  
</script>
<style type='text/css'>
body {
	margin-top: 40px;
	text-align: center;
	font-size: 14px;
}

#calendar {
	max-width: 900px;
	margin: 0 auto;
}
</style>
</head>
<body>
	<!-- Modal -->
	<form action="${pageContext.request.contextPath}/facility/FieldCalendarInsertForm" method="get">
		<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title" id="myModalLabel">일정 관리</h4>
					</div>
					<div class="modal-body">
						<div id="car-date"></div>
					</div>
					<div class="modal-footer">
						<button type="submit" class="btn btn-default">일정 등록</button>
						<button type="button" class="btn btn-primary" data-dismiss="modal">Close</button>
					</div>
				</div>
			</div>
		</div>
	</form>
	<div id='calendar'></div>
</body>
</html>


