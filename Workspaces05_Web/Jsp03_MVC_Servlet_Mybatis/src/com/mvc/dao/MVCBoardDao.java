package com.mvc.dao;

import java.util.List;

import com.mvc.dto.MVCBoardDto;

public interface MVCBoardDao {
	
	public List<MVCBoardDto> selectlist();
	public MVCBoardDto selectOne(int seq);
	public int insert(MVCBoardDto dto);
	public int update(MVCBoardDto dto);
	public int delete(int seq);
	public int multiDelete(String[] seqs);
	
	
	

}
