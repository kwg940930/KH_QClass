package com.test01;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class TestServer {

	public static void main(String[] args) throws IOException {
		
		//수신 소켓을 만금 -> 8888번 포트로 들어오는 데이터를 수신
		DatagramSocket ds = new DatagramSocket(8888);
		System.out.println("서버입니다.");
		
		//1024공간의 바이트배열 버퍼를 만듬
		byte[] buff = new byte[1024];
		//수신한 데이터를 저장할 패킷을 생성
		DatagramPacket receiveP = new DatagramPacket(buff, buff.length);
		
		//생성한 소켓과 패킷을 이용하여 데이터 수신
		ds.receive(receiveP);
		
		//수신된 결과를 패킷에 저장, 수신한 메세지를 문자열로 변환
		System.out.println(new String(receiveP.getData()));
		
		ds.close();
		ds.disconnect();
	}
}
