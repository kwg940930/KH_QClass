package com.test01;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class TestClient {

	public static void main(String[] args) throws IOException {
		
		//송신소켓 만듬
		DatagramSocket ds = new DatagramSocket();
		System.out.println("클라이언트 입니다.");
		
		//보낼 메세지를 저장한 패킷을 생성
		byte[] buff = "연습입니다.".getBytes();
		
		//송신을 위한 전송용 패킷 생성
		DatagramPacket sendP = new DatagramPacket(buff, buff.length, InetAddress.getByName("localhost"),8888);

		//데이터 전송
		ds.send(sendP);

		ds.close();
		ds.disconnect();
	}
}
