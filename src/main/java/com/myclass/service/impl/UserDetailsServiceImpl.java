package com.myclass.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.myclass.dto.UserDto;
import com.myclass.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {


	private UserRepository userRepository;
	public UserDetailsServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
			}
	
	// PHƯƠNG THỨC KIỂM TRA EMAIL(USERNAME) ĐĂNG NHẬP
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		UserDto userDto = userRepository.findByEmail(email);
		if (userDto == null ) throw new UsernameNotFoundException("Email không tồn tại!");
		// Tạo danh sách chứa tên quyền
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority(userDto.getRoleName()));
		return new User(email, userDto.getPassword(), authorities);
	}

}
