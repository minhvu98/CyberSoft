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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myclass.dto.TargetDto;
import com.myclass.service.TargetService;

@RestController
@RequestMapping("api/target")
public class ApiTargetController {

	@Autowired
	private TargetService targetService;
	
	@GetMapping("")
	public Object get() {
		List<TargetDto> targets = targetService.findAll();
		return new ResponseEntity<Object>(targets, HttpStatus.OK);
	}
	
	@GetMapping("{id}")
	public Object get(@PathVariable("id") int id) {
		try {
			TargetDto target = targetService.findById(id);
			return new ResponseEntity<Object>(target, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>("Khong tim thay du lieu!", HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping("")
	public Object post(@RequestBody TargetDto dto) {
		try {
			targetService.add(dto);
			return new ResponseEntity<String>("them thanh cong!", HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<String>("them that bai", HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping("")
	public Object put(@RequestBody TargetDto dto) {
		try {
			targetService.update(dto);
			return new ResponseEntity<String>("Cap nhat thanh cong!", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("Cap nhat that bai", HttpStatus.OK);
		}
	}
	
	@DeleteMapping("/{id}")
	public Object delete(@PathVariable("id") int id) {
		try {
			targetService.delete(id);
			return new ResponseEntity<String>("Xoa thanh cong!", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("Xoa that bai", HttpStatus.OK);
		}
	}

}
