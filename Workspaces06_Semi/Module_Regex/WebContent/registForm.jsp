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
	
	function pwReg(){
		var pw = $("#pw").val();
		var reg = /^.*(?=^.{8,16}$)(?=.*\d)(?=.*[a-zA-Z])(?=.*[!@#$%^*&+\(\)=-]).*$/;
		//^ : 문자열의 시작, \d : 숫자 문자[0-9], {n,m}: n<=m를 만족, .:개행문자 제외 모든 단일문자와 대응
		if(!reg.test(pw)){
			$("#pw").prop("title", "n");
			$("#reg").text("8~16자의 영문자,숫자,특수문자의 조합으로 입력해주세요").css("color", "red");
			$("#pw").css("background-color", "red");
		} else{
			$("#pw").prop("title", "y");
			$("#reg").text("").css("color","blue");
			$("#pw").css("background-color", "skyblue");
		}
	}
	
	function emailReg(){
		var email = $("#email").val();
		//var reg = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,}$/i;
		var reg = /[a-zA-Z0-9._+-]+@[a-zA-Z0-9-]+\.[a-zA-Z0-9.]+/i;
		if(!reg.test(email)){
			$("#email").prop("title", "n");
			$("#emailchk").text("올바른 형식의 이메일을 입력해주세요.").css("color", "red");
			$("#email").css("background-color", "red");
		} else {
			$("#email").prop("title", "y");
			$("#emailchk").text("").css("color", "blue");
			$("#email").css("background-color", "skyblue");
		}
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
					<input type="password" id="pw" name="memberPw" placeholder="비밀번호" required="required" onkeyup="pwReg()">
				</td>
			</tr>
			<tr>
				<td id="reg" style="font-size:10px; text-align: start"></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="password" id="pwchk" name="memberPwChk" title="n" placeholder="비밀번호 확인" required="required">
				</td>
			</tr>
			<tr>
				<td style="font-size:10px; text-align: start"></td>
			</tr>
			<tr>
				<td>
					<input type="text" id="addr" name="memberAddr" placeholder="주소를 입력해주세요" readonly="readonly" required="required">
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
					<input type="text" id="email" name="memberEmail" title="n" placeholder="이메일" required="required" onkeyup="emailReg()"></td>
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