package com.test02;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MTest01 {

	public static void main(String[] args) throws IOException {
		
		String file = "a.jpg";
		/* 
		파일 객체를 만들어서 넣고있음
		FileInputStream fi = new FileInputStream(file);
		BufferedInputStream bi = new BufferedInputStream(fi);
		한줄로 만들수 있다 
		*/
		
		BufferedInputStream bi = new BufferedInputStream(new FileInputStream(file));
		
		FileOutputStream fo = new FileOutputStream(new File("c.jpg"));
		
		int a = 0;
		while ((a = bi.read()) != -1){
			fo.write(a);
		}
		
		//가장 마지막에 연결한 객체를 가장 먼저 닫자!!
		fo.close();
		bi.close();
	}
}
