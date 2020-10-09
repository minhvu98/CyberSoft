package com.myclass.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myclass.dto.RoleDto;
import com.myclass.entity.Role;
import com.myclass.repository.RoleRepository;
import com.myclass.service.RoleService;

@Service
@Transactional(rollbackOn = Exception.class)
public class RoleServiceImpl implements RoleService{

	@Autowired
	RoleRepository roleRepository;
	
	@Override
	public List<RoleDto> findAll() {
		List<RoleDto> dtos = new ArrayList<RoleDto>();
		List<Role> roles = roleRepository.findAll();
		for (Role role : roles) {
			dtos.add(new RoleDto(role.getId(), role.getName(), role.getDescription()));
		}
		return dtos;
	}

	@Override
	public RoleDto findById(int id) {
		Role role = roleRepository.findById(id).get();
		return new RoleDto(role.getId(), role.getName(), role.getDescription());
	}

	@Override
	public void add(RoleDto dto) {
		Role role = new Role();
		role.setId(dto.getId());
		role.setName(dto.getName());
		role.setDescription(dto.getDescription());
		roleRepository.save(role);
	}

	@Override
	public void update(RoleDto dto) {
		Role role = roleRepository.findById(dto.getId()).get();
		role.setId(dto.getId());
		role.setName(dto.getName());
		role.setDescription(dto.getDescription());
		roleRepository.save(role);
	}

	@Override
	public void delete(int id) {
		roleRepository.deleteById(id);
		
	}

}
