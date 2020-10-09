package com.myclass.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myclass.dto.UserDto;
import com.myclass.service.RegisterService;

@RestController
@RequestMapping("api/register")
public class ApiRegisterController {

	@Autowired
	private RegisterService registerService;
	
	@PostMapping("")
	public Object post(@RequestBody UserDto dto) {
		try {
			registerService.register(dto);
			return new ResponseEntity<String>("them thanh cong!", HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<String>("them that bai!", HttpStatus.BAD_REQUEST);
		}
	}
}
