package com.test01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MTest01 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// ojdbc6.jar(꼭 추가 해야함! ) -> oracle.jdbc.driver.OracleDriver
		// jar파일?

		// 1. 드라이버 연결
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		
		// 2. 계정연결
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "kh";
		String password = "kh";
		
		Connection con = DriverManager.getConnection(url, user, password);
		
		// 3. 쿼리 준비
		String sql = " SELECT EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM, DEPTNO FROM EMP ";
		PreparedStatement pstm = con.prepareStatement(sql);
		// 4.쿼리 실행 및 리턴
		ResultSet rs = pstm.executeQuery();
		while(rs.next()) {
			System.out.printf("%5d %11s %9s %5d %10s %8.2f %8.2f %2d \n", rs.getInt(1), rs.getString("ENAME"), rs.getString(3), rs.getInt("MGR"),
					rs.getDate(5), rs.getDouble("SAL"), rs.getDouble(7), rs.getInt("DEPTNO"));
		}
		
		// 5. db종료
		rs.close();
		pstm.close();
		con.close();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		/*
		
		
		
		// 1. dirver연결
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		// 2. 계정 연결
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "kh";
		String password = "kh";
		
		Connection con = DriverManager.getConnection(url, user, password);
		
		// 3. query 준비
		String sql = " SELECT * FROM EMP ";
		Statement stmt = con.createStatement();
		
		// 4. query 실행 및 리턴
		ResultSet rs = stmt.executeQuery(sql);
		while (rs.next()) {
			System.out.printf("%5d %11s %9s %5d %10s %8.2f %8.2f %2d \n",
					rs.getInt(1), rs.getString(2), rs.getString("JOB"), rs.getInt(4), 
					rs.getDate(5), rs.getDouble("SAL"), rs.getDouble(7), rs.getInt(8));
		}
		
		// 5. db종료
		rs.close();
		stmt.close();
		con.close();
		*/
	}
	
}
