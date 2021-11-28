package com.portfolio.repository;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.portfolio.model.PfkUser;

@Mapper
public interface UserMapper {
	@Select("SELECT * FROM pfk_user where user_id = #{userId}")
	public PfkUser findById(@Param("userId") String userId);

	@Insert("insert into pfk_user(user_id, password) values (#{userId},#{password})")
	public int insertUser(PfkUser user);

}
