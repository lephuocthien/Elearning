/**
 * Dec 17, 2020
 * 1:33:30 AM
 * @author LeThien
 */
package com.myclass.service;

import java.util.List;

import com.myclass.dto.UserCourseDto;
import com.myclass.entity.UserCourseId;

public interface UserCourseService {
	List<UserCourseDto> getAll();
	UserCourseDto getById(UserCourseId userCourseId);
	void save(UserCourseDto dto);
}
