<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<title>Insert title here</title>
</head>
<body>

	<h1>JSTL : Jsp Standard Tag Library</h1>

	<table border="1">

		<tr>
			<th>이름</th>
			<th>국어</th>
			<th>영어</th>
			<th>수학</th>
			<th>총점</th>
			<th>평균</th>
			<th>등급</th>
		</tr>



		<c:forEach items="${list }" var="score">
			<tr>
				<td>
					<!-- eq : == ne : != / empty : null --> 
					<c:if test="${score.name eq '이름10' }">
						<c:out value="홍길동"></c:out>
					</c:if> <!-- when이나 otherwise쓰려면 choose가 반드시 있어야함 --> <c:choose>
						<c:when test="${score.name eq '이름20' }">
							<c:out value="${score.name }님!"></c:out>
						</c:when>
						<c:when test="${score.name eq '이름30' }">
							<c:out value="${score.name }"></c:out>
						</c:when>
						<c:otherwise>
							<c:out value="누구지???"></c:out>
						</c:otherwise>
					</c:choose>
				</td>

				<td>${score.kor }</td>
				<td>${score.eng }</td>
				<td>${score.math }</td>
				<td>${score.sum }</td>
				<td>${score.avg }</td>

				<td><c:choose>
						<c:when test="${score.grade eq 'A' || score.grade eq 'B'}">
							<c:out value="PASS"></c:out>

						</c:when>
						<c:otherwise>
							<c:out value="FAIL"></c:out>
						</c:otherwise>

					</c:choose></td>
			</tr>
		</c:forEach>
	</table>

	<br><br><br>

	<table border="1">
		<tr>
			<th>구구단</th>
			<th colspan="9">값</th>
			</tr>
			<tr>
			<c:forEach var="i" begin="1" end="9" step="1">
				<th>${i }단</th>
				<c:forEach var="j" begin="1" end="9" step="1">
					<td>${i } * ${j } = ${i * j }</td>
				</c:forEach>
		</tr>
		</c:forEach>
	</table>
</body>
</html>