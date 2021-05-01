<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
	$(function(){
		$("#loginChk").hide();
	});
	
	function login(){
		var memberid = $("#memberid").val().trim();
		var memberpw = $("#memberpw").val().trim();
		var loginVal = {
				"memberid" : memberid,
				"memberpw" : memberpw
		}
		
		if(memberid == null || memberid == "" || memberpw == null || memberpw ==""){
			alert("ID 및 PW를 다시 확인해 주세요!!");
		} else {
			$.ajax({
				type:"post",
				url:"ajaxlogin.do",
				data:JSON.stringify(loginVal),
				contentType:"application/json",		//작성 안하면 415 error 발생! 415 에러는 Unsupported Media Type... 넘어오는 객체가 뭔가 이상할때 잘못됐을때
				dataType:"json",
				success:function(msg){
					if(msg.check == true){
						location.href="list.do";
					} else {
						$("#loginChk").show();
						$("#loginChk").html("ID 혹은 PW가 잘못되었습니다.");
					}
				},
				error:function(){
					alert("통신 실패");
				}
			});
		}
	}
</script>
</head>
<body>

	<table>
		<tr>
			<th>ID</th>
			<td><input type="text" id="memberid" /></td>
		</tr>
		<tr>
			<th>PW</th>
			<td><input type="password" id="memberpw" /></td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="button" value="login" onclick="login();" />
				<input type="button" value="regist" onclick="location.href='registform.do'" />
			</td>
		</tr>
		<tr>
			<td colspan="2" align="center" id="loginChk"></td>
		</tr>
	</table>

</body>
</html>