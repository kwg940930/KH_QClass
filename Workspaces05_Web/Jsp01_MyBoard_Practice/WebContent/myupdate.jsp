<%@page import="com.myboard.dto.MyBoardDto"%>
<%@page import="com.myboard.dao.MyBoardDao"%>
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

<% 
	int seq = Integer.parseInt(request.getParameter("seq"));
	MyBoardDao dao = new MyBoardDao();
	MyBoardDto dto = dao.selectOne(seq);
%>

	<h1>게시글 작성하기</h1>

<form action="myupdate_res.jsp?seq=<%=dto.getSeq() %>" method="post">
	<table border="1">
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
			<td><textarea cols="50" rows="10" name="content"><%=dto.getContent() %></textarea></td>
		</tr>
		
		<tr align="right">
			<td colspan=2>
				<input type="submit" value="등록">
				<input type="button" value="취소" onclick="location.href='myselect.jsp?seq=<%=dto.getSeq() %>'">
			</td>
		</tr>
	</table>
</form>

<body>

</body>
</html>