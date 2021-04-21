<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("UTF-8");%>
<%response.setContentType("text/html; charset=UTF-8");%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>∴fullCalendar∵</title>
<link href='fullcalendar/main.css' rel='stylesheet' />
</head>
<body>

		<p><em>달력을 클릭해주세요!</em></p>
	<!-- 달력API -->		<div id='postMdate'></div>
						    
		<input type="hidden" name="postMdate" value="" />
		<div id='calendar'></div>
		<p><em>시계아이콘을 클릭해 약속시간을 정해주세요</em></p>
		<input type="time" name="postLatitude"/>
	
<script type="text/javascript" src="/fullCalendarAPI/resources/JavaScript/fullCallendar.js"></script>
<script src='/fullCalendarAPI/resources/API/fullcalendar-5.6.0/lib/main.js'></script>
<script type="text/javascript">
	document.addEventListener('DOMContentLoaded', function() {
		var calendarEl = document.getElementById('calendar');
		var calendar = new FullCalendar.Calendar(calendarEl, {
			selectable: true,
			headerToolbar: {
				left: 'prev,next today',
				center: 'title',
				right: 'dayGridMonth,timeGridWeek,timeGridDay'
			},
			// 위에까지가 기본 달력화면
			
			// 아래가 클릭기능. postMdate라는 id를 가진 태그를 변수로 만들어 
			// info.dateStr이라는 약속일자를 담아주고 있다.
			dateClick: function(info) {
				var postMdate = document.getElementById('postMdate');
				postMdate.innerHTML = "약속일자 : " + info.dateStr;
				document.getElementsByName("postMdate")[0].value = info.dateStr;
			}
		});
		calendar.render();
	});
</script>
<link href='/fullCalendarAPI/resources/API/fullcalendar-5.6.0/lib/main.css' rel='stylesheet' />
</body>
</html>