package com.test01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class MTest06 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "kh";
		String password = "kh";
		
		Connection con = null;
		
		try {
		 con = DriverManager.getConnection(url, user, password);

		} catch (SQLException e) {
			e.printStackTrace();
		}


		System.out.println("삭제할 부서 번호 : ");
		int deptno = sc.nextInt();
		
		String sql = " DELETE FROM DEPT "
				   + " WHERE DEPTNO = " + deptno;
	
		Statement stmt = null;
		
		try {
			stmt = con.createStatement();

			int res = stmt.executeUpdate(sql);
			if(res > 0) {
				System.out.println("삭제 성공");
			} 
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				stmt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	
	}
}
