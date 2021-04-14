package com.test01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class MTest {
	
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		

		System.out.println("메뉴 선택");
		System.out.println("1:전체선택 2:특정 부서 선택 3: 부서 추가 4: 부서 수정 5: 부서 삭제 6: 종료");
		int select = sc.nextInt();

		switch(select) {
		 case 1:
			try {
				selectList();
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		   break;
		 case 2:
			try {
				selectOne();
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		   break;
		  case 3:
		    insert();
		    break;
		  case 4:
		   update();
		    break;
		  case 5:
		    delete();
		    break;
		  default:
		    System.out.println("종료");
		}
		
	}
	
	
	
	
	
	
	
	
	public static void selectList() throws ClassNotFoundException, SQLException {
		// ojdbc6.jar(꼭 추가 해야함! ) -> oracle.jdbc.driver.OracleDriver
		// jar파일?
		
		// 1. dirver연결
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		
		// 2. 계정 연결
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "kh";
		String password = "kh";
		
		Connection con = DriverManager.getConnection(url, user, password);
		
		
		// 3. query 준비
		String sql = " SELECT * FROM DEPT ";
		Statement stmt = con.createStatement();
		
		// 4. query 실행 및 리턴
		ResultSet rs = stmt.executeQuery(sql);
		while (rs.next()) {
			System.out.printf("%5d %11s %9s \n",
					rs.getInt(1), rs.getString(2), rs.getString(3));
		}
		
		
		// 5. db종료
		rs.close();
		stmt.close();
		con.close();
		
	}
	
	
	
	
	
	
	
	
	
	public static void selectOne() throws ClassNotFoundException, SQLException {
		System.out.println("부서번호를 입력하세요 : ");
		int deptno = sc.nextInt();
		
		// 1. driver 연결
		Class.forName("oracle.jdbc.driver.OracleDriver");

		// 2. 계정 연결
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "kh";
		String password = "kh";

		Connection con = DriverManager.getConnection(url, user, password);

		// 3. query 준비
		String sql = " SELECT * FROM DEPT WHERE DEPTNO = " + deptno;
		Statement stmt = con.createStatement();

		// 4. query 실행 및 리턴
		ResultSet rs = stmt.executeQuery(sql);
		while (rs.next()) {
			System.out.println(rs.getInt("DEPTNO") + " \t " + rs.getString(2) + " \t " + rs.getString(3));
		}
				
		// 5. db종료
		rs.close();
		stmt.close();
		con.close();
	}
	
	
	
	
	
	
	
	
	
	public static void insert() {
		System.out.println("부서번호 입력 : ");
		int deptno = sc.nextInt();
		System.out.println("부서이름 입력 : ");
		String dname = sc.next();
		System.out.println("지역이름 입력 : ");
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

		//4.
		String sql = " INSERT INTO DEPT "
				+ " VALUES( " + deptno + ", '" + dname + "' , '" + loc + "') ";
		
		Statement stmt = null;
		//ResultSet rs =null;
		try {
			//3.
			stmt = con.createStatement();
			
			//4.
			int res = stmt.executeUpdate(sql);
			if(res > 0) {
				System.out.println("입력 성공");
			}else {
				System.out.println("입력 실패");
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
		//5.
			try {
				stmt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	
	
	
	
	
	
	
	
	private static void update() {
		
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

		//3.
		String sql = " UPDATE DEPT "
				   + " SET DNAME = ?, LOC = ? "
				   + " WHERE DEPTNO = ? ";
	
		PreparedStatement pstm = null;
		
		try {
			//4.
			pstm = con.prepareStatement(sql);
			pstm.setString(1,  dname);
			pstm.setString(2,  loc);
			pstm.setInt(3,  deptno);
			
			int res = pstm.executeUpdate();
			if(res > 0) {
				System.out.println("수정 성공");
			} else {
				System.out.println("수정 실패");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			//5.
			try {
				pstm.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	
	}
	
	
	
	
	
	
	
	
	
	public static void delete() {
		System.out.println("조건 입력 : ");
		String wh = sc.next();
		

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


		String sql = " DROP FROM DEPT "
				   + " WHERE ? ";
	
		PreparedStatement pstm = null;
		
		try {

			pstm = con.prepareStatement(sql);
			pstm.setString(1, wh);

			int res = pstm.executeUpdate();
			if(res > 0) {
				System.out.println("입력 성공");
			} else {
				System.out.println("입력 실패");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			//5.
			try {
				pstm.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	
	}
	
	
	
	
	
	
	
	
	
	
	
}
