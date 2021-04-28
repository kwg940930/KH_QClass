<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="registres.do" method="post">
		<table>
			<tr>
				<th>ID</th>
				<td><input type="text" name="memberid" /></td>
			</tr>
			<tr>
				<th>PW</th>
				<td><input type="text" name="memberpw" /></td>
			</tr>
			<tr>
				<th>name</th>
				<td><input type="text" name="membername" /></td>
			</tr>
			<tr>
				<td colspan="2" align="right">
					<input type="submit" value="가입" />
					<input type="button" value="취소" onclick="location.href='loginform.do'" />
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center" id="registChk"></td>
			</tr>
		</table>
	</form>
</body>
</html>