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
<title>게시글 작성</title>
<link href="resources/css/mycss.css" rel="stylesheet" type="text/css">
</head>
<body>
<%
	String writer = request.getParameter("writer");
	String title = request.getParameter("title");
	String content = request.getParameter("content");
	
	MyBoardDto dto = new MyBoardDto();
	dto.setWriter(writer);
	dto.setTitle(title);
	dto.setContent(content);
	
	MyBoardDao dao = new MyBoardDao();
	
	int res = dao.insert(dto);
	
	if(res > 0){
%>

<script type="text/javascript">
	alert("게시글이 작성되었습니다");
	location.href="mylist.jsp";
</script>
<%
	} else {
%>
<script type="text/javascript">
	alert("게시글 작성이 실패하였습니다! 다시 작성해주세요~!~!~!~!")
	location.href="myinsert.jsp";
</script>
<%
	}
%>
</body>
</html>