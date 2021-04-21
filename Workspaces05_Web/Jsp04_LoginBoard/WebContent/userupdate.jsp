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
	int myno = Integer.parseInt(request.getParameter("myno"));
	MYMemberBiz biz = new MYMemberBiz();
	MYMemberDto dto = biz.selectUser(myno);
%>
<h1>회원 정보 수정</h1>

<form action="logincontroller.jsp" method="post">
<input type="hidden" name="command" value="userupdateres">
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
			<th>비밀번호</th>
			<td><input type="password" name="mypw" value="<%=dto.getMypw() %>"></td>
		</tr>
		<tr>
			<th>이름</th>
			<td><input type="text" name="myname" value="<%=dto.getMyname() %>"></td>
		</tr>
		<tr>
			<th>주소</th>
			<td><input type="text" name="myaddr" value="<%=dto.getMyaddr() %>"></td>
		</tr>
		<tr>
			<th>전화번호</th>
			<td><input type="text" name="myphone" value="<%=dto.getMyphone() %>"></td>
		</tr>
		<tr>
			<th>이메일</th>
			<td><input type="text" name="myemail" value="<%=dto.getMyemail() %>"></td>
		</tr>
		<tr>
			<td colspan="2" align="right">
				<input type="submit" value="수정완료">
				<input type="button" value="취소" onclick="location.href='logincontroller.jsp?command=login&myid=<%=dto.getMyid()%>&mypw=<%=dto.getMypw()%>'">
			</td>
		</tr>
		
	</table>
</form>
</body>
</html>