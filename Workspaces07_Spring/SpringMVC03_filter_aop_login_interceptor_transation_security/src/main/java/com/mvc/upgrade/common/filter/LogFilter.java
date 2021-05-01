package com.mvc.upgrade.common.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogFilter implements Filter {
	
	private Logger logger = LoggerFactory.getLogger(LogFilter.class);

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;
		
		String remoteAddr = req.getRemoteAddr();		// ip주소 ( IPv6 형태 ) -> IPv4 형태로 나오게 하려면 localhost 대신 127.0.0.1로 요청하면됨
		String uri = req.getRequestURI();				// http 요청 url 중에 queryString까지 반환. (context path) / URI = URL + URN (어떤 경로에 누가 있냐?)
		String url = req.getRequestURL().toString();	// quertString을 제외한 경로(서블릿 포함) - protocol + servername + protnumber + serverpath
		String queryString = req.getQueryString();		// quertString : 경로 뒤에 있는 요청 쿼리 문자열(K=V 형태)
		String referer = req.getHeader("referer");		// 이전페이지의 url(getHeader : 지정한 요청 헤더값을 문자열로 반환)
		String agent = req.getHeader("User-Agent");		// 사용자 정보(browser version, os 등)
		
		StringBuffer sb = new StringBuffer();
		sb.append("\n* remoteAddr : " + remoteAddr)
	      .append("\n* uri : " + uri)
		  .append("\n* url : " + url)
		  .append("\n* queryString : " + queryString)
		  .append("\n* referer : " + referer)
		  .append("\n* agent : " + agent)
		  .append("\n");
		
		logger.info("\nLOG Filter" + sb);
		
		chain.doFilter(req, response);
	}

	@Override
	public void destroy() {

	}

}
