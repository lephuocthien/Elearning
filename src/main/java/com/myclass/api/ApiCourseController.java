/**
 * Dec 21, 2020
 * 5:08:31 PM
 * @author LeThien
 */
package com.myclass.api;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myclass.dto.CourseDto;
import com.myclass.service.CourseService;

@RestController
@RequestMapping("api/course")
public class ApiCourseController {
	private CourseService courseService;

	/**
	 * @param courseService
	 */
	public ApiCourseController(CourseService courseService) {
		super();
		this.courseService = courseService;
	}

	// Tìm all
	@GetMapping("")
	public ResponseEntity<Object> getAll() {
		try {
			List<CourseDto> dtos = courseService.getAll();
			return new ResponseEntity<Object>(dtos, HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
		}
	}

	// Tìm theo id
	@GetMapping("get/{id}")
	public ResponseEntity<Object> getById(@PathVariable("id") int id) {
		try {
			CourseDto dto = courseService.getById(id);
			return new ResponseEntity<Object>(dto, HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
		}
	}

	// Thêm mới
	@PostMapping("add")
	public ResponseEntity<Object> add(@RequestBody CourseDto dto) {
		try {
			courseService.save(dto);
			return new ResponseEntity<Object>("Thêm thành công!", HttpStatus.CREATED);
		} catch (Exception ex) {
			return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
		}
	}

	// Cập nhật
	@PutMapping("update/{id}")
	public ResponseEntity<Object> edit(@PathVariable("id") int id, @RequestBody CourseDto dto) {
		try {
			if (courseService.getById(id) == null)
				return new ResponseEntity<Object>("Id " + id + " không tồn tại", HttpStatus.CREATED);
			courseService.edit(dto);
			return new ResponseEntity<Object>("Cập nhật thành công!", HttpStatus.CREATED);
		} catch (Exception ex) {
			return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
		}
	}

	// Xoá
	@DeleteMapping("delete/{id}")
	public ResponseEntity<Object> remove(@PathVariable("id") int id) {
		try {
			courseService.remove(id);
			return new ResponseEntity<Object>("Xoá thành công", HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
		}
	}

}
