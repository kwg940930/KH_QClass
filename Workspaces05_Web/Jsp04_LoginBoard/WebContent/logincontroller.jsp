<%@page import="java.util.List"%>
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
	String command = request.getParameter("command");
	System.out.println("[" + command + "]");
	
	MYMemberBiz biz = new MYMemberBiz();
	
	if(command.equals("login")){
		
		String myid = request.getParameter("myid");
		String mypw = request.getParameter("mypw");
		
		MYMemberDto dto = biz.login(myid, mypw);
		
		if(dto != null){
			// session scope에 객체 담기			//세션과 쿠키의 차이 알아보기!!
			session.setAttribute("dto",dto);
			// 만료되는 시간 설정 (default:30분)
			session.setMaxInactiveInterval(10 * 60);
			
			if(dto.getMyenabled().equals("Y")){
				if(dto.getMyrole().equals("ADMIN")){
					response.sendRedirect("adminmain.jsp");
				} else if(dto.getMyrole().equals("USER")){
					response.sendRedirect("usermain.jsp");
				}
			} else {
%>
		<script type="text/javascript">
			alert("탈퇴한 회원입니다.");
			location.href="index.html";
		</script>
<%
			}
			
		} else {
%>
		<script type="text/javascript">
			alert("ID가 존재하지 않거나 PW가 틀렸습니다.");
			location.href="index.html";
		</script>
<%
		}
		
	} else if(command.equals("logout")){
		// session scope에서 값 삭제 (만료)
		session.invalidate();
		response.sendRedirect("index.html");
		
	} else if(command.equals("listall")){
		List<MYMemberDto> list = biz.selectAllUser();
		
		//어떤이름으로 어떤 객체를 담자
		request.setAttribute("list", list);
		
		pageContext.forward("userlistall.jsp");
	} else if(command.equals("listen")){
		List<MYMemberDto> list = biz.selectEnabledUser();
		
		request.setAttribute("list", list);
		
		pageContext.forward("userlisten.jsp");
		
	} else if(command.equals("updateroleform")){
		
		int myno = Integer.parseInt(request.getParameter("myno"));
		MYMemberDto dto = biz.selectUser(myno);
		
		request.setAttribute("dto", dto);
		pageContext.forward("updaterole.jsp");
		
	} else if(command.equals("updaterole")){
		int myno = Integer.parseInt(request.getParameter("myno"));
		String myrole = request.getParameter("myrole");
		
		int res = biz.updateRole(myno, myrole);
		
		if(res > 0){
%>
		<script type="text/javascript">
			alert("등급 변경 성공");
			location.href="logincontroller.jsp?command=listen";
		</script>

<%
		} else {
%>
		<script type="text/javascript">
			alert("등급변경 실패");
			location.href="logincontroller.jsp?command=updateroleform&myno=<%=myno%>";
		</script>
<%
		}
		
	} else if (command.equals("registform")){
		response.sendRedirect("regist.jsp");
		
		
	} else if(command.equals("idchk")){
		String myid = request.getParameter("myid");
		MYMemberDto dto = biz.idCheck(myid);
		
		boolean idnotused = true;
		
		if(dto.getMyid() != null){
			idnotused = false;
		}
		
		response.sendRedirect("idchk.jsp?idnotused="+idnotused+"&myid="+myid);

	
	} else if(command.equals("insertuser")){

		String myid = request.getParameter("myid");
		String mypw = request.getParameter("mypw");
		String myname = request.getParameter("myname");
		String myaddr = request.getParameter("myaddr");
		String myphone = request.getParameter("myphone");
		String myemail = request.getParameter("myemail");
		
		
		MYMemberDto dto = new MYMemberDto();
		dto.setMyid(myid);
		dto.setMypw(mypw);
		dto.setMyname(myname);
		dto.setMyaddr(myaddr);
		dto.setMyphone(myphone);
		dto.setMyemail(myemail);
				
		int res = biz.insertUser(dto);
		
		if(res > 0){
%>
		<script type="text/javascript">
			alert("회원가입이 완료되었습니다.");
			location.href="index.html";
		</script>
<%
		} else {
%>
		<script type="text/javascript">
			alert("회원가입에 실패하였습니다.");
			location.href="logincontroller.jsp?command=registform";
		</script>
<%
		}
	} else if(command.equals("selectuser")){
		
		int myno = Integer.parseInt(request.getParameter("myno"));
		MYMemberDto dto = biz.selectUser(myno);
		
		request.setAttribute("selectuser", dto);
		
		pageContext.forward("selectuser.jsp");
		
	} else if(command.equals("userupdate")){
		int myno = Integer.parseInt(request.getParameter("myno"));
		MYMemberDto dto = biz.selectUser(myno);
		
		request.setAttribute("myno", myno);
		
		pageContext.forward("userupdate.jsp");
		
		
	} else if(command.equals("userupdateres")){
		int myno = Integer.parseInt(request.getParameter("myno"));
		String myid = request.getParameter("myid");
		String mypw = request.getParameter("mypw");
		String myname = request.getParameter("myname");
		String myaddr = request.getParameter("myaddr");
		String myphone = request.getParameter("myphone");
		String myemail = request.getParameter("myemail");
		
		
		MYMemberDto dto = new MYMemberDto();
		dto.setMyid(myid);
		dto.setMyno(myno);
		dto.setMypw(mypw);
		dto.setMyname(myname);
		dto.setMyaddr(myaddr);
		dto.setMyphone(myphone);
		dto.setMyemail(myemail);
		
		int res = biz.updateUser(dto);
		
		if(res > 0){
%>
	<script type="text/javascript">
		alert("회원정보가 수정되었습니다.");
		location.href = 'logincontroller.jsp?command=login&myid=<%=dto.getMyid()%>&mypw=<%=dto.getMypw()%>';
	</script>
<%
		} else {
%>
	<script type="text/javascript">
		alert("회원정보 수정이 실패 하였습니다.");
		location.href = 'logincontroller.jsp?command=login&myid=<%=dto.getMyid()%>&mypw=<%=dto.getMypw()%>';
	</script>

<%
		}	
	} else if(command.equals("deleteuser")){
		
		int myno = Integer.parseInt(request.getParameter("myno"));
		String myid = request.getParameter("myid");
		String mypw = request.getParameter("mypw");
		
		
		MYMemberDto dto = new MYMemberDto();
		dto.setMyid(myid);
		dto.setMyno(myno);
		dto.setMypw(mypw);
		
		int res = biz.deleteUser(myno);
		
		if(res > 0){
%>
	<script type="text/javascript">
		alert("성공적으로 탈퇴 되었습니다.");
		location.href = 'index.html';
	</script>
<%
		} else {
%>
	<script type="text/javascript">
		alert("회원탈퇴가 실패 하였습니다.");
		location.href = 'logincontroller.jsp?command=login&myid=<%=dto.getMyid()%>&mypw=<%=dto.getMypw()%>';
	</script>
<%	
		}
	}
%>	
	























































	<h1 style="color: red;">잘못왔다....</h1>

</body>
</html>