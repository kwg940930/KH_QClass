<%@page import="com.mdboard.dto.MDBoardDto"%>
<%@page import="com.mdboard.biz.MDBoardBizImpl"%>
<%@page import="com.mdboard.biz.MDBoardBiz"%>
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
	MDBoardBiz biz = new MDBoardBizImpl();
	MDBoardDto dto = biz.selectOne(seq);
%>

<form action="boardupdate_res.jsp" method="post">
<input type="hidden" value="<%=dto.getSeq() %>" name="seq">
	<table border="1">
		<tr>
			<th>작성자</th>
			<td><%=dto.getWriter()%></td>
		</tr>
		<tr>
			<th>제목</th>
			<td><input type="text" name="title" value="<%=dto.getTitle() %>"></td>
		</tr>
		<tr>
			<th>내용</th>
			<td><textarea cols="50px" rows="30px" name="content"><%=dto.getContent() %></textarea></td>
		</tr>
		<tr>
			<td align="right" colspan="2">
				<input type="submit" value="수정">
				<input type="button" value="취소" onclick="loaction.href='boardlist.jsp'">
			</td>
		</tr>
	</table>
</form>
</body>
</html>