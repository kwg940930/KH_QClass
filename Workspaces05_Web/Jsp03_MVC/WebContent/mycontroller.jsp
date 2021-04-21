<%@page import="com.mvc.dto.MVCBoardDto"%>
<%@page import="java.util.List"%>
<%@page import="com.mvc.biz.MVCBoardBiz"%>
<%@page import="com.mvc.biz.MVCBoardBizImpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8");%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String command = request.getParameter("command");
	System.out.printf("[%s]\n", command);

	MVCBoardBiz biz = new MVCBoardBizImpl();

	// 요청한 명령을 확인한다.
	if (command.equals("list")) {
		// 1. 보내준 값이 있으면, 받는다.
		// 2. DB에 전달할 값이 있으면 전달하고,
		//    없으면 없는대로 호출해서 리턴받는다.
		List<MVCBoardDto> list = biz.selectlist();

		// 3. 화면에 전달할 값이 있으면, request 객체에 담아준다.
		// object 타입으로...
		request.setAttribute("list", list);

		// 4. 보낸다.
		pageContext.forward("mylist.jsp");
	} else if (command.equals("insertform")) {
		// 1, 2, 3, 4 단계가 다 없음...
		response.sendRedirect("myinsert.jsp");
		/*
			pageContext.forward() : 페이지 위임 (request, response 객체가 그대로 전달)
			response.sendRedirect() : 페이지 이동 (새로운 request, response 객체)
		*/
	} else if (command.equals("insertres")) {
		// 1.
		String writer = request.getParameter("writer");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		// 2.
		MVCBoardDto dto = new MVCBoardDto();
		dto.setWriter(writer);
		dto.setTitle(title);
		dto.setContent(content);
		
		int res = biz.insert(dto);
		// 3.
		// 4.
		if(res > 0){
%>

	<script type="text/javascript">
		alert("글 작성 성공");
		location.href = 'mycontroller.jsp?command=list';
	</script>
<%
		} else {
%>
	<script type="text/javascript">
		alert("글 작성 실패");
		location.href = 'mycontroller.jsp?command=insertform';
	</script>
<%		
		} 
		
	} else if(command.equals("selectOne")){
		// 1. 
		int seq = Integer.parseInt(request.getParameter("seq"));
		// 2. 
		MVCBoardDto dto = biz.selectOne(seq);
		// 3. 
		request.setAttribute("selectOne", dto);
		// 4. 
		pageContext.forward("myselect.jsp");
		
		
		
	} else if(command.equals("update")){
		
		int seq = Integer.parseInt(request.getParameter("seq"));
		MVCBoardDto dto = biz.selectOne(seq);
		
		request.setAttribute("seq", seq);
		
		pageContext.forward("myupdate.jsp");
		
	} else if(command.equals("updateres")){
		// 1.
		int seq = Integer.parseInt(request.getParameter("seq"));
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		// 2.
		MVCBoardDto dto = new MVCBoardDto();
		dto.setSeq(seq);
		dto.setTitle(title);
		dto.setContent(content);
		
		int res = biz.update(dto);
		
		// 3.
		// 4.
		if(res > 0){
%>

	<script type="text/javascript">
		alert("글 수정 성공");
		location.href = 'mycontroller.jsp?command=list';
	</script>
	<%
		} else {
%>

	<script type="text/javascript">
		alert("글 수정 실패");
		location.href = 'mycontroller.jsp?command=list';
	</script>

	<%		
		} 
	} else if(command.equals("delete")){
		
		int seq = Integer.parseInt(request.getParameter("seq"));
		
		int res = biz.delete(seq);
		
		if(res > 0){
%>
	<script type="text/javascript">
		alert("게시글이 삭제되었습니다.");
		location.href = "mycontroller.jsp?command=list";
	</script>
<%
		} else {
%>
	<script type="text/javascript">
		alert("게시글 삭제 실패");
		location.href = "mycontroller.jsp?command=list";
	</script>
<%
		}
		
	} else if(command.equals("multidelete")){
		String[] seqs = request.getParameterValues("chk");
		
		if(seqs == null || seqs.length == 0){
%>
	<script type="text/javascript">
		alert("삭제할 글을 선택해 주세요!");
		location.href = "mycontroller.jsp?command=list";
	</script>
<%
		} else {
			int res = biz.multiDelete(seqs);
			if(res > 0){
%>
	<script type="text/javascript">
		alert("선택한 게시글들을 삭제하였습니다");
		location.href = "mycontroller.jsp?command=list";
	</script>
<%
			} else {
%>
	<script type="text/javascript">
		alert("선택한 글들을 삭제하지 못하였습니다.");
		location.href = "mycontroller.jsp?command=list";
	</script>
<%
			}
		}
	}
 %>
</body>
</html>