<%@page import="com.login.dto.MYMemberDto"%>
<%@page import="com.login.biz.MYMemberBiz"%>
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
	MYMemberDto dto = (MYMemberDto) request.getAttribute("selectuser");
%>
<form action="logincontroller.jsp" method="post">
<input type="hidden" name="command" value="userupdate">
<input type="hidden" name="myno" value="<%=dto.getMyno()%>">
	<table border="1">
		<col width="100">
		<col width="100">
		<col width="300">
		<tr>
			<th>아이디</th>
			<td><%=dto.getMyid() %></td>
		</tr>
		<tr>
			<th>이름</th>
			<td><%=dto.getMyname() %></td>
		</tr>
		<tr>
			<th>주소</th>
			<td><%=dto.getMyaddr() %></td>
		</tr>
		<tr>
			<th>전화번호</th>
			<td><%=dto.getMyphone() %></td>
		</tr>
		<tr>
			<th>이메일</th>
			<td><%=dto.getMyemail() %></td>
		</tr>
		<tr>
			<th>회원등급</th>
			<td><%=dto.getMyrole() %></td>
		</tr>
		<tr>
			<td colspan="2" align="right">
				<input type="submit" value="내 정보 수정">
			</td>
		</tr>
		
	</table>
</form>
</body>
</html>