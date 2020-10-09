package com.myclass.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.myclass.dto.VideoDto;
import com.myclass.entity.Video;
import com.myclass.repository.VideoRepository;
import com.myclass.service.VideoService;

@Service
@Transactional(rollbackOn = Exception.class)
public class VideoServiceImpl implements VideoService{

	@Autowired
	VideoRepository videoRepository;
	
	@Override
	public List<VideoDto> findAll() {
		List<VideoDto> dtos = new ArrayList<VideoDto>();
		List<Video> videos = videoRepository.findAll();
		for (Video video : videos) {
			VideoDto videoDto = new VideoDto();
			videoDto.setId(video.getId());
			videoDto.setTitle(video.getTitle());
			videoDto.setUrl(video.getUrl());
			videoDto.setTime_count(video.getTime_count());
			videoDto.setCourse_id(video.getCourse_id());
			String title = video.getCourses_video().getTitle();
			videoDto.setTitle_course(title);
			String image =video.getCourses_video().getImage();
			videoDto.setImage(image);
			dtos.add(videoDto);
		}
		return dtos;
	}

	@Override
	public VideoDto findById(int id) {
		Video video = videoRepository.findById(id).get();
		VideoDto videoDto = new VideoDto();
		videoDto.setId(video.getId());
		videoDto.setTitle(video.getTitle());
		videoDto.setUrl(video.getUrl());
		videoDto.setTime_count(video.getTime_count());
		videoDto.setCourse_id(video.getCourse_id());
		return videoDto;
	}

	@Override
	public void add(VideoDto dto) {
		Video video = new Video();
		video.setId(dto.getId());
		video.setTitle(dto.getTitle());
		video.setUrl(dto.getUrl());
		video.setTime_count(dto.getTime_count());
		video.setCourse_id(dto.getCourse_id());
		videoRepository.save(video);
	}

	@Override
	public void update(VideoDto dto) {
		Video video = videoRepository.findById(dto.getId()).get();
		video.setId(dto.getId());
		video.setTitle(dto.getTitle());
		video.setUrl(dto.getUrl());
		video.setTime_count(dto.getTime_count());
		video.setCourse_id(dto.getCourse_id());
		videoRepository.save(video);
	}

	@Override
	public void delete(int id) {
		videoRepository.deleteById(id);
	}

}
