package com.portfolio.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.portfolio.model.PfkUser;
import com.portfolio.service.UserService;


@Service
public class UserDetailsServiceImpl implements UserDetailsService{

	@Autowired
	private UserService service;

	/* Spring SecurityのUserDertails機能を利用する。*/
	@Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException{
    	PfkUser loginUser = service.getLoginUser(userId);

    	if(loginUser == null) {
    		throw new UsernameNotFoundException("user not found");
    	}

        // 権限List作成
        GrantedAuthority authority = new SimpleGrantedAuthority("USER");
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(authority);

    	UserDetails userDetails = (UserDetails) new User((String)loginUser.getUserId(),
    			(String)loginUser.getPassword(), authorities);

    	return userDetails;
    }


}
