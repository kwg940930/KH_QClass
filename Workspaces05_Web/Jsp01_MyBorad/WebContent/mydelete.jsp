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
<title>게시글 삭제</title>
<link href="resources/css/mycss.css" rel="stylesheet" type="text/css">
</head>
<body>
<%
	int seq = Integer.parseInt(request.getParameter("seq"));
	
	MyBoardDto dto = new MyBoardDto();
	dto.setSeq(seq);
	
	MyBoardDao dao = new MyBoardDao();
	int res = dao.delete(dto);
	
	if(res > 0){
%>

<script type="text/javascript">
	alert("게시글이 삭제되었습니다");
	location.href="mylist.jsp";
</script>
<%
	} else {
%>
<script type="text/javascript">
	alert("게시글이 삭제되지 않았습니다!")
	location.href="myselect.jsp?seq=<%=dto.getSeq()%>";
</script>
<%
	}
%>




</body>
</html>