<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width" , initial-scale="1">

<title>Insert title here</title>

<style>

/* 사진 슬라이드 css */
.controls { text-align: center; padding: 50px 0 0;}
.controls button { background: #fff; border:1px solid grey; cursor:pointer; }
.slider {text-align:center;}
.bx-wrapper { position:relative;}
.bx-controls-direction { font-size:100px; }
.bx-controls-direction a {
	position:absolute; top: 50%; display:block; width:100px; height:110px; 
	overflow: hidden; transform: translateY(-50%); color:#5a5a5a; font-weight:normal;}
.bx-controls-direction .bx-prev { left:0; }
.bx-controls-direction .bx-next { right:0; }
.bx-controls-direction .bx-prev:before { content:"\e93d"; font-family:'xeicon';} /* \e93d는 왼쪽 화살표 아이콘 */
.bx-controls-direction .bx-next:before { content:"\e940"; font-family:'xeicon';} /* \e940는 오른쪽 화살표 아이콘 */
.bx-pager { position:absolute; left:0; bottom:-92px; width:100%; text-align:center;}
.bx-pager div { display:inline-block; padding:0 5px; }
.bx-pager div a { display:block; width:24px; height:3px; background-color:#999; font-size:0;
color:transparent; }
.bx-pager div a.active { background:#000; }
</style>

<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>

<!-- 슬라이드 라이브러리 -->
<link rel="stylesheet" href="http://cdn.jsdelivr.net/npm/xeicon@2.3.3/xeicon.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">

<script type="text/javascript">

// 슬라이드 기능
$(document).ready(function(){
	
    var slide = $('.slider').bxSlider({
    auto: true, // 자동으로 화면 돌아가기 설정
    pause: 2000 // 2초마다 화면이 돌아감.
	});
	
    // 재생 버튼을 클릭했을 시 화면이 자동으로 돌아감. startAuto(); 명령어 사용
	$('.controls .play').on('click', function() {
		slide.startAuto();
	})
	// 정지 버튼을 클릭햇을 시 화면이 정지됨. stopAuto(); 명령어 사용
	$('.controls .pause').on('click', function() {
		slide.stopAuto();
	})

});

</script>

</head>
<body>

	<div class="slider">
	<%-- 사진 불러오기 / 사진 크기 설정 --%>
		<div><img src="images/main/slide05.svg" alt="슬라이드 사진" style="width:1000px; height:500px"></div>
		<div><img src="images/main/slide01.svg" alt="슬라이드 사진" style="width:1000px; height:500px" ></div>
		<div><img src="images/main/slide02.svg" alt="슬라이드 사진" style="width:1000px; height:500px"></div>
		<div><img src="images/main/slide03.svg" alt="슬라이드 사진" style="width:1000px; height:500px"></div>
		<div><img src="images/main/slide04.svg" alt="슬라이드 사진" style="width:1000px; height:500px"></div>	
	</div>
	<%-- 재생버튼, 정지버튼 만들기 --%>
	<div class="controls">
		<button class="play">재생</button>
		<button class="pause">정지</button>
	</div>

<%-- 슬라이드 라이브러리 bxslider를 사용. --%>	
<script src="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.min.js"></script>

</body>
</html>