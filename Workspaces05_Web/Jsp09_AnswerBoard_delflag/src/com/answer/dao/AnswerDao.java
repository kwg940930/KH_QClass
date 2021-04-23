package com.answer.dao;

import java.util.List;

import com.answer.dto.AnswerDto;

public interface AnswerDao {
	
    String SELECT_LIST_SQL = " SELECT BOARDNO, GROUPNO, GROUPSEQ, TITLETAB, DELFLAG, TITLE, CONTENT, WRITER, REGDATE FROM ANSWERBOARD02 ORDER BY GROUPNO DESC, GROUPSEQ ";
    String SELECT_ONE_SQL = " SELECT BOARDNO, GROUPNO, GROUPSEQ, TITLETAB, DELFLAG, TITLE, CONTENT, WRITER, REGDATE FROM ANSWERBOARD02 WHERE BOARDNO = ? ";
	String BOARD_INSERT_SQL = " INSERT INTO ANSWERBOARD02 "
							+ " VALUES(BOARDNOSEQ02.NEXTVAL, GROUPNOSEQ02.NEXTVAL, 1, 0, 'N', ?, ?, ?, SYSDATE) ";
	String BOARD_UPDATE_SQL = " UPSATE ANSWERBOARD02 "
							+ " SET TITLE = ?, CONTENT = ? "
							+ " WHERE BOARDNO = ? ";
    String BOARD_DELETE_SQL = " UPDATE ANSWERBOARD02 "
    						+ " SET DELFLAG = 'Y' "
    						+ " WHERE BOARDNO = ? ";
    String ANSWER_UPDATE_SQL = " UPDATE ANSWERBOARD02 "
    						 + " SET GROUPSEQ = GROUPSEQ + 1 "
    						 + " WHERE GROUPNO = (SELECT GROUPNO FROM ANSWERBOARD02 WHERE BOARDNO = ?) "
    						 + " AND GROUPSEQ > (SELECT GROUPSEQ FROM ANSWERBOARD02 WHERE BOARDNO = ?) ";
 	String ANSWER_INSERT_SQL = " INSERT INTO ANSWERBOARD02 "
 							 + " VALUES(BOARDNOSEQ02.NEXTVAL, "
 							 + " (SELECT GROUPNO FROM ANSWERBOARD02 WHERE BOARDNO = ?), "
 							 + " (SELECT GROUPSEQ FROM ANSWERBOARD02 WHERE BOARDNO = ?) + 1, "
 							 + " (SELECT TITLETAB FROM ANSWERBOARD02 WHERE BOARDNO = ?) + 1, "
 							 + " 'N', ?, ?, ?, SYSDATE) ";
 	
    public List<AnswerDto> selectList();
    public AnswerDto selectOne(int boardno);
    public boolean boardInsert(AnswerDto dto);
    public boolean boardUpdate(AnswerDto dto);
    public boolean boardDelete(int boardno);
    
    public int answerUpdate(int parentBoardNo);
    public int answerInsert(AnswerDto dto);
}
