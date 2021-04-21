package com.login.dao;

import static com.login.db.JDBCTemplate.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.login.dto.MYMemberDto;

public class MYMemberDao {

	/*
	 * 관리자(ADMIN) 기능
	 * 1. 회원 전체 정보 확인 (탈퇴한 회원도 포함)
	 * 2. 회원 전체 정보 확인 (MYENABLED='Y' 인 -> 탈퇴안한 회원들의 정보)
	 * 3. 회원 등급 조정 (ADMIN <-> USER)
	 */
	// 1. 전체정보
	public List<MYMemberDto> selectAllUser(){
		Connection con = getConnection();
		String sql = " SELECT MYNO, MYID, MYPW, MYNAME, MYADDR, MYPHONE, MYEMAIL, MYENABLED, MYROLE "
				   + " FROM MYMEMBER "
				   + " ORDER BY MYNO DESC ";
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		List<MYMemberDto> list = new ArrayList<MYMemberDto>();
		
		try {
			pstm = con.prepareStatement(sql);
			System.out.println("3. query 준비 : " + sql);
			
			rs = pstm.executeQuery();
			System.out.println("4. query 실행 및 리턴");
			while(rs.next()) {
				MYMemberDto dto = new MYMemberDto(rs.getInt("MYNO"),
												  rs.getString("MYID"),
												  rs.getString("MYPW"),
												  rs.getString("MYNAME"),
												  rs.getString("MYADDR"),
												  rs.getString("MYPHONE"),
												  rs.getString("MYEMAIL"),
												  rs.getString("MYENABLED"),
												  rs.getString("MYROLE"));
												
						
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstm);
			close(con);
			System.out.println("5. db 종료");
		}
		
		return list;
	}
	
	
	// 2. 전체정보(탈퇴안한)
	public List<MYMemberDto> selectEnabledUser(){
		
		Connection con = getConnection();
		String sql = " SELECT MYNO, MYID, MYPW, MYNAME, MYADDR, MYPHONE, MYEMAIL, MYENABLED, MYROLE "
				   + " FROM MYMEMBER "
				   + " WHERE MYENABLED = 'Y' "
				   + " ORDER BY MYNO DESC ";
		
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		List<MYMemberDto> list = new ArrayList<MYMemberDto>();
		
		try {
			pstm = con.prepareStatement(sql);
			System.out.println("3. query 준비 : " + sql);
			rs = pstm.executeQuery();
			System.out.println("4. query 실행 및 리턴");
			
			while(rs.next()) {
				MYMemberDto dto = new MYMemberDto();
				dto.setMyno(rs.getInt("MYNO"));
				dto.setMyid(rs.getString("MYID"));
				dto.setMypw(rs.getString("MYPW"));
				dto.setMyname(rs.getString("MYNAME"));
				dto.setMyaddr(rs.getString("MYADDR"));
				dto.setMyphone(rs.getString("MYPHONE"));
				dto.setMyemail(rs.getString("MYEMAIL"));
				dto.setMyenabled(rs.getString("MYENABLED"));
				dto.setMyrole(rs.getString("MYROLE"));
				
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstm);
			close(con);
			System.out.println("5. db 종료");
		}
		return list;
	}
	
