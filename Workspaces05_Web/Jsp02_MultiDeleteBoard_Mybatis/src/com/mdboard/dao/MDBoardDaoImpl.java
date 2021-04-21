package com.mdboard.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.mdboard.db.SqlMapConfig;
import com.mdboard.dto.MDBoardDto;

public class MDBoardDaoImpl extends SqlMapConfig implements MDBoardDao {

	private String namespace = "com.muldel.mapper.";
	
	@Override
	public List<MDBoardDto> selectList() {
		SqlSession session = null;
		List<MDBoardDto> list = new ArrayList<MDBoardDto>();
		
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
	public MDBoardDto selectOne(int seq) {
		SqlSession session = null;
		MDBoardDto dto = new MDBoardDto();
		
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
	public int insert(MDBoardDto dto) {
		int res = 0;
		
		try(SqlSession session = getSqlSessionFactory().openSession(true);){
			res = session.insert(namespace+"insert", dto);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return res;
	}

	@Override
	public int update(MDBoardDto dto) {
		int res = 0;
		
		try(SqlSession session = getSqlSessionFactory().openSession(true);){
			res = session.update(namespace+"update", dto);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return res;
	}

	@Override
	public int delete(int seq) {
		int res = 0;
		
		try(SqlSession session = getSqlSessionFactory().openSession(true);){
			res = session.delete(namespace+"delete", seq);
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
