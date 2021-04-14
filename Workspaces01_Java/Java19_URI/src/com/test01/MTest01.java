package com.test01;

import java.net.URI;
import java.net.URISyntaxException;

public class MTest01 {
	
	public static void main(String[] args) throws URISyntaxException {
		URI u = new URI("http://localhost:8787/Java19_URI_Web/res.jsp?name=%EA%B0%95%EC%9B%90%EA%B8%B0&addr=%EB%8F%99%EB%8C%80%EB%AC%B8%EA%B5%AC");

		System.out.println(u.getScheme());
		System.out.println(u.getHost());
		System.out.println(u.getPort());
		System.out.println(u.getPath());
		System.out.println(u.getQuery());
		

	
	
	}

}
