package com.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dto.Dto;
import com.dao.Dao;
import com.util.Paging;


@WebServlet("/Controller.do")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String command = request.getParameter("command");
		
		Dao dao = new Dao();
		
		if(command.equals("list")) {
			int pageNum = request.getParameter("page") == null ? 1 : Integer.parseInt(request.getParameter("page"));
			int totalCount = dao.getTotalCount();
			
			Paging paging = new Paging();
			paging.setPageNo(pageNum);
			paging.setPageSize(10);
			paging.setTotalCount(totalCount);
			
			pageNum = (pageNum - 1) * 10;// 1 이면 0, 2이면 10, 3이면 20...
			
			// 어디부터 어디까지 가져올 건지 쓰는것 -> 쿼리 안쪽에서 계산해줌
			List<Dto> list = dao.listPaging(pageNum, paging.getPageSize());
			
			request.setAttribute("list", list);
			request.setAttribute("pageNum", pageNum);
			request.setAttribute("totalCount", totalCount);
			
			RequestDispatcher dispatch = request.getRequestDispatcher("list.jsp");
			dispatch.forward(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
