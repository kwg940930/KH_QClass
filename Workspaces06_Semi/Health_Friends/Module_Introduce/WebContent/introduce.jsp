<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>

/* 조원 소개 css */

/* list에 점 없애기 */
li {
	list-style-type: none;
}

.wrapper {
	display: flex; <%-- .team을 화면에서 자유롭게 만들어주는 명령. --%>
	height: 50vh;
	justify-content: center;
	align-items: center;
}

.team {
	display: flex; <%-- 조원들 사진이 가로로 배치된다. --%>
	justify-content: center; <%-- 사진과 글씨가 가운데로 배치된다 --%>
	align-items: center; <%-- 사진에 마우스 커서를 올릴 시 옆으로 움직이지 않고 가운데 고정된 상태로 상하좌우로 커진다 --%>
}

.team-item {
	flex-basis: 200px; <%-- 사진크기 200px --%>
	flex-shrink: 0;
	margin: 0 10px; <%-- 사진들 간에 띄어쓰기 10px --%>
	transition: all .4s;
}

.team-item:hover {
	flex-basis: 300px; <%-- 사진에 마우스를 올리면 300px로 커진다 --%>
	margin: 0 30px;
}

.team-item img {
	width: 100%; <%-- 부모크기만큼 꽉 채운다. 여기서 부모크기는 .team-item의 flex-basis이다. 즉 200px의 100%이므로 200px이 된다. --%>
}

.profile {
	background-color: #222;
	position: relative;
	overflow: hidden; <%-- 만약 프로필의 작은 글씨들이 화면을 넘어가면 넘어가지 않게 만든다. --%>
}

.profile:before { <%-- 아래 코드들은 사진에 명암 효과(어둡게) 만드는 코드이다 --%>
	content: ' ';
	/* Permalink - use to edit and share this gradient: https://colorzilla.com/gradient-editor/#000000+0,000000+100&0+0,0.95+100 */
background: -moz-linear-gradient(top,  rgba(0,0,0,0) 0%, rgba(0,0,0,0.95) 100%); /* FF3.6-15 */
background: -webkit-linear-gradient(top,  rgba(0,0,0,0) 0%,rgba(0,0,0,0.95) 100%); /* Chrome10-25,Safari5.1-6 */
background: linear-gradient(to bottom,  rgba(0,0,0,0) 0%,rgba(0,0,0,0.95) 100%); /* W3C, IE10+, FF16+, Chrome26+, Opera12+, Safari7+ */
filter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#00000000', endColorstr='#f2000000',GradientType=0 ); /* IE6-9 */
	
	position: absolute;
	left: 0;
	right: 0;
	bottom: 0;
	height: 200px;
}

/* 조장, 조원 설명 색깔들 */
.profile_red {
	color: #ff4949;
}

.profile_beige {
	color: beige;
}

.profile_green {
	color: darkseagreen;
}

.profile_pink {
	color: pink;
}

.profile_purple {
	color: violet;
}

.profile-contents {
	position: absolute;
	left: 0;
	bottom: 0;
	padding: 0;
}

.profile-contents h2 {
	font-size: 30px;
	text-align: center;
}

.profile-contents h2 span {
	display: block;
	font-size: 20px;
}

.profile-contents p {
	color: white;
	font-size: 15px;
	min-width: 140px;
	max-height: 0; 
	overflow: hidden; <%-- 소개 중 작은 글씨들이 안보이게 숨겨준다 --%>
	line-height: 1.2;
	transition: all .4s; <%-- 작은 글씨들이 부드럽게 나오게 한다. --%>
	opacity: 0;
	transition-delay: .4s; <%-- 작은 글씨들이 0.4초 뒤에 나오게 한다. --%>
}

.team-item:hover .profile-contents p {
	opacity: 1;
	max-height: 6em;
	margin-top: 0.2em;
}

</style>


</head>
<body>

<!-- 조원 소개하기 -->
<div class="wrapper">
	<ul class="team">
		<li class="team-item">
			<div class="profile profile_red">
				<!-- 이미지 파일 -->
				<img src="https://post-phinf.pstatic.net/MjAyMTAzMDFfMTkz/MDAxNjE0NTgwNjMyNTM3.2O-VrXmnSaD-hK2loLB9uC5975b8Fo074VC2uMOw_zcg.2qrNXPHxyh_QtmTbwfSDTtx9SvxAEG8AGhY_cI1WHfYg.JPEG/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7_2021-03-01_%EC%98%A4%ED%9B%84_3.36.54.jpg?type=w1200">
				<div class="profile-contents">
					<h2>
						임기원 <span>조&emsp;장</span>
					</h2>
					<p>열심히 하겠습니다.</p>
				</div>
			</div>
		</li>
		<li class="team-item">
			<div class="profile profile_beige">
				<img
					src="https://post-phinf.pstatic.net/MjAyMTAzMDFfMTkz/MDAxNjE0NTgwNjMyNTM3.2O-VrXmnSaD-hK2loLB9uC5975b8Fo074VC2uMOw_zcg.2qrNXPHxyh_QtmTbwfSDTtx9SvxAEG8AGhY_cI1WHfYg.JPEG/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7_2021-03-01_%EC%98%A4%ED%9B%84_3.36.54.jpg?type=w1200">
				<div class="profile-contents">
					<h2>
						강원기 <span>조&emsp;원</span>
					</h2>
					<p>열심히 하겠습니다.</p>
				</div>
			</div>
		</li>
		<li class="team-item">
			<div class="profile profile_green">
				<img
					src="http://the-star.co.kr/site/data/img_dir/2020/10/30/2020103080040_0.jpg">
				<div class="profile-contents">
					<h2>
						소윤정 <span>조&emsp;원</span>
					</h2>
					<p>열심히 하겠습니다.</p>
				</div>
			</div>
		</li>
		<li class="team-item">
			<div class="profile profile_pink">
				<img
					src="http://the-star.co.kr/site/data/img_dir/2020/10/30/2020103080040_0.jpg">
				<div class="profile-contents">
					<h2>
						지&emsp;연 <span>조&emsp;원</span>
					</h2>
					<p>열심히 하겠습니다.</p>
				</div>
			</div>
		</li>
		<li class="team-item">
			<div class="profile profile_purple">
				<img
					src="https://post-phinf.pstatic.net/MjAyMTAzMDFfMTkz/MDAxNjE0NTgwNjMyNTM3.2O-VrXmnSaD-hK2loLB9uC5975b8Fo074VC2uMOw_zcg.2qrNXPHxyh_QtmTbwfSDTtx9SvxAEG8AGhY_cI1WHfYg.JPEG/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7_2021-03-01_%EC%98%A4%ED%9B%84_3.36.54.jpg?type=w1200">
				<div class="profile-contents">
					<h2>
						손승현 <span>조&emsp;원</span>
					</h2>
					<p>열심히 하겠습니다.</p>
				</div>
			</div>
		</li>
	</ul>
</div>
<!-- 조원 소개하기 끝 -->

</body>
</html>