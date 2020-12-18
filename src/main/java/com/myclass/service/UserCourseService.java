/**
 * Dec 17, 2020
 * 1:33:30 AM
 * @author LeThien
 */
package com.myclass.service;

import java.util.List;

import com.myclass.dto.UserCourseDto;

public interface UserCourseService {
	List<UserCourseDto> getAll();
	void save(UserCourseDto dto);
}
