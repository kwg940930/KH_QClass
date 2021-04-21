package com.board.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.board.db.SqlMapConfig;
import com.board.dto.MyBoardDto;

// 해당 코드에서는 에외처리를 할 필요가 없으나 예외처리를 해 주었음
public class MyBoardDao extends SqlMapConfig{
	
	//전체출력
	public List<MyBoardDto> selectList() {
		SqlSession session = null;
		
		List<MyBoardDto> list = new ArrayList<MyBoardDto>();
		
		// SqlSession 객체를 얻을 때 openSession(true)와 같이 호출하면 
		// INSERT, UPDATE, DELETE문 실행 시 auto commit을 수행하는 SqlSession 객체를 얻을 수 있다.
		session = getSqlSessionFactory().openSession(true);
		list = session.selectList("boardmapper.selectList");
		
		session.close();
		
		return list;
	}
	
	//하나출력
	public MyBoardDto selectOne(int seq) {
		
		SqlSession session = null;
		
		MyBoardDto dto = new MyBoardDto();
		
		try {
			session = getSqlSessionFactory().openSession(true);
			dto = session.selectOne("boardmapper.selectOne", seq);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		} 
		return dto;
	}
	
	//추가
	public int insert(MyBoardDto dto) {
		int res = 0;
		
		// try with resources
		try(SqlSession session = getSqlSessionFactory().openSession(true);){
			res = session.insert("boardmapper.insert", dto);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}
	
	//수정
	public int update(MyBoardDto dto) {
		int res = 0;
		
		try(SqlSession session = getSqlSessionFactory().openSession(true);){
			res = session.insert("boardmapper.update", dto);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}
	
	//삭제
	public int delete(int seq) {
		int res = 0;
		
		try(SqlSession session = getSqlSessionFactory().openSession(true);){
			res = session.delete("boardmapper.delete", seq);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}
}
