package com.kh.spring.member.model.repository;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository //이 클래스를 applicationContext에 등록, 발생하는 sql이셉션을 data이셉션으로 바꿔줌
public class MemberRepository {

	@Autowired
	private SqlSessionTemplate session;
	
	public String selectPasswordByUserId(String userId) { //변수명과 mybatisMapper의 #{userId} 와 같아야함
		return session.selectOne("com.kh.spring.mybatis.MybatisMapper.selectPasswordByUserId", userId);
	}

}
