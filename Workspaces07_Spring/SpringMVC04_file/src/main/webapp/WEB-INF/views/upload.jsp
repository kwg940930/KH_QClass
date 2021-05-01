<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form:form method="post" enctype="multipart/form-data" modelAttribute="uploadFile" action="upload">
		<h3>uploadForm</h3>
		file<br/>
		<input type="file" name="mpfile" /><br/>
		<p style="color:red; font-weight: bold;">
			<form:errors path="mpfile"></form:errors>
		</p><br/>
		<textarea rows="10" cols="40" name="desc"></textarea><br/>
		<input type="submit" value="send" />
	</form:form>
	
<!-- 
	enctype
	1. application/www-form-urlencoded : (default) 문자들을 encoding
	2. multipart/form-date : file upload - post 방식만 가능
	3. text/plain : encoding 하지 않음
	
	spring form tag
		form:form, form:errors, form:input, ...
		form:errors - Errors, BindingResult를 사용할 때, command객체의 특정 field에서 발생하는 에러메시지 출력
 -->

</body>
</html>