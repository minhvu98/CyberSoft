package com.myclass.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.myclass.dto.VideoDto;
import com.myclass.service.VideoService;

public class ApiVideoController {
	
	@Autowired
	private VideoService videoService;
	
	@GetMapping("")
	public Object get() {
		List<VideoDto> videos = videoService.findAll();
		return new ResponseEntity<Object>(videos, HttpStatus.OK);
	}
	
	@GetMapping("{id}")
	public Object get(@PathVariable("id") int id) {
		try {
			VideoDto video = videoService.findById(id);
			return new ResponseEntity<Object>(video, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>("khong tim thay du lieu!", HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping("")
	public Object post(@RequestBody VideoDto dto) {
		try {
			videoService.add(dto);
			return new ResponseEntity<String>("them thanh cong", HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<String>("them that bai!", HttpStatus.BAD_REQUEST);
		}
	}
	@PutMapping("")
	public Object put(@RequestBody VideoDto dto) {
		try {
			videoService.update(dto);
			return new ResponseEntity<String>("cap nhat thanh cong!", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("cap nhat that bai", HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/{id}")
	public Object delete(@PathVariable("id") int id) {
		try {
			videoService.delete(id);
			return new ResponseEntity<String>("Xoa thanh cong", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("Xoa that bai", HttpStatus.BAD_REQUEST);
		}
	}
}
