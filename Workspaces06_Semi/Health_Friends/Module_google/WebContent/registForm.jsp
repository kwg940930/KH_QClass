<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); 
	response.setContentType("text/html; charset=UTF-8");%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-latest.js"></script>
<script src="https://www.google.com/recaptcha/api.js"></script>			<!--  recaptcha API -->
<script type="text/javascript">

	function onSubmit(token){
		$.ajax({
			url : "google.do?token="+token,
			dataType: "text",
			success: function(data){
				if(data == 1){
					/*if($("#id").prop("title") == "y" && $("#phone").prop("title") == "y" && $("#email").prop("title") == "y" && $("#pwchk").prop("title") == "y"){
						//$("#registform").submit();
					} else{
						alert("입력하신 정보를 다시 확인해주세요.");
					}*/
					alert("성공");
				} else{
					alert("잘못된 접근입니다.");
				}
			},
			error: function(err){
				alert(err);
			}
		});
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
					<button class="g-recaptcha" 
        					data-sitekey="6LdY0Y0aAAAAAC55f1G3fyahKgyATLdZ1BZq_yt5" 
        					data-callback='onSubmit' 
        					data-action='submit'>회원가입</button>
        			<input type="button" value="취소" onclick="">
				</td>
			</tr>
			
			
		</table>
	</form>

</body>
</html>