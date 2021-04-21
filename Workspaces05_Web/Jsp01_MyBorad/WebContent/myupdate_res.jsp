<%@page import="java.util.Date"%>
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
<%
	int seq = Integer.parseInt(request.getParameter("seq"));
	String title = request.getParameter("title");
	String content = request.getParameter("content");
	
	MyBoardDto dto = new MyBoardDto();
	dto.setSeq(seq);
	dto.setTitle(title);
	dto.setContent(content);
	
	MyBoardDao dao = new MyBoardDao();
	
	int res = dao.update(dto);
	
	if(res > 0){
%>
	<script type="text/javascript">
		alert("게시글이 수정되었습니다");
		location.href="myselect.jsp?seq=<%=dto.getSeq()%>";
	</script>
<%
	} else {
%>
	<script type="text/javascript">
		alert("게시글 수정이 실패하였습니다!")
		location.href="myinsert.jsp?seq=<%=dto.getSeq()%>";
	</script>
<%
	}
%>
</body>
</html>