package com.mdboard.dao;

import java.util.List;

import com.mdboard.dto.MDBoardDto;

public interface MDBoardDao {
	
	public String SELECT_LIST_SQL = " SELECT SEQ, WRITER, TITLE, CONTENT, REGDATE FROM MDBOARD ORDER BY SEQ DESC ";
	public String SELECT_ONE_SQL = " SELECT SEQ, WRITER, TITLE, CONTENT, REGDATE FROM MDBOARD WHERE SEQ = ? ";
	public String INSERT_SQL = " INSERT INTO MDBOARD VALUES(MDBOARDSEQ.NEXTVAL, ?, ?, ?, SYSDATE) ";
	public String UPDATE_SQL = " UPDATE MDBOARD SET TITLE = ?, CONTENT = ? WHERE SEQ = ? ";
	public String DELETE_SQL = " DELETE FROM MDBOARD WHERE SEQ = ? ";
	
	public List<MDBoardDto> selectlist();
	public MDBoardDto selectOne(int seq);
	public int insert(MDBoardDto dto);
	public int update(MDBoardDto dto);
	public int delete(int seq);
	public int multiDelete(String seqs []);
	
	

}
