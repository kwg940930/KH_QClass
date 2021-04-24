<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); 
	response.setContentType("text/html; charset=UTF-8");%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script type="text/javascript" src="https://code.jquery.com/jquery-latest.js"></script>
<script type="text/javascript">

	function addrCheck(){
		
		new daum.Postcode({
	        oncomplete: function(data) {
	        	// 팝업에서 검색결과 항목을 클릭했을때 실행할 코드
	        	
	            var roadAddr = data.roadAddress; // 도로명 주소 변수 //지번 주소 변수: jibunAddress
	            var extraRoadAddr = ''; // 참고 항목 변수
	
	            // 법정동명이 있을 경우 추가한다. (법정리는 제외)
	            // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
	            if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
	                extraRoadAddr += data.bname;
	            }
	            // 건물명이 있고, 공동주택일 경우 추가한다. data.apartment: 공통주택 여부
	            if(data.buildingName !== '' && data.apartment === 'Y'){
	               extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
	            }
	            // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
	            if(extraRoadAddr !== ''){
	                extraRoadAddr = ' (' + extraRoadAddr + ')';
	                
	                roadAddr += extraRoadAddr;
	            }
	            
	            // 우편번호와 주소 정보를 해당 필드에 넣는다.
	            $("#addr").val(roadAddr);
	        }
	
	    }).open();
	}

</script>

</head>
<body>

	<h1>우리동네 운동친구</h1>
	<h2>회원가입</h2>

	<form action="../regist.do" method="post" id="registform">
	<input type="hidden" name="command" value="registres">
		<table>
			<tr>
				<td colspan="2">
					<label for="id">아이디</label><br>
					<input type="text" id="id" name="memberId" title="n" placeholder="아이디입력" required="required">
				</td>
			</tr>
			<tr>
				<td id="idchk" style="font-size:10px; text-align: start"></td>
			</tr>
			<tr>
				<td colspan="2">
					<label for="pw">비밀번호</label><br>
					<input type="password" id="pw" name="memberPw" placeholder="비밀번호" required="required" >
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="password" id="pwchk" name="memberPwChk" title="n" placeholder="비밀번호 확인" required="required">
				</td>
			</tr>
			<tr>
				<td id="same" style="font-size:10px; text-align: start"></td>
			</tr>
			<tr>
				<td>
					<input type="text" id="addr" name="memberAddr" placeholder="주소를 입력해주세요" readonly="readonly" required="required" onclick="addrCheck()">
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="text" id="name" name="memberName" placeholder="이름" required="required">
				</td>
			</tr>
			<tr>
				<td>
					<label for="phone">전화번호</label><br>
					<input type="tel" id="phone" name="memberPhone" title="n" placeholder="전화번호" required="required">
				</td>
			</tr>
			<tr>
				<td id="phonechk" style="font-size:10px; text-align: start"></td>
			</tr>
			<tr>
				<td colspan="2">
					<label for="email">이메일</label><br>
					<input type="text" id="email" name="memberEmail" title="n" placeholder="이메일" required="required" ></td>
			</tr>
			<tr>
				<td id="emailchk" style="font-size:10px; text-align: start"></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="가입">
        			<input type="button" value="취소" onclick="">
				</td>
			</tr>
			
			
		</table>
	</form>

</body>
</html>