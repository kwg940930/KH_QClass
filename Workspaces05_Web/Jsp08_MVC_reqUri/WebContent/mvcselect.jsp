<%@page import="com.mvc.dto.MVCBoardDto"%>
<%@page import="com.mvc.biz.MVCBoardBizImpl"%>
<%@page import="com.mvc.biz.MVCBoardBiz"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("UTF-8"); %>
<%response.setContentType("text/html; charset=UTF-8"); %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<script type="text/javascript">
	function deleteProc(seq){
		if(confirm(seq+"번 글을 삭제하시겠습니까?")){
			location.href="deleteProc?seq="+seq;
		}
	}
</script>

<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>

	<h1>SELECT</h1>

	<table border="1">
		<tr>
			<th>작성자</th>
			<td>${dto.writer }</td>
		</tr>
		<tr>
			<th>제목</th>
			<td>${dto.title }</td>
		</tr>
		<tr>
			<th>내용</th>
			<td><textarea cols="50px" rows="30px" readonly="readonly">${dto.content }</textarea></td>
		</tr>
		<tr>
			<td colspan="2" align="right">
				<input type="button" value="수정" onclick="location.href='updateForm?seq=${dto.seq}'">
				<input type="button" value="삭제" onclick="deleteProc(${dto.seq});">
				<input type="button" value="목록" onclick="location.href='selectList'">
			</td>
		</tr>
	</table>

</body>
</html>