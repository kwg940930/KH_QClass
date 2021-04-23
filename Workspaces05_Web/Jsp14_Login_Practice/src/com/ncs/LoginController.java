package com.ncs;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LoginController.do")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	LoginService service = new LoginService();
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String command = request.getParameter("command");
		
		Connection conn = null;
		HttpSession session = request.getSession();
		
		Member m = null;

		if(command.equals("login")) {
			
			String userId = request.getParameter("userId");
			String Password = request.getParameter("Password");
			
			m = new Member();
			m.setUserId(userId);
			m.setPassword(Password);
			
			m = service.selectOneMember(conn, m);
			
			if(m != null){
				session.setAttribute("m",m);
				response.sendRedirect("loginSuccess.jsp");
			} else {
				response.sendRedirect("loginFail.jsp");
			}
			
			
		} else if(command.equals("logout")) {
			session.invalidate();
			response.sendRedirect("index.jsp");
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
