<%@page import="com.myboard.dao.MyBoardDao"%>
<%@page import="com.myboard.dto.MyBoardDto"%>
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
	String title = request.getParameter("title");
	String content = request.getParameter("content");

	MyBoardDto dto = new MyBoardDto();
	dto.setTitle(title);
	dto.setContent(content);
	dto.setSeq(seq);
	
	MyBoardDao dao = new MyBoardDao();
	
	int res = dao.update(dto);
	
	if(res > 0){
%>
	<script type="text/javascript">
		alert("게시글이 수정되었습니다");
		location.href="mylist.jsp";
	</script>
<%
	}else{
%>
	<script type="text/javascript">
		alert("게시글 수정에 실패하였습니다.");
		location.href="myupdate.jsp?seq='<%=dto.getSeq()%>'";
	</script>
<%
	}
%>




</body>
</html>