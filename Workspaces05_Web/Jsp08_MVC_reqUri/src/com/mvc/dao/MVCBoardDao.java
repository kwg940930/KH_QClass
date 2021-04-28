package com.mvc.dao;

import java.util.List;

import com.mvc.dto.MVCBoardDto;

public interface MVCBoardDao {
	
	
	public String SELECT_LIST_SQL = " SELECT SEQ, WRITER, TITLE, CONTENT, REGDATE FROM MVCBOARD ORDER BY SEQ DESC ";
	public String SELECT_ONE_SQL = " SELECT SEQ, WRITER, TITLE, CONTENT, REGDATE FROM MVCBOARD WHERE SEQ = ? ";
	public String INSERT_SQL = " INSERT INTO MVCBOARD VALUES(MVCBOARDSEQ.NEXTVAL, ?, ?, ?, SYSDATE)  ";
	public String UPDATE_SQL = " UPDATE MVCBOARD SET TITLE = ?, CONTENT = ? WHERE SEQ = ? ";
	public String DELETE_SQL = " DELETE FROM MVCBOARD WHERE SEQ = ? ";
	
	
	public List<MVCBoardDto> selectlist();
	public MVCBoardDto selectOne(int seq);
	public int insert(MVCBoardDto dto);
	public int update(MVCBoardDto dto);
	public int delete(int seq);
	public int multidelete(String seqs []);
	
	

}
