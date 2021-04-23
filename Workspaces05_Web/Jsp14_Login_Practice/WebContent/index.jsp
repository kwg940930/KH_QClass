<%@page import="com.ncs.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% Member m = (Member) session.getAttribute("m");%>
<h2>Hello Spring!</h2>
<c:choose>
	<c:when test="${empty m}">
		<form action="LoginController.do">
		<input type="hidden" name="command" value="login"/>
			<table>
				<tr>
					<th>UserId : </th>
					<td><input type="text" name="userId"></td>
				</tr>
				<tr>
					<th>password : </th>
					<td><input type="password" name="Password"></td>
				</tr>
			</table>
			<input type="submit" value="로그인">
		</form>
	</c:when>
	<c:otherwise>
		<%=m %><br>
		<input type="button" value="로그아웃" onclick="location.href='LoginController.do?command=logout'">
	</c:otherwise>
</c:choose>
</body>
</html>