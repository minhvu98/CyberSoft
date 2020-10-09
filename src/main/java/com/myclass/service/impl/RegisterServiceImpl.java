package com.myclass.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.myclass.dto.UserDto;
import com.myclass.entity.User;
import com.myclass.repository.RegisterRepository;
import com.myclass.service.RegisterService;

@Service
@Transactional(rollbackOn = Exception.class)
public class RegisterServiceImpl implements RegisterService{

	@Autowired
	 private RegisterRepository registerRepository;
	
	@Override
	public void register(UserDto dto) {
		User user = new User();
		user.setId(dto.getId());
		user.setFullname(dto.getFullname());
		user.setAddres(dto.getAddress());
		user.setAvatar(dto.getAvatar());
		user.setEmail(dto.getEmail());
		user.setPassword(BCrypt.hashpw(dto.getPassword(), BCrypt.gensalt(12)));
		user.setPhone(dto.getPhone());
		user.setRole_id(1);
		registerRepository.save(user);
	}
	
}
