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
import com.mvc.util.Paging;

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
			
			int pageNum = request.getParameter("page") == null ? 1 : Integer.parseInt(request.getParameter("page"));
			
			int totalCount = biz.getTotalCount();
			
			Paging paging = new Paging();
			paging.setPageNo(pageNum);
			paging.setPageSize(10);
			paging.setTotalCount(totalCount);
			
			pageNum = (pageNum - 1) * 10;// 1 이면 0, 2이면 10, 3이면 20...
			
			
			// 어디부터 어디까지 가져올 건지 쓰는것 -> 쿼리 안쪽에서 계산해줌
			List<MVCBoardDto> list = biz.selectListWPage(pageNum, paging.getPageSize());
			request.setAttribute("list", list);
			request.setAttribute("pageNum", pageNum);
			request.setAttribute("totalCount", totalCount);
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

				PrintWriter out = response.getWriter();
				String html = "<script type='text/javascript'>"
							+ "alert('" + "글 작성 성공" + "');"
							+ "location.href='myservlet.do?command=list'"
							+ "</script>";
				out.println(html);
			} else {
				
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
				
				String html = "<script type='text/javascript'>"
							+ "alert('" + "글 수정 성공" + "');"
							+ "location.href='myservlet.do?command=selectOne&seq=" + dto.getSeq() + "';"
							+ "</script>";
				PrintWriter out = response.getWriter();
				out.println(html);
				
			} else {
				
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
				
				String html = "<script type='text/javascript'>"
							+ "alert('" + "글 삭제 성공" + "');"
							+ "location.href='myservlet.do?command=list'"
							+ "</script>";
				PrintWriter out = response.getWriter();
				out.println(html);
			} else {
				
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
