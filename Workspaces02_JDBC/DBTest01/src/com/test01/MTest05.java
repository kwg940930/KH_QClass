package com.test01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class MTest05 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("수정할 부서번호 : ");
		int deptno = sc.nextInt();
		System.out.println("수정할 부서이름 : ");
		String dname = sc.next();
		System.out.println("수정할 부서지역 : ");
		String loc = sc.next();
		
		//1. 드라이버연결
		try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		//2. 계정연결
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "kh";
		String password = "kh";
		
		
		Connection con = null;
		
		try {
		 con = DriverManager.getConnection(url, user, password);
		 // con.setAutoCommit(false);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		String sql = " UPDATE DEPT "
				   + " SET DNAME = '" + dname + "', LOC = '" + loc
				   + "' WHERE DEPTNO = " + deptno;
	
		Statement stmt = null;
		try {
			//3. Query 준비
			stmt = con.createStatement();
			
			//4. Query 실행 및 리턴
			int res = stmt.executeUpdate(sql);
			if(res > 0) {
				System.out.println("입력 성공");
			}else {
				System.out.println("입력 실패");
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			//5. DB종료
			try {
				stmt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	
	}
}
