/**
 * Dec 30, 2020
 * 2:18:44 AM
 * @author LeThien
 */
package com.myclass.api;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myclass.dto.CourseDto;
import com.myclass.dto.UserCourseDto;
import com.myclass.entity.UserCourseId;
import com.myclass.service.UserCourseService;

@RestController
@RequestMapping("api/user-course")
public class ApiUserCourseController {
	private UserCourseService userCourseService;

	/**
	 * @param userCourseService
	 */
	public ApiUserCourseController(UserCourseService userCourseService) {
		super();
		this.userCourseService = userCourseService;
	}
	
	// Tìm theo id
			@GetMapping("get-course-by-user-id/{userId}/{courseId}")
			public ResponseEntity<Object> getUserCourseById(@PathVariable("userId") int userId,
															@PathVariable("courseId") int courseId) {
				try {
					UserCourseId id = new UserCourseId(userId,courseId);
					UserCourseDto dto = userCourseService.getById(id);
					return new ResponseEntity<Object>(dto, HttpStatus.OK);
				} catch (Exception ex) {
					return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
				}
			}
}
