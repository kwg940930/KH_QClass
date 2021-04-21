package com.mvc.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.biz.MVCBoardBiz;
import com.mvc.biz.MVCBoardBizImpl;
import com.mvc.dto.MVCBoardDto;

@WebServlet("/MyServlet")
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String command = request.getParameter("command");
		System.out.printf("[%s]\n", command);
		
		MVCBoardBiz biz = new MVCBoardBizImpl();
		
		if (command.equals("list")) {
			// 1. 보내준 값 있으면 받기
			// 2. db 호출 (전달할 값 있으면 전달)
			List<MVCBoardDto> list = biz.selectlist();
			// 3. 화면에 보내줄 값 있으면 request객체에 담기 저장
			request.setAttribute("list", list);
			// 4. 보내기
			dispatch(request, response, "mylist.jsp");
			
		} else if(command.equals("selectOne")){
			int seq = Integer.parseInt(request.getParameter("seq"));
			
			MVCBoardDto dto = biz.selectOne(seq);
			
			request.setAttribute("dto", dto);
			
			dispatch(request, response, "myselect.jsp");
			
		} else if (command.equals("insertform")) {
			// 4.
			response.sendRedirect("myinsert.jsp");
			
		} else if (command.equals("insertres")) {
			
			String writer = request.getParameter("writer");
			String title = request.getParameter("title");
			String content = request.getParameter("content");

			MVCBoardDto dto = new MVCBoardDto(writer, title, content);
			
			int res = biz.insert(dto);
			List<MVCBoardDto> list = biz.selectlist();
			request.setAttribute("list", list);
			
			if(res > 0){
				
				/*
				이 방식으로 쓰면 request객체가 살아있어서 새로코침하면 같은글이 계속 생성됨
				request.setAttribute("list", biz.selectlist());
				dispatch(request, response, "mylist.jsp");
				*/

				/*
				sendRedirect를 사용하면 request객체가 안넘어가고 새로운 객체가 생김(새로운 페이지니까)
				response.sendRedirect("myservlet.do?command=list");
				 */

				PrintWriter out = response.getWriter();
				String html = "<script type='text/javascript'>"
							+ "alert('" + "글 작성 성공" + "');"
							+ "location.href='myservlet.do?command=list'"
							+ "</script>";
				out.println(html);
			} else {
				
				//response.sendRedirect("myservlet.do?command=list");
				
				PrintWriter out = response.getWriter();
				String html = "<script type='text/javascript'>"
							+ "alert('글 작성 실패');"
							+ "location.href='myservlet.do?command=insertform';"
							+ "</script>";
				out.println(html);
			} 
			
		} else if(command.equals("update")){
			
			int seq = Integer.parseInt(request.getParameter("seq"));
			
			MVCBoardDto dto = biz.selectOne(seq);
			
			request.setAttribute("seq", seq);
			
			dispatch(request, response, "myupdate.jsp");
			
		} else if(command.equals("updateres")){
			
			int seq = Integer.parseInt(request.getParameter("seq"));
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			
			MVCBoardDto dto = new MVCBoardDto();
			dto.setSeq(seq);
			dto.setTitle(title);
			dto.setContent(content);
			int res = biz.update(dto);
			
			if(res > 0){
				
				//response.sendRedirect("myservlet.do?command=select&seq="+seq);
				
				String html = "<script type='text/javascript'>"
							+ "alert('" + "글 수정 성공" + "');"
							+ "location.href='myservlet.do?command=selectOne&seq=" + dto.getSeq() + "';"
							+ "</script>";
				PrintWriter out = response.getWriter();
				out.println(html);
				
			} else {
				
				//response.sendRedirect("myservlet.do?command=select&seq="+Seq);
				
				PrintWriter out = response.getWriter();
				String html = "<script type='text/javascript'>"
							+ "alert('" + "글 수정 실패" + "');"
							+ "location.href='myservlet.do?command=update&seq=" + dto.getSeq() + "';"
							+ "</script>";
				out.println(html);
			} 
		} else if(command.equals("delete")){
			
			int seq = Integer.parseInt(request.getParameter("seq"));
			
			int res = biz.delete(seq);
			
			if(res > 0){
				
				//response.sendRedirect("myservlet.do?command=list");
				
				String html = "<script type='text/javascript'>"
							+ "alert('" + "글 삭제 성공" + "');"
							+ "location.href='myservlet.do?command=list'"
							+ "</script>";
				PrintWriter out = response.getWriter();
				out.println(html);
			} else {
				
				//response.sendRedirect("myservlet.do?command=select&seq="+seq);
				
				PrintWriter out = response.getWriter();
				String html = "<script type='text/javascript'>"
							+ "alert('" + "글 삭제 실패" + "');"
							+ "location.href='myservlet.do?command=selectOne&seq=" + seq + "';"
							+ "</script>";
				out.println(html);
			} 
		} else if(command.equals("multidelete")) {
			String[] seqs = request.getParameterValues("chk");
			if(seqs == null || seqs.length == 0){
				String html = "<script type='text/javascript'>"
						+ "alert('" + "삭제할 게시글을 선택해주세요" + "');"
						+ "location.href='myservlet.do?command=list'"
						+ "</script>";
			PrintWriter out = response.getWriter();
			out.println(html);
			} else {
				int res = biz.multiDelete(seqs);
				if(res > 0){
					String html = "<script type='text/javascript'>"
							+ "alert('" + "선택글 삭제 성공" + "');"
							+ "location.href='myservlet.do?command=list'"
							+ "</script>";
				PrintWriter out = response.getWriter();
				out.println(html);
					
				} else {
					PrintWriter out = response.getWriter();
					String html = "<script type='text/javascript'>"
								+ "alert('" + "선택글 삭제 실패" + "');"
								+ "location.href='myservlet.do?command=list';"
								+ "</script>";
					out.println(html);
				}
			}
		}
	}
	
	public void dispatch(HttpServletRequest request, HttpServletResponse response, String path) throws ServletException, IOException {
		RequestDispatcher dispatch = request.getRequestDispatcher(path);
		dispatch.forward(request, response);
	}
}
