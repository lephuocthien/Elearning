/**
 * Dec 10, 2020
 * 9:07:31 PM
 * @author LeThien
 */
package com.myclass.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("home")
public class HomeController {
	@RequestMapping(value="/add", method = RequestMethod.GET)
	public String add() {
		System.out.println("Loi hdjahjk");
		return "admin/user/add";	
	}
	@RequestMapping(value="", method = RequestMethod.GET)
	public String index() {
		System.out.println("Loi");
		return "user/profile/index";
		
	}
}