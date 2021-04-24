<%@page import="java.util.Enumeration"%>
<%@page import="java.io.File"%>
<%@page import="com.oreilly.servlet.MultipartRequest,com.oreilly.servlet.multipart.DefaultFileRenamePolicy,java.util.*,java.io.*" %>
<%@page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("UTF-8"); %>
<%response.setContentType("text/html; charset=UTF-8"); %>
 <!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="UTF-8">
<head>
<%@ page import="com.oreilly.servlet.MultipartRequest,com.oreilly.servlet.multipart.DefaultFileRenamePolicy,java.util.*,java.io.*" %>
<%@ page import="java.sql.*" %>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
		String realFolder = "profileimg";
		String filename = request.getParameter("filename");
		int maxSize = 480 * 480 * 5;
		String encType = "UTF-8";
		String savefile = "profileimg";
		ServletContext scontext = getServletContext();
		
		realFolder = scontext.getRealPath(savefile);
		
		//만약 폴더가 없다면 폴더를 만들기 위함
		File folder = new File(realFolder);
		
		try {
			if (!folder.exists()) {
				folder.mkdir();
			}
			MultipartRequest multi = new MultipartRequest(request, realFolder, maxSize, encType, new DefaultFileRenamePolicy());

			Enumeration<?> files = multi.getFileNames();
			String file = (String) files.nextElement();
			filename = multi.getFilesystemName(file);
			System.out.println(filename);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//String fullpath = realFolder + "\\" + filename;
%>
<img src="profileimg/<%=filename %>" width=480 height=480></img>
</body>
</html>