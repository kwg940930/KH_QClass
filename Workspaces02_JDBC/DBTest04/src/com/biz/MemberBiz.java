package com.biz;

import java.util.List;

import com.dto.MemberDto;

public interface MemberBiz {
	
	public List<MemberDto> selectList();
	public MemberDto selectOne(int m_no);
	public int insert(MemberDto dto);
	public int update(MemberDto dti);
	public int delete(int m_no);
	

}
