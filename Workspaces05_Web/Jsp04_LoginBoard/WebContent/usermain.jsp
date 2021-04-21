<%
	response.setHeader("Cache-control", "no-store");
%>

<%@page import="com.login.dto.MYMemberDto"%>
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
<%
	MYMemberDto dto = (MYMemberDto) session.getAttribute("dto");

	if(dto == null){
		pageContext.forward("index.html");
	}
%>
<body>

	<div>
		<h2><%=dto.getMyid() %>님 환영합니다.</h2>
		<a href="logincontroller.jsp?command=logout">logout</a>
	</div>
	
	<div>
		<div>
			<a href="logincontroller.jsp?command=selectuser&myno=<%=dto.getMyno()%>">내 정보 보기</a>
		</div>
		<div>
			<a href="logincontroller.jsp?command=deleteuser&myno=<%=dto.getMyno()%>">회원 탈퇴</a>
		</div>
	</div>

</body>
</html>