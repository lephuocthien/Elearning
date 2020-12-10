/**
 * Dec 10, 2020
 * 9:00:24 PM
 * @author LeThien
 */
package com.myclass.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("login")
public class LoginController {
	@RequestMapping(value="", method = RequestMethod.GET)
	public String index() {
		return "admin/login/index";
	}
}
