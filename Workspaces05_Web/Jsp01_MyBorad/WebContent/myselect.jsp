<%@page import="com.board.dto.MyBoardDto"%>
<%@page import="com.board.dao.MyBoardDao"%>
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
<title>게시글 보기</title>
<link href="resources/css/mycss.css" rel="stylesheet" type="text/css">
<%
	int seq = Integer.parseInt(request.getParameter("seq"));
	MyBoardDao dao = new MyBoardDao();
	MyBoardDto dto = dao.selectOne(seq);
%>
<script type="text/javascript">
function realDelete(){
	if (confirm("정말로 삭제 하시겠습니까?")) {
		location.href='mydelete.jsp?seq=<%=dto.getSeq()%>';
	}
}
</script>
</head>
<body>
<a href="index.html">메인으로 가기</a>
	<h1>게시글 자세히 보기</h1>

	<table border="1">
	<tr>
		<th>작성자</th>
		<td><%=dto.getWriter() %></td>
	</tr>
	<tr>
		<th>제목</th>
		<td><%=dto.getTitle() %></td>
	</tr>
	<tr>
		<th>내용</th>
		<td><textarea rows="20px" cols="100px" readonly="readonly"><%=dto.getContent() %></textarea></td>
	</tr>
	<tr align="right">
		<td colspan="2">
			<input type="button" value="수정" onclick="location.href='myupdate.jsp?seq=<%=dto.getSeq() %>'">
			<input type="button" value="삭제" onclick="realDelete();">
			<input type="button" value="목록" onclick="location.href='mylist.jsp'">
		</td>
	</tr>
	
	</table>



</body>
</html>