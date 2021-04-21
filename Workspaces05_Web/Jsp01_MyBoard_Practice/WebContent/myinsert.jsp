<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%request.setCharacterEncoding("UTF-8"); %>
<%response.setContentType("text/html; charset=UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


	<h1>게시글 작성하기</h1>

<form action="myinsert_res.jsp" method="post">
	<table border="1">
		<tr>
			<th>작성자</th>
			<td><input type="text" name="writer"></td>
		</tr>
		
		<tr>
			<th>제목</th>
			<td><input type="text" name="title"></td>
		</tr>
		
		<tr>
			<th>내용</th>
			<td><textarea cols="50" rows="10" name="content"></textarea></td>
		</tr>
		
		<tr align="right">
			<td colspan=2>
				<input type="submit" value="등록">
				<input type="button" value="취소" onclick="location.href='mylist.jsp'">

			</td>
		</tr>
	</table>
</form>

<body>

</body>
</html>