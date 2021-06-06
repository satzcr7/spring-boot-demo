package com.springboot.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {
	
	@RequestMapping(value="/")
	@ResponseBody
	public String greetingsAdmin() {
		return "<h2>Hello Admin User</h2>";
	}
	
}
