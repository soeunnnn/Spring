package com.kh.spring.mybatis;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.kh.spring.member.model.dto.Member;

@Mapper
public interface MybatisRepository {
	
	//쿼리가 간단한 부분은 인터페이스에서 어노테이션으로 사용하는게 나음(?)
	@Select("select password from member where user_id = #{userId}")
	String selectPasswordByUserId(String userId);
	
	@Select("select * from member where user_id = #{userId}")
	Member selectMemberByUserId(String userId);
	
	@Select("select * from member inner join rent_master using(user_id) where user_id = #{userId}")
	List<Map<String,Object>> selectRentAndMemberByUserId(String userId);
	
	//쿼리가 복잡한 경우에는 Mapper에 쿼리 작성하고, 인터페이스에는 메서드만 작성 (메서드명과 쿼리 id 는 같아야함)
	List<Map<String,Object>> selectRentBookByUserId(String userId);
	
	int insertWithDto(@Param("userId") String userId, @Param("password")String password, @Param("tell")String tell, @Param("email")String email);
	
	@Delete("delete from rent_master where user_id = #{userId}")
	int delete(String userId);

	@Update("update member set password = #{password} where user_id = #{userId}")
	int update(Member member);
	
	int procedureUseTypeHandler(String userId, String title, int rentBookCnt, String bkIdxs);
	
	int test01(String title, String author);
	
	List<Map<String,Object>> dynamicIf(String filter, String keyword);
	
	List<Map<String, Object>> dynamicChoose(String keyword);
	
}
