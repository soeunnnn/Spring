package com.kh.spring.member.model.repository;

import org.apache.ibatis.annotations.Mapper;

@Mapper  //mapper어노테이션이 있어야만 mapper interface로 등록됨(root-context에서도 지정 해줘야함)
public interface MemberRepository {

	String selectPasswordByUserId(String string);

}
