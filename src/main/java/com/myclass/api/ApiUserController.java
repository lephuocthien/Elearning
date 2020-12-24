/**
 * Dec 19, 2020
 * 11:37:37 PM
 * @author LeThien
 */
package com.myclass.api;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.myclass.dto.UserDto;
import com.myclass.service.CourseService;
import com.myclass.service.UserService;

@RestController
@RequestMapping("api/user")
@CrossOrigin("*")
public class ApiUserController {
	@Autowired
	private ServletContext servletContext;
	private UserService userService;
	private CourseService courseService;

	/**
	 * @param userService
	 * @param courseService
	 */
	public ApiUserController(UserService userService, CourseService courseService) {
		super();
		this.userService = userService;
		this.courseService = courseService;
	}

	// Tìm all
	@GetMapping("")
	public ResponseEntity<Object> getAll() {
		try {
			List<UserDto> dtos = userService.getAllUserDto();
			for(int i =0 ; i<dtos.size(); i++) {
				dtos.get(i).setCourses(courseService.getAllCourseDtoByUserId(dtos.get(i).getId()));
			}
			return new ResponseEntity<Object>(dtos, HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
		}
	}

	// Tìm theo id
	@GetMapping("get/{id}")
	public ResponseEntity<Object> getById(@PathVariable("id") int id) {
		try {
			UserDto dto = userService.getById(id);
			return new ResponseEntity<Object>(dto, HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
		}
	}

	// Thêm mới
	@PostMapping("add")
	public ResponseEntity<Object> add(@RequestBody UserDto dto) {
		try {
			userService.save(dto);
			return new ResponseEntity<Object>("Thêm thành công!", HttpStatus.CREATED);
		} catch (Exception ex) {
			return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
		}
	}

	// Cập nhật
	@PutMapping("update/{id}")
	public ResponseEntity<Object> edit(@PathVariable("id") int id, @RequestBody UserDto dto) {
		try {
			if (userService.getById(id) == null)
				return new ResponseEntity<Object>("Id " + id + " không tồn tại", HttpStatus.CREATED);
			userService.edit(dto);
			return new ResponseEntity<Object>("Cập nhật thành công!", HttpStatus.CREATED);
		} catch (Exception ex) {
			return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
		}
	}

	// Xoá
	@DeleteMapping("delete/{id}")
	public ResponseEntity<Object> remove(@PathVariable("id") int id) {
		try {
			userService.remove(id);
			return new ResponseEntity<Object>("Xoá thành công", HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/paging/{pageIndex}/{pageSize}")
	public ResponseEntity<Object> getUserPaging(@PathVariable("pageIndex") int pageIndex,
			@PathVariable("pageSize") int pageSize) {

		if (pageIndex < 1 || pageSize < 1)
			return new ResponseEntity<>("Invalid parameters.", HttpStatus.BAD_REQUEST);

		Page<UserDto> results = userService.getUserRolePaging(pageIndex - 1, pageSize);

		if (results.getSize() > 0)
			return new ResponseEntity<>(results, HttpStatus.OK);
		else
			return new ResponseEntity<>("No user was found.", HttpStatus.BAD_REQUEST);

	}
	
	@GetMapping("getUserByToken")
	public Object getUserDtoByToken(){
		try {
			//Lấy thông tin user lưu trữ trong SercurityContext
			System.out.println("agajhgfjhgak");
			Object principal = SecurityContextHolder
					.getContext()
					.getAuthentication()
					.getPrincipal();
			//Ép kiểu về UserDetails
			UserDetails userDetails = (UserDetails) principal;
			System.out.println(principal);
			//Lấy ra email
			String email = userDetails.getUsername();
			System.out.println(email);
			//Lấy ra thông tin User để trả về cho client;
			UserDto dto = userService.getUserDtoByEmail(email);
			System.out.println(dto.getFullname());
			return new ResponseEntity<UserDto>(dto, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
		}
	}
	
//	@PostMapping(value="upload", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
//	@ResponseBody
//	public Object upload(@RequestParam() MultipartFile file) {
//		String pathName = servletContext.getRealPath("/resources/upload/");
//		File dir = new File(pathName);
//		if(!dir.exists())
//			dir.mkdirs();
//		
//		String pathSource = pathName +file.getOriginalFilename();
//		File serverFile = new File(pathSource);
//		FileOutputStream stream;
//		try {
//			stream = new FileOutputStream(serverFile);
//			stream.write(file.getBytes());
//			stream.close();
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch(IOException e) {
//			e.printStackTrace();
//		}
//		
//		Map<String, String> result = new HashMap<String, String>();
//		result.put("url", file.getOriginalFilename());
//		return result;
//	}
}
