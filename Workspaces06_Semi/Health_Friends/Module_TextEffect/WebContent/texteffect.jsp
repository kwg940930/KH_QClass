<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>

.background01 {
	margin: 10px auto;
	position: relative;
}

.container01 {
	width:100%;
}

/* 택스트들이 순차적으로 나오게 하기 위해서 줄을 따로따로 설정 */
.text01 {
  margin-top: 20px;
  padding: 100px 100px;
  border-radius: 10px;
  position: absolute;
  bottom: 70%;
  left: 5%;
  font-size:50px;
  font-weight: bold;
  text-align: left;
  display: none;
}

.text02 {
  margin-top: 20px;
  padding: 100px 100px;
  border-radius: 10px;
  position: absolute;
  bottom: 64%;
  left: 5%;
  font-family: Verdana, Geneva, Arial, sans-serif;
  font-size:42px;
  text-align: left;
  display: none;
}

.text03 {
  margin-top: 20px;
  padding: 100px 100px;
  border-radius: 10px;
  position: absolute;
  bottom: 37%;
  left: 5%;
  font-family: Verdana, Geneva, Arial, sans-serif;
  font-size:28px;
  text-align: left;
  display: none;
}

/* 글자가 위로 올라오는 속도 0.7초 */
.title01, .title02, .text-danger, .text-info, .text06, .text07 {
	margin-top: 20px;
	transition: transform 0.7s, opacity 2.5s;
}

</style>

<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>

<script type="text/javascript">
	
	// fadeIn = 글자 나타나게 하기
	$(document).ready(function(){
		$('.text01').fadeIn(2000); // 2초
		$('.text02').fadeIn(5000); // 5초
		$('.text03').fadeIn(7000); // 7초 순차적으로 나오게 했다.
	});
	
	
	// 글자 위로 올라오는 기능
	function isElementUnderBottom(elem, triggerDiff) {
	  const { top } = elem.getBoundingClientRect();
	  const { innerHeight } = window;
	  return top > innerHeight + (triggerDiff || 0);
	}

	function handleScroll() { // 이벤트 함수이다. 스크롤 하면 반응하는 이벤트.
	  const elems = document.querySelectorAll('.text06, .text07'); // class="text06, text07"을 가져옴. 
	  elems.forEach(elem => {
	    if (isElementUnderBottom(elem, 20)) { // elems(elements)가 아래 있다면 글자가 안보이게 (opacity = 투명도가 0이다.)
	      elem.style.opacity = "0";
	      elem.style.transform = 'translateY(70px)';
	
	    } else {
	      elem.style.opacity = "1";
	      elem.style.transform = 'translateY(0px)'; // elems가 화면 안에 있다면 글자가 드러나면서 올라오게 만든다.(두명도 1)

	    }
	  })
	}
	window.addEventListener('scroll', handleScroll);

</script>

</head>
<body>

<!-- 개요 시작 -->
	<div class=background01>
		<div class="container01"><img src="https://image.freepik.com/free-photo/closeup-of-sport-shoes-on-concrete-path_273609-14253.jpg" style="width: 100%; height:auto;">
			<h1 class="text01">우리 동네 운동 메이트와 함께해요!</h1>
			<br>
			<h3 class="text02" style="color: #00008B">우리 동네 운동 메이트는 이래서 만들어졌습니다.</h3>
			<br> <br>
			<h4 class="text03">
				운동을 하고 싶지만 운동 메이트가 없어서 고민하시는 분을 위해,<br> <br> 운동을 하고 싶지만
				방법을 몰라 시작을 못하시는 분들을 위해,<br> <br> 운동을 하고 싶지만 끈기가 없어서 쉽게
				포기하시는 분을 위해,<br> <br>
				우리 동네 운동 메이트는 만남을 제공하고 효과적인 운동 방법을 제공합니다</h4>
		</div>
	</div>
<!-- 개요 끝 -->

<div class="text06" style="font-size: 40px; text-align:center; color: black; font-weight: bold">우리 동네 운동 메이트 조원<br><br>
	<span class="text07" style="font-size: 30px; text-align:center; color: #8B0000">조원들을 소개합니다.</span>
</div>

<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>

</body>
</html>