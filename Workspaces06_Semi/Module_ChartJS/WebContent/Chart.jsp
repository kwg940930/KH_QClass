<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("UTF-8");%>
<%response.setContentType("text/html; charset=UTF-8");%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<script	src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.4.0/Chart.min.js"></script>
<script type="text/javascript">
	$(function(){
			
		var ctx = document.getElementById("myChart").getContext('2d');
		
		/*
		- Chart를 생성하면서, 
		- ctx를 첫번째 argument로 넘겨주고, 
		- 두번째 argument로 그림을 그릴때 필요한 요소들을 모두 넘겨줌
		*/
		var myChart = new Chart(ctx, {
			// line뿐만 아니라 bar 등의 형태로도 차트를 나타낼수 있음
		    type: 'line',
		    data: {
		    	// X축값
		        labels: ['월', '화', '수', '목', '금', '토', '일'],
		        // Y축값
		        datasets: [{
		            label: '운동시간(분)',
		            data: [50, 40, 20, 35, 25, 40, 20],
		            backgroundColor: [
		                'rgba(92, 209, 229, 0.2)' // 차트의 배경색을 지정하지만 bar형태의 경우 
		            ],
		            borderColor: [
		                'rgba(61, 183, 204, 1)'
		            ],
		            borderWidth: 1
		        }]
		    },
		    options: {
		    	// ture일 경우 요소의 비율을 유지한채 그림이 그려짐
		    	// false일 경우 포함된 div의 크기에 맞춰서 그려짐.
		        maintainAspectRatio: true, 
		        scales: {
		            yAxes: [{
		                ticks: {
		                	// false일 경우 시작 포인트가 0이 아니라 최소?
		                    beginAtZero:true
		                }
		            }]
		        }
		    }
		});
	});
</script>
<body>

<%-- chart.js로 그림을 그릴때, 그려지는 요소는 모두 canvas라는 요소 안에 들어가 있게 됨
 div등의 태그에서는 차트를 그릴수 없음. --%>
<div style="width:800px">
    <canvas id="myChart"></canvas>
</div>

</body>
</html>