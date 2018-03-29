<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<jsp:include page="/WEB-INF/views/module/fullcalendar.jsp" />
<script>

  $(document).ready(function() {

    $('#calendar').fullCalendar({
    	
	header: {
        left: 'prev,next today',
        center: 'title',
        right: ''
      },
      locale: 'ko',
      editable: true,
      navLinks: false, // can click day/week names to navigate views
      eventLimit: true, // allow "more" link when too many events
      events: function() {
          $.ajax({
              url: '${pageContext.request.contextPath}/matchNoticeExpectedDay',
              type: 'POST',                    
              success: function(data) {
                  var events = [];
                  if(data != 'empty'){
                      $.each(data, function(key, val) {
                        //alert(val.start);
                          events.push({
                              id: val.matchNoticeNo,
                              title: val.matchKinds,
                              start: val.matchExpectedDay,
                              end: val.matchExpectedDay
                          });
                      });
                  }
                  //callback(events);
              },
              error:function(request, textStatus, errorThrown){
                alert('error: ' + textStatus);
              }
          });
		}

    });

  });

</script>

<style>

  body {
    margin: 0;
    padding: 0;
    font-family: "Lucida Grande",Helvetica,Arial,Verdana,sans-serif;
    font-size: 14px;
  }

  #script-warning {
    display: none;
    background: #eee;
    border-bottom: 1px solid #ddd;
    padding: 0 10px;
    line-height: 40px;
    text-align: center;
    font-weight: bold;
    font-size: 12px;
    color: red;
  }

  #loading {
    display: none;
    position: absolute;
    top: 10px;
    right: 10px;
  }

  #calendar {
    max-width: 600px;
    margin: 40px auto;
    padding: 0 10px;
  }

</style>
<body>

<h2>매치 검색 페이지</h2>
	
	<div id='loading'>loading...</div>

	<div id='calendar'></div>
	
	

	<table border="1">
		<thead>
			<tr>
				<th>매치 종류</th>
				<th>매치 팀당 최소 인원수</th>
				<th>매치 상태</th>
				<th>매치 지역</th>
				<th>매치 예정일</th>
				<th>매치 예정시간대</th>
				<th>매치 상세 정보</th>
			</tr>	
		</thead>
		<tbody>
			<c:forEach var="matchNoticeInfo" items="${matchNoticeList}">
				<tr>
					<td>${matchNoticeInfo.matchKinds }</td>
					<td>${matchNoticeInfo.matchMemberCount }</td>
					<td>${matchNoticeInfo.matchNoticeStatus }</td>
					<td>${matchNoticeInfo.matchNoticeRegion }</td>
					<td>${matchNoticeInfo.matchExpectedDay }</td>
					<td>${matchNoticeInfo.matchExpectedStartTime}~${matchNoticeInfo.matchExpectedEndTime}</td>
					<td><a href ="${pageContext.request.contextPath}/match/matchNoticeInfomation?matchNoticeNo=${matchNoticeInfo.matchNoticeNo}" >상세보기</a></td>
				</tr>	
			</c:forEach>					
		</tbody>
	</table>




</body>
</html>