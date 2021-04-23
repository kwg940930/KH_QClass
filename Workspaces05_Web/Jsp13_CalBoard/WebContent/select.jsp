<%@page import="com.cal.common.Util"%>
<%@page import="com.cal.dto.CalDto"%>
<%@page import="com.cal.dao.CalDao"%>
<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	int seq = Integer.parseInt(request.getParameter("seq"));
	CalDao dao = new CalDao();
	CalDto dto = dao.selectOneCalBoard(seq);
%>
	<jsp:useBean id="util" class="com.cal.common.Util"></jsp:useBean>
	
	<h1>일정 자세히 보기</h1>
	
		
		<table border="1">
			<tr>
				<th>ID</th>
				<td>kh</td>
			</tr>
			<tr>
				<th>일정</th>
				<td>
					<jsp:setProperty property="todates" name="util" value="${dto.mdate }" />
					<jsp:getProperty property="todates" name="util" />
				</td>
			</tr>
			<tr>
				<th>제목</th>
				<td>${dto.title }</td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea rows="10" cols="60" name="content" readonly="readonly" >${dto.content }</textarea></td>
			</tr>
			<tr>
				<td colspan="2" align="right">
					<input type="button" value="수정" onclick="location.href='cal.do?command=update&seq=${dto.seq }'">
					<input type="button" value="삭제" onclick="location.href='cal.do?command=delete&seq=${dto.seq }'">
					<input type="button" value="목록" onclick="location.href='cal.do?command=calendar'">
				</td>
			</tr>
		</table>

</body>
</html>