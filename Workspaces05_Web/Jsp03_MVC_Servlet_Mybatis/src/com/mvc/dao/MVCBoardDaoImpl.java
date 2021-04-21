package com.mvc.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.mvc.dto.MVCBoardDto;
import com.mvc.db.SqlMapConfig;

public class MVCBoardDaoImpl extends SqlMapConfig implements MVCBoardDao {
	
	private String namespace = "com.mvc.mapper.";

	@Override
	public List<MVCBoardDto> selectlist() {
		
		List<MVCBoardDto> list = new ArrayList<MVCBoardDto>();
		
		SqlSession session = null;
		
		try {
			session = getSqlSessionFactory().openSession(false);
			list = session.selectList(namespace+"selectList");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	
		return list;
	}

	@Override
	public MVCBoardDto selectOne(int seq) {
		
		SqlSession session = null;
		
		MVCBoardDto dto = new MVCBoardDto();
		
		try {
			session = getSqlSessionFactory().openSession(true);
			dto = session.selectOne(namespace+"selectOne", seq);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return dto;
	}

	@Override
	public int insert(MVCBoardDto dto) {
		int res = 0;
		
		try(SqlSession session = getSqlSessionFactory().openSession(true);){
			res = session.insert(namespace+"insert", dto);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return res;
	}

	@Override
	public int update(MVCBoardDto dto) {
		int res = 0;
		
		try(SqlSession session = getSqlSessionFactory().openSession(true);){
			res = session.insert(namespace+"update", dto);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return res;
	}

	@Override
	public int delete(int seq) {
		int res = 0;
		
		try(SqlSession session = getSqlSessionFactory().openSession(true);){
			res = session.insert(namespace+"delete", seq);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return res;
	}

	@Override
	public int multiDelete(String[] seqs) {
		int count = 0;
		
		Map<String, String[]> map = new HashMap<String, String[]>();
		map.put("seqs", seqs);
		
		try(SqlSession session = getSqlSessionFactory().openSession(false);){
			count = session.delete(namespace+"multiDelete", map);
			if(count == seqs.length) {
				session.commit();
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return count;
	}

}
