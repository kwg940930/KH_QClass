<%@page import="com.board.dao.MyBoardDao"%>
<%@page import="com.board.dto.MyBoardDto"%>
<%@page import="java.util.List"%>
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
<title>게시글 목록</title>
<link href="resources/css/mycss.css" rel="stylesheet" type="text/css">
</head>
<body>
<a href="index.html">메인으로 가기</a>
	<h1>게시글 전체 보기</h1>

	<table border="1">
		<col width="50px">
		<col width="100px">
		<col width="300px">
		<col width="250px">
		
		<tr>
			<th>번호</th>
			<th>작성자</th>
			<th>제목</th>
			<th>작성날짜</th>
		</tr>
<%
	MyBoardDao dao = new MyBoardDao();
	List<MyBoardDto> list = dao.selectList();
	
	for(int i = 0; i < list.size(); i++){
%>
		<tr>
			<td class="list_seq"><%=list.get(i).getSeq() %></td>
			<td class="list_writer"><%=list.get(i).getWriter() %></td>
			<td><a href="myselect.jsp?seq=<%=list.get(i).getSeq()%>"><%=list.get(i).getTitle() %></a></td>
			<td class="list_date"><%=list.get(i).getRegdate() %></td>
		</tr>
<%
	}
%>
		<tr>
			<td colspan="4" align="right"><input type="button" value="글쓰기" onclick="location.href='myinsert.jsp'"></td>
		</tr>
		
		
	</table>

</body>
</html>