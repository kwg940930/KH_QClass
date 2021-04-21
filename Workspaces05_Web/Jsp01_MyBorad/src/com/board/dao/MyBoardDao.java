package com.board.dao;

import static com.board.db.JDBCTemplate.*;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.board.dto.MyBoardDto;

public class MyBoardDao {
	
	public List<MyBoardDto> selectList() {
		
		List<MyBoardDto> list = new ArrayList<MyBoardDto>();
		
		Connection con = getConnection();
		String sql = " SELECT SEQ, WRITER, TITLE, CONTENT, REGDATE FROM MYBOARD ORDER BY SEQ DESC ";
				
				PreparedStatement pstm = null;
				ResultSet rs = null;
				
				try {
					pstm = con.prepareStatement(sql);
					rs = pstm.executeQuery();
					
					while(rs.next()) {
						MyBoardDto dto = new MyBoardDto();
						dto.setSeq(rs.getInt("SEQ"));
						dto.setWriter(rs.getString("WRITER"));
						dto.setTitle(rs.getString("TITLE"));
						dto.setContent(rs.getString("CONTENT"));
						dto.setRegdate(rs.getDate("REGDATE"));
					
						list.add(dto);
					}
					
				} catch (SQLException e) {
					e.printStackTrace();
				}finally {
					close(rs);
					close(pstm);
					close(con);
				}
				
		return list;
	}
	
	
	
	
	
	public MyBoardDto selectOne(int seq) {
		Connection con = getConnection();
		String sql = " SELECT SEQ, WRITER, TITLE, CONTENT, REGDATE FROM MYBOARD WHERE SEQ = ? ";
				
				PreparedStatement pstm = null;
				ResultSet rs = null;
				
				MyBoardDto dto = new MyBoardDto();
				
				try {
					pstm = con.prepareStatement(sql);
					pstm.setInt(1, seq);
					rs = pstm.executeQuery();
					
					while(rs.next()) {
						dto.setSeq(rs.getInt("SEQ"));
						dto.setWriter(rs.getString("WRITER"));
						dto.setTitle(rs.getString("TITLE"));
						dto.setContent(rs.getString("CONTENT"));
						dto.setRegdate(rs.getDate("REGDATE"));
					}
					
				} catch (SQLException e) {
					e.printStackTrace();
				}finally {
					close(rs);
					close(pstm);
					close(con);
				}
		return dto;
	}
	
	
	
	
	public int insert(MyBoardDto dto) {
		Connection con = getConnection();
		
		String sql = " INSERT INTO MYBOARD VALUES(MYBOARDSEQ.NEXTVAL, ?, ?, ?, SYSDATE) ";
		PreparedStatement pstm = null;
		int res = 0;
		
		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, dto.getWriter());
			pstm.setString(2, dto.getTitle());
			pstm.setString(3, dto.getContent());
			
			res = pstm.executeUpdate();
			if( res > 0) {
				commit(con);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstm);
			close(con);
		}
		return res;
	}
	
	
	
	
	
	public int update(MyBoardDto dto) {
		Connection con = getConnection();
		
		String sql = " UPDATE MYBOARD SET TITLE = ?, CONTENT = ? WHERE SEQ = ? ";
		PreparedStatement pstm = null;
		int res = 0;
		
		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, dto.getTitle());
			pstm.setString(2, dto.getContent());
			pstm.setInt(3, dto.getSeq());
			
			res = pstm.executeUpdate();
			if( res > 0) {
				commit(con);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstm);
			close(con);
		}
		return res;
	}
	
	
	
	
	
	
	
	public int delete(MyBoardDto dto) {
		Connection con = getConnection();
		PreparedStatement pstm = null;
		String sql = " DELETE FROM MYBOARD "
				   + " WHERE SEQ = ? ";
		int res = 0;
		
		try {
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, dto.getSeq());
		
			res = pstm.executeUpdate();
			if(res > 0) {
				commit(con);
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstm);
			close(con);
		}
		
		return res;
	}
}
