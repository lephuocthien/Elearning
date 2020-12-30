/**
 * Dec 18, 2020
 * 6:24:42 PM
 * @author LeThien
 */
package com.myclass.service;

import java.util.List;

import com.myclass.dto.CourseDto;

public interface CourseService {
	List<CourseDto> getAll();
	List<CourseDto> getAllCourseDto();
	List<CourseDto> getAllCourseDtoByUserId(int id);
	CourseDto getById(int id);
	CourseDto getDtoById(int id);
	void save(CourseDto dto);
	void edit(CourseDto dto);
	void remove(int id);
}
