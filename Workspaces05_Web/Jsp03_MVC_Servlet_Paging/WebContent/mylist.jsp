<%@page import="com.mvc.biz.MVCBoardBiz"%>
<%@page import="com.mvc.biz.MVCBoardBizImpl"%>
<%@page import="com.mvc.util.Paging"%>
<%@page import="com.mvc.dto.MVCBoardDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%
	List<MVCBoardDto> list = (List<MVCBoardDto>) request.getAttribute("list");

	int pageNum = request.getParameter("page") == null ? 1 : Integer.parseInt(request.getParameter("page"));

	int totalCount = Integer.parseInt(request.getAttribute("totalCount")+"");
	
	Paging paging = new Paging();
	paging.setPageNo(pageNum);
	paging.setPageSize(10);
	paging.setTotalCount(totalCount);
	
	MVCBoardBiz biz = new MVCBoardBizImpl();
%>
</head>

<script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>
<script type="text/javascript">

	$(function(){
		$("#muldelform").submit(function(){
			if($("#muldelform input:checked").length == 0){
				alert("하나 이상 체크해 주세요");
				return false;
			}
		});
		
		$("input[name=chk]").click(function(){
	        if($("input[name=chk]").length == $("input[name=chk]:checked").length){
	            $("input[name=all]").prop("checked",true);
	        }else{
	            $("input[name=all]").prop("checked",false);
	        }
	    });

	});
	
	function allchk(bool){
		var chks = document.getElementsByName("chk");
		for(var i = 0; i < chks.length; i++){
			chks[i].checked = bool;
		}
	}
	
	
	
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
	
	<form action="myservlet.do" method="post">
	<input type="hidden" name="command" value="multidelete">
		<table border="1">
		
		<col width="20px">
		<col width="50px">
		<col width="100px">
		<col width="300px">
		<col width="100px">
		
			<tr>
				<th><input type="checkbox" name="all"  onclick=allchk(this.checked);></th>
				<th>번호</th>
				<th>작성자</th>
				<th>제목</th>
				<th>작성일</th>
			</tr>
<%
			for (MVCBoardDto dto : list) {
%>
			<tr>
				<td><input type="checkbox" name="chk" value="<%=dto.getSeq() %>"></td>
				<td><%=dto.getSeq() %></td>
				<td><%=dto.getWriter() %></td>
				<td><a href="myservlet.do?command=selectOne&seq=<%=dto.getSeq()%>"><%=dto.getTitle() %></a></td>
				<td><%=dto.getRegdate() %></td>
			</tr>
<%
			}
%>
			<tr>
				<td colspan="5" align="right">
					<input type="button" value="글작성" onclick="location.href='myservlet.do?command=insertform'">
					<input type="submit" value="선택삭제">
				</td>
			</tr>
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
				location.href='myservlet.do?command=list&page='+page
			}
		</script>
		
	</form>
</body>
</html>