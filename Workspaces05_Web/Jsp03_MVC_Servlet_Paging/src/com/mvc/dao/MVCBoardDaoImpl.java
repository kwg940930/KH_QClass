package com.mvc.dao;

import static com.mvc.db.JDBCTemplate.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mvc.dto.MVCBoardDto;

public class MVCBoardDaoImpl implements MVCBoardDao {

	@Override
	public List<MVCBoardDto> selectlist() {
		
		Connection con = getConnection();
		
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		List<MVCBoardDto> list = new ArrayList<MVCBoardDto>();
		
		try {
			pstm = con.prepareStatement(SELECT_LIST_SQL);
			rs = pstm.executeQuery();
			
			while(rs.next()) {
				MVCBoardDto dto = new MVCBoardDto();
				dto.setSeq(rs.getInt(1));
				dto.setWriter(rs.getString(2));
				dto.setTitle(rs.getString(3));
				dto.setContent(rs.getString(4));
				dto.setRegdate(rs.getDate(5));
				
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstm);
			close(con);
		}
		return list;
	}

	@Override
	public MVCBoardDto selectOne(int seq) {
		
		Connection con = getConnection();
		
		PreparedStatement pstm = null;
		ResultSet rs = null;
		MVCBoardDto dto = new MVCBoardDto();
		
		try {
			pstm = con.prepareStatement(SELECT_ONE_SQL);
			pstm.setInt(1, seq);
			rs = pstm.executeQuery();
			
			while(rs.next()) {
				dto.setSeq(rs.getInt(1));
				dto.setWriter(rs.getString(2));
				dto.setTitle(rs.getString(3));
				dto.setContent(rs.getString(4));
				dto.setRegdate(rs.getDate(5));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstm);
			close(con);
		}
		return dto;
	}

	
	@Override
	public int insert(MVCBoardDto dto) {
		
		Connection con = getConnection();
		
		PreparedStatement pstm = null;
		int res = 0;
		
		try {
			pstm = con.prepareStatement(INSERT_SQL);
			pstm.setString(1, dto.getWriter());
			pstm.setString(2, dto.getTitle());
			pstm.setString(3, dto.getContent());
			
			res = pstm.executeUpdate();
			
			if( res > 0 ) {
				commit(con);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstm);
			close(con);
		}
		
		return res;
	}

	@Override
	public int update(MVCBoardDto dto) {
		Connection con = getConnection();
		
		PreparedStatement pstm = null;
		int res = 0;
		
		try {
			pstm = con.prepareStatement(UPDATE_SQL);
			pstm.setString(1, dto.getTitle());
			pstm.setString(2, dto.getContent());
			pstm.setInt(3, dto.getSeq());
			
			res = pstm.executeUpdate();
			
			if( res > 0 ) {
				commit(con);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstm);
			close(con);
		}
		
		return res;
	}

	@Override
	public int delete(int seq) {
		Connection con = getConnection();
		
		PreparedStatement pstm = null;
		int res = 0;
		
		MVCBoardDto dto = new MVCBoardDto();
		
		try {
			pstm = con.prepareStatement(DELETE_SQL);
			pstm.setInt(1, seq);
			
			res = pstm.executeUpdate();
			
			if( res > 0 ) {
				commit(con);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstm);
			close(con);
		}
		
		return res;
	}

	
	
	@Override
	public int multiDelete(String[] seqs) {
		
		Connection con = getConnection();
		
		PreparedStatement pstm = null;
		int res = 0;
		
		int cnt [] = null;
		
		try {
			pstm = con.prepareStatement(DELETE_SQL);
			for(int i = 0; i < seqs.length; i++) {
				pstm.setString(1, seqs[i]);
				pstm.addBatch();
			}
			
			cnt = pstm.executeBatch();
			
			for(int i = 0; i <cnt.length; i++) {
				if(cnt[i] == -2) {
					res++;
				}
			}
			if(seqs.length == res) {
				commit(con);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstm);
			close(con);
		}
		
		return res;
	}
	
	// ================= select list with pagination ================= //
		public List<MVCBoardDto> selectListWPage(int startRow, int endRow) {
			Connection con = getConnection();
			PreparedStatement psmt = null;
			ResultSet rs = null;

			List<MVCBoardDto> list = new ArrayList<MVCBoardDto>();

			endRow += startRow;
			
			try {
				psmt = con.prepareStatement(SELECT_LIST_PAGING_SQL);
				psmt.setInt(1, endRow);
				psmt.setInt(2, startRow);
				rs = psmt.executeQuery();

				while (rs.next()) {
					MVCBoardDto dto = new MVCBoardDto();
					dto.setSeq(rs.getInt(1));
					dto.setWriter(rs.getString(2));
					dto.setTitle(rs.getString(3));
					dto.setContent(rs.getString(4));
					dto.setRegdate(rs.getDate(5));
					list.add(dto);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				close(rs);
				close(psmt);
				close(con);
			}
			return list;
		}

		// ================= total count for pagination ================= //
		public int getTotalCount() {
			int total = 0;

			Connection con = getConnection();
			PreparedStatement psmt = null;
			ResultSet rs = null;

			try {
				psmt = con.prepareStatement(TOTAL_COUNT_SQL);

				rs = psmt.executeQuery();

				if (rs.next()) {
					total = rs.getInt(1);
				}

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				close(rs);
				close(psmt);
				close(con);
			}
			return total;
		}

}