	// 3. 회원 등급 조정
	public int updateRole(int myno, String myrole) {
		
		Connection con = getConnection();
		
		PreparedStatement pstm = null;
		
		int res = 0;
		
		String sql = " UPDATE MYMEMBER SET MYROLE = ? WHERE MYNO = ? ";
		
		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, myrole);
			pstm.setInt(2, myno);
			System.out.println("3. query 준비 : " + sql);
			res = pstm.executeUpdate();
			System.out.println("4. query 실행 및 리턴");
			if(res > 0) {
				commit(con);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstm);
			close(con);
			System.out.println("5. db 종료");
		}
		
		return res;
	}
	
	/*
	 * 사용자(USER) 기능
	 * 1. 로그인
	 * 3. 회원가입 <- 2. 아이디 중복체크
	 * 4. 내 정보 조회
	 * 5. 내 정보 수정
	 * 6. 회원 탈퇴 (delete 안쓸것! update : myenabled를 n으로 바꾸자
	 */
	
	// 1. 로그인
	public MYMemberDto login(String myid, String mypw) {
		Connection con = getConnection();
		String sql = " SELECT MYNO, MYID, MYPW, MYNAME, MYADDR, MYPHONE, MYEMAIL, MYENABLED, MYROLE "
				   + " FROM MYMEMBER "
				   + " WHERE MYID = ? "
				   + " AND MYPW = ? ";
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		// side effect
		MYMemberDto dto = null;
		
		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, myid);
			pstm.setString(2, mypw);
			System.out.println("3. 쿼리 준비 : " + sql);
			
			rs = pstm.executeQuery();
			System.out.println("4. 쿼리 실행 및 리턴");
			while(rs.next()) {
				dto = new MYMemberDto();
				dto.setMyno(rs.getInt(1));
				dto.setMyid(rs.getString(2));
				dto.setMypw(rs.getString(3));
				dto.setMyname(rs.getString(4));
				dto.setMyaddr(rs.getString(5));
				dto.setMyphone(rs.getString(6));
				dto.setMyemail(rs.getString(7));
				dto.setMyenabled(rs.getString(8));
				dto.setMyrole(rs.getString(9));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstm);
			close(con);
			System.out.println("5. DB종료");
		}
		return dto;
	}


	// 2. 중복체크
	public MYMemberDto idCheck(String myid) {
		Connection con = getConnection();
		
		PreparedStatement pstm = null;
		
		ResultSet rs = null;
		
		MYMemberDto dto = new MYMemberDto();
		
		String sql = " SELECT MYNO, MYID, MYPW, MYNAME, MYADDR, MYPHONE, MYEMAIL, MYENABLED, MYROLE FROM MYMEMBER WHERE MYID = ? ";
		
		
		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, myid);
			System.out.println("3. query 준비 : " + sql);
			rs = pstm.executeQuery();
			System.out.println("4. query 실행 및 리턴");
			while(rs.next()) {
				dto.setMyno(rs.getInt(1));
				dto.setMyid(rs.getString(2));
				dto.setMypw(rs.getString(3));
				dto.setMyname(rs.getString(4));
				dto.setMyaddr(rs.getString(5));
				dto.setMyphone(rs.getString(6));
				dto.setMyemail(rs.getString(7));
				dto.setMyenabled(rs.getString(8));
				dto.setMyrole(rs.getString(9));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstm);
			close(con);
			System.out.println("5. db종료");
		}
		
		return dto;
	}
	
	// 3. 회원가입
	public int insertUser(MYMemberDto dto) {
		
		Connection con = getConnection();
		
		PreparedStatement pstm = null;
		int res = 0;
		
		String sql = " INSERT INTO MYMEMBER VALUES(MYMEMBERSEQ.NEXTVAL, ?, ?, ?, ?, ?, ?, 'Y', 'USER') ";
		
		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, dto.getMyid());
			pstm.setString(2, dto.getMypw());
			pstm.setString(3, dto.getMyname());
			pstm.setString(4, dto.getMyaddr());
			pstm.setString(5, dto.getMyphone());
			pstm.setString(6, dto.getMyemail());
			System.out.println("3. query 준비 : " + sql);
			
			res = pstm.executeUpdate();
			System.out.println("4. query 실행 및 리턴");
			
			if ( res > 0) {
				commit(con);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstm);
			close(con);
			System.out.println("5. db 종료");
		}
		return res;
	}
	
	
	// 4. 정보 조회
	public MYMemberDto selectUser(int myno) {
		
		Connection con = getConnection();
		
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		String sql = " SELECT MYNO, MYID, MYPW, MYNAME, MYADDR, MYPHONE, MYEMAIL, MYENABLED, MYROLE "
				   + " FROM MYMEMBER "
				   + " WHERE MYNO = ? ";
		MYMemberDto dto = null;
		try {
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, myno);
			System.out.println("3. query 준비 : " + sql);
			rs = pstm.executeQuery();
			System.out.println(" 4. query 실행 및 리턴");
			while(rs.next()) {
				dto = new MYMemberDto();
				dto.setMyno(rs.getInt(1));
				dto.setMyid(rs.getString(2));
				dto.setMypw(rs.getString(3));
				dto.setMyname(rs.getString(4));
				dto.setMyaddr(rs.getString(5));
				dto.setMyphone(rs.getString(6));
				dto.setMyemail(rs.getString(7));
				dto.setMyenabled(rs.getString(8));
				dto.setMyrole(rs.getString(9));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstm);
			close(con);
			System.out.println("5. db 종료");
		}
		
		
		return dto;
	}
	
	// 5. 정보 수정
	public int updateUser(MYMemberDto dto) {
		
		Connection con = getConnection();
		
		PreparedStatement pstm = null;
		String sql = " UPDATE MYMEMBER SET MYPW = ?, MYNAME = ?, MYADDR = ?, MYPHONE = ?, MYEMAIL = ? WHERE MYNO = ? ";
		int res = 0;
		
		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, dto.getMypw());
			pstm.setString(2, dto.getMyname());
			pstm.setString(3, dto.getMyaddr());
			pstm.setString(4, dto.getMyphone());
			pstm.setString(5, dto.getMyemail());
			pstm.setInt(6, dto.getMyno());
			System.out.println("3. query 준비 : " + sql);
			res = pstm.executeUpdate();
			System.out.println("4. query 실행 및 리턴");
			if( res > 0) {
				commit(con);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstm);
			close(con);
			System.out.println("5. db 종료");
		}
		
		
		return res;
	}
	
	// 6. 회원 탈퇴(update)
	public int deleteUser(int myno) {
		
		Connection con = getConnection();
		PreparedStatement pstm = null;
		int res = 0;
		
		String sql = " UPDATE MYMEMBER SET MYENABLED = 'N' WHERE MYNO = ? ";
		
		try {
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, myno);
			System.out.println("3. query 준비 : " + sql);
			res = pstm.executeUpdate();
			System.out.println("4. query 실행 및 리턴");
			if(res > 0) {
				commit(con);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstm);
			close(con);
		System.out.println("5. db 종료");
		}
		
		return res;
	}
}
