package com.portfolio.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.portfolio.model.User;

@Mapper
public interface UserMapper {
	@Select("SELECT * FROM pfk_user where user_id = #{userId}")
	public User findById(@Param("userId") String userId);

	@Insert("insert into pfk_user(user_id, password) values (#{userId},#{password})")
	public int insertUser(User user);

}
