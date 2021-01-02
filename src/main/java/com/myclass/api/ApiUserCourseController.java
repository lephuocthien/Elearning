/**
 * Dec 30, 2020
 * 2:18:44 AM
 * @author LeThien
 */
package com.myclass.api;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myclass.dto.UserCourseDto;
import com.myclass.entity.UserCourseId;
import com.myclass.service.UserCourseService;
import com.myclass.service.UserService;

@RestController
@RequestMapping("api/user-course")
public class ApiUserCourseController {
	private UserCourseService userCourseService;
	private UserService userService;

	

	/**
	 * @param userCourseService
	 * @param userService
	 */
	public ApiUserCourseController(UserCourseService userCourseService, UserService userService) {
		super();
		this.userCourseService = userCourseService;
		this.userService = userService;
	}

	// Tìm theo id
	@GetMapping("get-course-by-user-id/{userId}/{courseId}")
	public ResponseEntity<Object> getUserCourseById(@PathVariable("userId") int userId,
			@PathVariable("courseId") int courseId) {
		try {
			UserCourseId id = new UserCourseId(userId, courseId);
			UserCourseDto dto = userCourseService.getById(id);
			return new ResponseEntity<Object>(dto, HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
		}
	}
	
	//Thêm mới
	@PostMapping("add")
	public ResponseEntity<Object> add(@RequestBody UserCourseDto userCourseDto){
		try {
//			userCourseDto.setRoleId(userService.getById(userCourseDto.getUserId()).getRoleId());
			userCourseService.save(userCourseDto);
			return new ResponseEntity<Object>("Thêm thành công!", HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
		}
	}

}
