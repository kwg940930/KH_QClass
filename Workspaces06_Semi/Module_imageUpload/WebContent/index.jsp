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
<%-- multipart/form-data는 파일 업로드가 있는 양식 요소에 사용되는 enctype 속성값중 하나 
multipart는 폼데이터가 여러 부분으로 나뉘어 서버로 전송되는 것을 의미함 (모든 문자를 인코딩하지 않음을 명시함.)
enctype는 post방식일때만 사용할수 있다. --%>
<form action="profile.jsp" method="post" enctype="multipart/form-data">
	<input type="file" name="filename">
	<input type="submit" value="업로드">
</form>
</body>
</html>