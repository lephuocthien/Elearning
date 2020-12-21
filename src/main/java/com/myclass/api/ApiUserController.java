/**
 * Dec 19, 2020
 * 11:37:37 PM
 * @author LeThien
 */
package com.myclass.api;

import java.util.List;

import org.springframework.data.domain.Page;
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

import com.myclass.dto.UserDto;
import com.myclass.service.UserService;

@RestController
@RequestMapping("api/user")
public class ApiUserController {
	private UserService userService;

	/**
	 * @param userService
	 */
	public ApiUserController(UserService userService) {
		super();
		this.userService = userService;
	}

	// Tìm all
	@GetMapping("")
	public ResponseEntity<Object> getAll() {
		try {
			List<UserDto> dtos = userService.getAllUserDto();
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
}