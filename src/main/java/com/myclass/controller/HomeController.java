/**
 * Dec 10, 2020
 * 9:07:31 PM
 * @author LeThien
 */
package com.myclass.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.myclass.dto.RoleDto;
import com.myclass.dto.UserCourseDto;
import com.myclass.dto.UserDto;
import com.myclass.service.RoleService;
import com.myclass.service.UserCourseService;
import com.myclass.service.UserService;

@Controller
@RequestMapping("home")
public class HomeController {
	
	private UserCourseService userCourseService;
	private RoleService roleService;
	private UserService userService;
	
	public HomeController(UserCourseService userCourseService,
			RoleService roleService,
			UserService userService) {
		this.userCourseService = userCourseService;
		this.roleService = roleService;
		this.userService = userService;
	}
	
	@RequestMapping(value="/add", method = RequestMethod.GET)
	public String add() {
		System.out.println("Loi hdjahjk");
		return "admin/user/add";	
	}
	@RequestMapping(value="", method = RequestMethod.GET)
	public String index() {

		UserDto dto = new UserDto();
		dto.setId(11);
		dto.setEmail("lethen123@gmail.com");
		dto.setPassword("1234");
		dto.setFullname("Lê Phước Thiện");
		dto.setPhone("5426395");
		dto.setAddress("abc-xyz");
		dto.setRoleId(1);
		dto.setAvatar("avatar");
		userService.edit(dto);
		
		UserDto userDto = userService.getById(11);
		System.out.println(userDto.getId()+" "+
		userDto.getEmail()+" "+
		userDto.getPassword()+" "+
		userDto.getFullname()+" "+
		userDto.getPhone()+" "+
		userDto.getAddress()+" "+
		userDto.getRoleId()+" "+
		userDto.getAvatar());
		
//		List<UserDto> dtos = userService.getAll();
//		for(UserDto userDto:dtos) {
//			System.out.println(userDto.getId()+" "+
//					userDto.getEmail()+" "+
//					userDto.getPassword()+" "+
//					userDto.getFullname()+" "+
//					userDto.getPhone()+" "+
//					userDto.getAddress()+" "+
//					userDto.getRoleId()+" "+
//					userDto.getAvatar());
//		}
//		System.out.println(dto.getId()+" "+dto.getName()+" "+dto.getDescription());
		
		
//		System.out.println("Lưu 2 8 2");
//		
//		UserCourseDto userCourseDto = new UserCourseDto();
//		userCourseDto.setUserId(2);
//		userCourseDto.setCourseId(8);
//		userCourseDto.setRoleId(2);
//		userCourseService.save(userCourseDto);
		
//		dtos = userCourseService.getAll();
//		for(UserCourseDto dto:dtos) {
//			System.out.println(dto.getUserId()+" "+dto.getCourseId()+" "+dto.getRoleId());
//		}
		
		return "admin/home/index";
		
	}
}