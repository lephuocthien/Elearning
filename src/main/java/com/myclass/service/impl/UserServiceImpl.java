/**
 * Dec 18, 2020
 * 4:14:38 PM
 * @author LeThien
 */
package com.myclass.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.myclass.dto.UserDto;
import com.myclass.entity.User;
import com.myclass.repository.UserRepository;
import com.myclass.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	private UserRepository userRepository;
	
	/**
	 * @param userRepository
	 */
	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@Override
	public List<UserDto> getAll() {
		List<User> users = userRepository.findAll();
		System.out.println("ABC");
		List<UserDto> dtos = new ArrayList<UserDto>();
		for (User user : users) {
			UserDto dto = new UserDto();
			dto.setId(user.getId());
			dto.setEmail(user.getEmail());
			dto.setPassword(user.getPassword());
			dto.setFullname(user.getFullname());
			dto.setPhone(user.getPhone());
			dto.setAddress(user.getAddress());
			dto.setAvatar(user.getAvatar());
			dto.setRoleId(user.getRoleId());
			dtos.add(dto);
		}
		return dtos;
	}

	@Override
	public UserDto getById(int id) {
		UserDto dto = new UserDto();
		User user = userRepository.findById(id).get();
		dto.setId(user.getId());
		dto.setEmail(user.getEmail());
		dto.setPassword(user.getPassword());
		dto.setFullname(user.getFullname());
		dto.setPhone(user.getPhone());
		dto.setAddress(user.getAddress());
		dto.setAvatar(user.getAvatar());
		dto.setRoleId(user.getRoleId());
		return dto;
	}

	@Override
	public void save(UserDto dto) {
		User user = new User();
		user.setEmail(dto.getEmail());
		user.setPassword(dto.getPassword());
		user.setFullname(dto.getFullname());
		user.setPhone(dto.getPhone());
		user.setAddress(dto.getAddress());
		user.setAvatar(dto.getAvatar());
		user.setRoleId(dto.getRoleId());
		userRepository.save(user);
		
	}

	@Override
	public void edit(UserDto dto) {
		User user = userRepository.findById(dto.getId()).get();
		if (user != null) {
			user.setEmail(dto.getEmail());
			user.setPassword(dto.getPassword());
			user.setFullname(dto.getFullname());
			user.setPhone(dto.getPhone());
			user.setAddress(dto.getAddress());
			user.setAvatar(dto.getAvatar());
			user.setRoleId(dto.getRoleId());
			userRepository.save(user);
		}
		
	}

	@Override
	public void remove(int id) {
		// TODO Auto-generated method stub
		userRepository.deleteById(id);
	}

}
