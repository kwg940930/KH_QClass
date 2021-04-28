package com.mvc.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
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

@WebServlet(urlPatterns = {"/selectList", "/selectOne", "/insertForm", "/insert", "/updateForm", "/update", "/deleteProc", "/multiDelete"})
public class MVCController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private MVCBoardBiz biz;
	
	private void getRequestUri(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		biz = new MVCBoardBizImpl();
		
		String command = request.getRequestURI();
		System.out.println("[" + command + "]");
		
		if(command.endsWith("/selectList")) {
			doSelectList(request,response);
		} else if(command.endsWith("/selectOne")) {
			doSelectOne(request, response);
		} else if(command.endsWith("/insertForm")) {
			doInsertForm(request, response);
		} else if(command.endsWith("/insert")) {
			doInsert(request, response);
		} else if(command.endsWith("/updateForm")) {
			doUpdateForm(request, response);
		} else if(command.endsWith("/update")) {
			doUpdate(request, response);
		} else if(command.endsWith("/deleteProc")) {
			doDeleteProc(request, response);
		} else if(command.endsWith("/multiDelete")) {
			doMultiDelete(request, response);
		}
	}
       
	private void doSelectOne(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int seq = Integer.parseInt(request.getParameter("seq"));
		
		MVCBoardDto dto = biz.selectOne(seq);
		
		request.setAttribute("dto", dto);
		
		dispatch(request, response, "mvcselect.jsp");
	}

	private void doSelectList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<MVCBoardDto> list = biz.selectlist();
		
		request.setAttribute("list", list);
		
		dispatch(request, response, "mvclist.jsp");
	}
	
	private void doInsertForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("mvcinsert.jsp");
	}
	
	private void doInsert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String writer = request.getParameter("writer");
		String title = request.getParameter("title");
		String content = request.getParameter("content");

		MVCBoardDto dto = new MVCBoardDto(writer, title, content);
		
		int res = biz.insert(dto);
		List<MVCBoardDto> list = biz.selectlist();
		request.setAttribute("list", list);
		
		if(res > 0){
			jsResponse(response, "selectList", "게시글 작성 성공!");
		} else {
			jsResponse(response, "insertForm", "게시글 작성 실패!");
		}
	}
	
	private void doUpdateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int seq = Integer.parseInt(request.getParameter("seq"));
		
		MVCBoardDto dto = biz.selectOne(seq);
		
		request.setAttribute("dto", dto);
		
		dispatch(request, response, "mvcupdate.jsp");
	}
	
	private void doUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int seq = Integer.parseInt(request.getParameter("seq"));
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		MVCBoardDto dto = new MVCBoardDto();
		dto.setSeq(seq);
		dto.setTitle(title);
		dto.setContent(content);
		int res = biz.update(dto);
		
		if(res > 0){
			jsResponse(response, "selectList?seq="+seq, "게시글 수정 성공!");
		} else {
			jsResponse(response, "UpdateForm?seq="+seq, "게시글 수정 실패!");
		}
	}
	
	private void doDeleteProc(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int seq = Integer.parseInt(request.getParameter("seq"));
		
		int res = biz.delete(seq);
		
		if(res > 0){
			jsResponse(response, "selectList", "게시글 삭제 성공!");
		} else {
			jsResponse(response, "selectOne?seq="+seq, "게시글 삭제 실패!");
		}
	}
	
	private void doMultiDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] seqs = request.getParameterValues("chk");
		
		if(seqs == null || seqs.length == 0){
			jsResponse(response, "selectList", "게시글 선택 삭제 성공!");
		} else {
			int res = biz.multidelete(seqs);
			if(res > 0){
				jsResponse(response, "selectList", "게시글 선택 삭제 성공!");
			} else {
				jsResponse(response, "selectList", "게시글 선택 삭제 실패!");
			}
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		getRequestUri(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		getRequestUri(request, response);
		//doGet(request, response);
	}
	
	public void dispatch(HttpServletRequest request, HttpServletResponse response, String path) throws ServletException, IOException {
		RequestDispatcher dispatch = request.getRequestDispatcher(path);
		dispatch.forward(request, response);
	}
	
	private void jsResponse(HttpServletResponse response, String url, String msg) throws IOException {
		PrintWriter out = response.getWriter();
		String s = "<script>alert('"+msg+"');location.href='"+url+"';</script>";
		out.println(s);
	}
}
