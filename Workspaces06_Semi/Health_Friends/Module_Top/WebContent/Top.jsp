<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<style>

.top{
    margin-bottom: 50px;
}

#btn {
    position: fixed; /* 버튼 위치 고정 */
    bottom: 20px;
    right: 30px;
    z-index: 99;
    font-size: 20px;
    padding: 15px;
    background-color: white;
    color: rgb(0, 183, 255);
    cursor: pointer;
    transition: 0.5s;
    border: 1px solid;
}

#btn:hover {
    background-color:rgb(0, 183, 255);
    color: white;
    border: 2px solid;
}
</style>
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<script type="text/javascript">
<%-- top에서 20px까지 내려가면 버튼이 나옴. 화면 20px 위에 있으면 버튼이 안나옴. --%>
function scrollFunction() { 
	var btn = document.getElementById('btn');
	if (document.body.scrollTop > 20 || document.documentElement.scrollTop > 20) { 
		btn.style.display = "block"; 
	} else { 
		btn.style.display = "none"; 
	} 
}

<%-- 상단 끝(top:0)까지 부드럽게(smooth)하게 올라가기 --%>
function GoTop() { 
	window.scrollTo({top:0, behavior:'smooth'}); 
}
</script>

<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%-- 상단으로 이동하기 버튼 시작 --%>
	<div class="top">
		<button id="btn" onClick="GoTop()">▲</button>
	</div>
<%-- 상단으로 이동하기 버튼 끝 --%>
	
</body>
</html>