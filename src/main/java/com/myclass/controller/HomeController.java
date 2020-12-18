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

import com.myclass.dto.UserCourseDto;
import com.myclass.service.UserCourseService;

@Controller
@RequestMapping("home")
public class HomeController {
	
	private UserCourseService userCourseService;
	
	public HomeController(UserCourseService userCourseService) {
		this.userCourseService = userCourseService;
	}
	
	@RequestMapping(value="/add", method = RequestMethod.GET)
	public String add() {
		System.out.println("Loi hdjahjk");
		return "admin/user/add";	
	}
	@RequestMapping(value="", method = RequestMethod.GET)
	public String index() {
//		List<UserCourseDto> dtos = userCourseService.getAll();
//		for(UserCourseDto dto:dtos) {
//			System.out.println(dto.getUserId()+" "+dto.getCourseId()+" "+dto.getRoleId());
//		}
		
		System.out.println("Lưu 2 8 2");
		
		UserCourseDto userCourseDto = new UserCourseDto();
		userCourseDto.setUserId(2);
		userCourseDto.setCourseId(8);
		userCourseDto.setRoleId(2);
		userCourseService.save(userCourseDto);
		
//		dtos = userCourseService.getAll();
//		for(UserCourseDto dto:dtos) {
//			System.out.println(dto.getUserId()+" "+dto.getCourseId()+" "+dto.getRoleId());
//		}
		
		return "admin/home/index";
		
	}
}