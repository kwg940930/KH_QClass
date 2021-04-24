package com.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.db.SqlMapConfig;
import com.dto.Dto;

public class Dao extends SqlMapConfig {
	
	public List<Dto> listPaging(int startRow, int endRow) {
		List<Dto> list = new ArrayList<Dto>();
		endRow += startRow;
		
		Map<String, Object> map = new HashMap<>();
		
		map.put("startRow", startRow);
		map.put("endRow", endRow);
		
		System.out.println(map);
		
		try(SqlSession session = getSqlSessionFactory().openSession(true);){
			list = session.selectList("mapper.listPaging", map);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		return list;
	}
	
	public int getTotalCount() {
		SqlSession session = null;

		int res = 0;
		
		try {
			session = getSqlSessionFactory().openSession(true);
			res = session.selectOne("mapper.getTotalCount");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	
		return res;
	}

}
