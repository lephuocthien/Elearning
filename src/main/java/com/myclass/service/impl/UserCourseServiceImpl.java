/**
 * Dec 17, 2020
 * 1:35:08 AM
 * @author LeThien
 */
package com.myclass.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.myclass.dto.UserCourseDto;
import com.myclass.entity.UserCourse;
import com.myclass.entity.UserCourseId;
import com.myclass.repository.UserCourseRepository;
import com.myclass.service.UserCourseService;

@Service
public class UserCourseServiceImpl implements UserCourseService {
	
	private UserCourseRepository userCourseRepository;
	
	public UserCourseServiceImpl(UserCourseRepository userCourseRepository) {
		this.userCourseRepository = userCourseRepository;
	}
	@Override
	public List<UserCourseDto> getAll(){
		List<UserCourse> userCourses = userCourseRepository.findAll();
		List<UserCourseDto> dtos = new ArrayList<UserCourseDto>();
		for(UserCourse userCourse : userCourses) {
			UserCourseDto dto = new UserCourseDto();
			dto.setUserId(userCourse.getUserCourseId().getUserId());
			dto.setCourseId(userCourse.getUserCourseId().getCourseId());
			dto.setRoleId(userCourse.getRoleId());
			dtos.add(dto);
		}
		return dtos;
	}
	
	@Override
	public UserCourseDto getById(UserCourseId userCourseId) {
		UserCourse userCourse = userCourseRepository.findById(userCourseId).get();
		UserCourseDto dto = new UserCourseDto();
		dto.setUserId(userCourse.getUserCourseId().getUserId());
		dto.setCourseId(userCourse.getUserCourseId().getCourseId());
		dto.setRoleId(userCourse.getRoleId());
		return dto;
	}
	@Override
	public void save(UserCourseDto dto) {
//		userCourse.getCourse().getUserCourses().add(userCourse);
//		userCourse.getUser().getUserCourses().add(userCourse);
		//System.out.println(userCourse.getUserCourseId().getUserId()+" "+userCourse.getUserCourseId().getCourseId()+" "+userCourse.getRoleId());
		userCourseRepository.saveUserCourse(dto.getUserId(), dto.getCourseId(), dto.getRoleId());
	}
	
}
