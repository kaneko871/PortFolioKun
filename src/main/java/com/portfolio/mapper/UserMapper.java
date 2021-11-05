package com.portfolio.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.portfolio.model.User;

@Mapper
public interface UserMapper {
	@Select("SELECT * FROM pfk_user where user_id = #{userId}")
	public User findById(@Param("userId") String userId);

}
