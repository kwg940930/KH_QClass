package com.test01;

import java.io.IOException;

public class RuntimeTest {

	public static void main(String[] args) {
		Runtime rt = Runtime.getRuntime();
		
		try {
			Process prc = rt.exec("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
