package com.google;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 * Servlet implementation class gogleServlet
 */
@WebServlet("/google.do")
public class googleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		String token = request.getParameter("token");
		
		String targetURL = "https://www.google.com/recaptcha/api/siteverify";
		
		URL url;
		HttpURLConnection connection = null;
		String params = "";
		String jsonData = "";
		String secretKey = "6LdY0Y0aAAAAAOZStqMc9j_N9hFdaCCxU4WxkKjV";
		int res = 0;
		
		try {
			params = "secret=" + secretKey + "&response=" + token + "&remoteip=localhost";
			
			url = new URL(targetURL); 
			connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("POST");
			connection.setUseCaches(false);
			connection.setDoInput(true);
			connection.setDoOutput(true);
			
			DataOutputStream os = new DataOutputStream(connection.getOutputStream());
			os.writeBytes(params);
			os.flush();
			os.close();
			
			InputStream is = connection.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
			StringBuffer sb = new StringBuffer();
			
			while ((jsonData = br.readLine()) != null) {
				sb.append(jsonData);
			}
			JSONParser parser = new JSONParser();
			Object resvObj = parser.parse(sb.toString());
			JSONObject jsonObj = (JSONObject) resvObj;
			
			double score = (double) jsonObj.get("score");
			if(score > 0.5) {
				res = 1;
				System.out.println(score);
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(connection != null) {
				connection.disconnect();
			}
		}
		
		response.getWriter().print(res);
		
	}

}
