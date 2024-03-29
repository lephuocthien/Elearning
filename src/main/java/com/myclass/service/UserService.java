/**
 * Dec 18, 2020
 * 4:11:40 PM
 * @author LeThien
 */
package com.myclass.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;

import com.myclass.dto.UserDto;
import com.myclass.entity.User;

public interface UserService {
	List<UserDto> getAll();

	List<UserDto> getAllUserDto();
	
	List<UserDto> getAllUserDtoOfCourseByTeacher(int courseId);
	
	UserDto getById(int id);
	
	UserDto getUserDtoById(int id);
	
	UserDto getUserDtoByEmail(String email);
	
	void save(UserDto dto);

	void edit(UserDto dto);

	void remove(int id);

	Page<User> getUserPaging(int pageIndex, int pageSize);

	Page<UserDto> getUserRolePaging(int pageIndex, int pageSize);
	
	
}
