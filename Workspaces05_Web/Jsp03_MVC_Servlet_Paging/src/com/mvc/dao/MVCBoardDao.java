package com.mvc.dao;

import java.util.List;

import com.mvc.dto.MVCBoardDto;

public interface MVCBoardDao {
	
	
	public String SELECT_LIST_SQL = " SELECT SEQ, WRITER, TITLE, CONTENT, REGDATE FROM MVCBOARD ORDER BY SEQ DESC ";
	public String SELECT_ONE_SQL = " SELECT SEQ, WRITER, TITLE, CONTENT, REGDATE FROM MVCBOARD WHERE SEQ = ? ";
	public String INSERT_SQL = " INSERT INTO MVCBOARD VALUES(MVCBOARDSEQ.NEXTVAL, ?, ?, ?, SYSDATE)  ";
	public String UPDATE_SQL = " UPDATE MVCBOARD SET TITLE = ?, CONTENT = ? WHERE SEQ = ? ";
	public String DELETE_SQL = " DELETE FROM MVCBOARD WHERE SEQ = ? ";
	
	public String SELECT_LIST_PAGING_SQL = " SELECT B.SEQ, B.WRITER, B.TITLE, B.CONTENT, B.REGDATE " + " FROM "
			   							 + " (SELECT ROWNUM AS RNUM, A.SEQ, A.WRITER, A.TITLE, A.CONTENT, A.REGDATE " + " FROM "
			   							 + " (SELECT SEQ, WRITER, TITLE, CONTENT, REGDATE " + " FROM MVCBOARD " 
			   							 + " ORDER BY SEQ DESC) A "
			   							 + " WHERE ROWNUM <= ? ) B " 
			   							 + " WHERE B.RNUM > ? ";
	public String TOTAL_COUNT_SQL = " SELECT COUNT(*) FROM MVCBOARD ";
	
	
	public List<MVCBoardDto> selectlist();
	public MVCBoardDto selectOne(int seq);
	public int insert(MVCBoardDto dto);
	public int update(MVCBoardDto dto);
	public int delete(int seq);
	public int multiDelete(String[] seqs);
	
	
	public List<MVCBoardDto> selectListWPage(int startRow, int endRow);
	public int getTotalCount(); 
	
	
	

}
