package com.myclass.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.myclass.dto.UserDto;
import com.myclass.entity.User;
import com.myclass.repository.UserRepository;
import com.myclass.service.UserService;

@Service
@Transactional(rollbackOn = Exception.class)
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public List<UserDto> findAll() {
		List<UserDto> dtos = new ArrayList<UserDto>();
		List<User> users = userRepository.findAll();
		for (User user : users) {
			UserDto userDto = new UserDto();
			userDto.setId(user.getId());
			userDto.setEmail(user.getEmail());
			userDto.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt(12)));
			userDto.setFullname(user.getFullname());
			userDto.setAvatar(user.getAvatar());
			userDto.setPhone(user.getPhone());
			userDto.setAddress(user.getAddres());
			String desc = user.getRole().getDescription();
			userDto.setDescription(desc);
			dtos.add(userDto);
		}
		return dtos;
	}

	@Override
	public UserDto findById(int id) {
		User user = userRepository.findById(id).get();
		UserDto userDto = new UserDto();
		userDto.setId(user.getId());
		userDto.setEmail(user.getEmail());
		userDto.setFullname(user.getFullname());
		userDto.setAvatar(user.getAvatar());
		userDto.setPhone(user.getPhone());
		userDto.setAddress(user.getAddres());
		return userDto;
	}

	@Override
	public void add(UserDto dto) {
		User user = new User();
		user.setId(dto.getId());
		user.setFullname(dto.getFullname());
		user.setAddres(dto.getAddress());
		user.setAvatar(dto.getAvatar());
		user.setEmail(dto.getEmail());
		user.setPassword(BCrypt.hashpw(dto.getPassword(), BCrypt.gensalt(12)));
		user.setPhone(dto.getPhone());
		user.setRole_id(1);
		userRepository.save(user);
		
	}

	@Override
	public void update(UserDto dto) {
		User user = userRepository.findById(dto.getId()).get();
		user.setId(dto.getId());
		user.setFullname(dto.getFullname());
		user.setAddres(dto.getAddress());
		user.setAvatar(dto.getAvatar());
		user.setEmail(dto.getEmail());
		user.setPassword(BCrypt.hashpw(dto.getPassword(), BCrypt.gensalt(12)));
		user.setPhone(dto.getPhone());
		user.setRole_id(1);
		userRepository.save(user);
	}

	@Override
	public void delete(int id) {
		userRepository.deleteById(id);
	}
}
