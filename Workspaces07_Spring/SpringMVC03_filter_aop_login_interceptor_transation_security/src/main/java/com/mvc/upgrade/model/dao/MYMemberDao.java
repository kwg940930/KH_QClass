package com.mvc.upgrade.model.dao;

import java.util.List;

import com.mvc.upgrade.model.dto.MYMemberDto;

public interface MYMemberDao {
	
	String NAMESPACE = "mymember.";
	
	public MYMemberDto login(MYMemberDto dto);
	public int registRes(MYMemberDto dto);

}
