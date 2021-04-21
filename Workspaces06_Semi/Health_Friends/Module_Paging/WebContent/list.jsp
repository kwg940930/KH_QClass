<%@page import="com.dao.Dao"%>
<%@page import="com.util.Paging"%>
<%@page import="java.util.List"%>
<%@page import="com.dto.Dto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("UTF-8"); %>
<%response.setContentType("text/html; charset=UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%
	List<Dto> list = (List<Dto>) request.getAttribute("list");

	int pageNum = request.getParameter("page") == null ? 1 : Integer.parseInt(request.getParameter("page"));

	int totalCount = Integer.parseInt(request.getAttribute("totalCount")+"");
	
	Paging paging = new Paging();
	paging.setPageNo(pageNum);
	paging.setPageSize(10);
	paging.setTotalCount(totalCount);
	
	Dao dao = new Dao();
%>
</head>

<script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		
		var pageNum = <%=pageNum-1%>;
		
		if(pageNum >= 10){
			pageNum %= 10;
		}
		
		$(".pagination>a").eq(pageNum).addClass("on");
		
	})
</script>

<style>
	.pagination {
		padding: 10px 0;
	}
	
	.pagination a {
		padding: 5px;
		margin: 5px;
		cursor: pointer;
	}
	
	.pagination a.on {
		font-weight: bold;
		font-size: 20px;
	}
</style>

<body>
	<h1>list</h1>
	
	<input type="hidden" name="command" value="multidelete">
		<table border="1">
		
		<col width="50px">
		<col width="100px">
		<col width="300px">
		<col width="100px">
		
			<tr>
				<th>번호</th>
				<th>작성자</th>
				<th>제목</th>
				<th>작성일</th>
			</tr>
<%
			for (Dto dto : list) {
%>
			<tr>
				<td><%=dto.getSeq() %></td>
				<td><%=dto.getWriter() %></td>
				<td><%=dto.getTitle() %></td>
				<td><%=dto.getRegdate() %></td>
			</tr>
<%
			}
%>
		</table>
		
	<!--  pagination -->
	<div class="pagination">
		<input type="button" onclick="pageMove(<%=paging.getFirstPageNo()%>)" value="◀">
		<input type="button" onclick="pageMove(<%=paging.getPrevPageNo()%>)" value="◁">
	
<%
		for (int i = paging.getStartPageNo(); i <= paging.getEndPageNo(); i++) {
%>
			<a onclick="pageMove(<%=i%>)"><%=i%></a>
<%
		}
%>
	
		<input type="button" onclick="pageMove(<%=paging.getNextPageNo()%>)" value="▷">
		<input type="button" onclick="pageMove(<%=paging.getFinalPageNo()%>)" value="▶">
	</div>
		
	<script>
		function pageMove(page){
			location.href='Controller.do?command=list&page='+page
		}
	</script>
</body>
</html>