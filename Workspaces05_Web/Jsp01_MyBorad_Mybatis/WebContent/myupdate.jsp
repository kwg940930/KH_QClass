<%@page import="com.board.dao.MyBoardDao"%>
<%@page import="com.board.dto.MyBoardDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
    	request.setCharacterEncoding("UTF-8");
    %>
<%
	response.setContentType("text/html; charset=UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 수정</title>
<link href="resources/css/mycss.css" rel="stylesheet" type="text/css">
</head>
<body>
<a href="index.html">메인으로 가기</a>
<%
	int seq = Integer.parseInt(request.getParameter("seq"));
	MyBoardDao dao = new MyBoardDao();
	MyBoardDto dto = dao.selectOne(seq);
%>

	<h1 align="center">게시글 수정하기</h1>
	<form action="myupdate_res.jsp" method="post">
	<input type="hidden" name="seq" value="<%=dto.getSeq()%>">
	
		<table border="1" align="center">
		<tr>
			<th>작성자</th>
			<td><%=dto.getWriter() %></td>
		</tr>
		<tr>
			<th>제목</th>
			<td><input type="text" name="title" value="<%=dto.getTitle() %>"></td>
		</tr>
		<tr>
			<th>내용</th>
			<td><textarea  rows="20px" cols="100px" name="content"><%=dto.getContent() %></textarea></td>
		</tr>
		<tr align="right">
			<td colspan="2">
				<input type="submit" value="수정하기">
				<input type="button" value="취소" onclick="location.href='myselect.jsp?seq=<%=dto.getSeq() %>'">
			</td>
		</tr>
		
		</table>
	</form>
</body>
</html>