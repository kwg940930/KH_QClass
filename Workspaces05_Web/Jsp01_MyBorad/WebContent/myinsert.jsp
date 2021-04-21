<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 작성</title>
<link href="resources/css/mycss.css" rel="stylesheet" type="text/css">
</head>
<body>
<a href="index.html">메인으로 가기</a>


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
				<td><textarea  rows="20px" cols="100px" name="content"></textarea></td>
			</tr>
			<tr align="right">
				<td colspan="2">
					<input type="submit" value="작성">
					<input type="button" value="취소" onclick="location.href='mylist.jsp'">
				</td>
			</tr>
			
			</table>
		</form>
</body>
</html>