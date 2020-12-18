/**
 * Dec 18, 2020
 * 4:11:40 PM
 * @author LeThien
 */
package com.myclass.service;

import java.util.List;

import com.myclass.dto.UserDto;

public interface UserService {
	List<UserDto> getAll();
	UserDto getById(int id);
	void save(UserDto dto);
	void edit(UserDto dto);
	void remove(int id);
}
