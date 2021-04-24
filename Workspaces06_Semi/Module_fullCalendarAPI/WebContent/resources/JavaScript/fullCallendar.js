document.addEventListener('DOMContentLoaded', function() {
	document.addEventListener('DOMContentLoaded', function() {
			var selectDate = document.getElementByName('selectDate');
			var calendarEl = document.getElementById('calendar');
			var calendar = new FullCalendar.Calendar(calendarEl, {
				events: [
		               {
		                   title: '약속일',
		                   start: '2021-04-03'
		               }
		            ]
			});	
		    calendar.render();
		});	
});
