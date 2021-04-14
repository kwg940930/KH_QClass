package com.test02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;


public class MyServer {
	
	public static void main(String[] args) {
		
		ServerSocket serverSocket = null;
		Socket serviceSocket;
		PrintWriter out = null;
		BufferedReader in = null;
		
		try {
			//9999포트로 들어오는 데이터 수신 소켓 생성
			serverSocket = new ServerSocket(9999);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		while(true) {
			System.out.println("client를 기다립니다...");
			
			try {
			serviceSocket = serverSocket.accept();
			System.out.println("client가 접속했습니다!");
			
			in = new BufferedReader(new InputStreamReader(serviceSocket.getInputStream()));
			
			out = new PrintWriter(serviceSocket.getOutputStream(), true);
			
			String inputLine;
			while((inputLine = in.readLine()) != null) {
				System.out.println("client : " + inputLine);
				out.println(inputLine);
			}
			
			out.close();
			in.close();
			serviceSocket.close();
			serverSocket.close();
			
		} catch(IOException e) {
		
			}
		}
	}

}
