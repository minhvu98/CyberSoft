package com.myclass.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myclass.dto.TargetDto;
import com.myclass.entity.Target;
import com.myclass.repository.TargetRepository;
import com.myclass.service.TargetService;

@Service
@Transactional(rollbackOn = Exception.class)
public class TargetServiceImpl implements TargetService{

	@Autowired
	TargetRepository targetRepository;
	
	@Override
	public List<TargetDto> findAll() {
		List<TargetDto> dtos = new ArrayList<TargetDto>();
		List<Target> targets = targetRepository.findAll();
		for (Target target : targets) {
			TargetDto targetDto = new TargetDto();
			targetDto.setId(target.getId());
			targetDto.setTitle(target.getTitle());
			targetDto.setCourse_id(target.getCourse_id());
			String title = target.getCourses_target().getTitle();
			targetDto.setTitle_course(title);
			dtos.add(targetDto);
			System.out.println(targetDto);
		}
		return dtos;
	}

	@Override
	public TargetDto findById(int id) {
		Target target = targetRepository.findById(id).get();
		TargetDto targetDto = new TargetDto();
		targetDto.setId(target.getId());
		targetDto.setTitle(target.getTitle());
		targetDto.setTitle_course(target.getCourses_target().getTitle());
		return targetDto;
	}

	@Override
	public void add(TargetDto dto) {
		Target target = new Target();
		target.setId(dto.getId());
		target.setTitle(dto.getTitle());
		target.setCourse_id(dto.getCourse_id());
		targetRepository.save(target);
	}

	@Override
	public void update(TargetDto dto) {
		Target target = targetRepository.findById(dto.getId()).get();
		target.setId(dto.getId());
		target.setTitle(dto.getTitle());
		target.setCourse_id(dto.getCourse_id());
		targetRepository.save(target);
	}

	@Override
	public void delete(int id) {
		targetRepository.deleteById(id);
	}

}
