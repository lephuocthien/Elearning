/**
 * Dec 18, 2020
 * 6:27:16 PM
 * @author LeThien
 */
package com.myclass.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.myclass.dto.VideoDto;
import com.myclass.entity.Video;
import com.myclass.repository.VideoRepository;
import com.myclass.service.VideoService;

@Service
public class VideoServiceImpl implements VideoService {

	private VideoRepository videoRepository;

	/**
	 * @param videoRepository
	 */
	public VideoServiceImpl(VideoRepository videoRepository) {
		super();
		this.videoRepository = videoRepository;
	}

	@Override
	public List<VideoDto> getAll() {
		List<Video> videos = videoRepository.findAll();
		List<VideoDto> dtos = new ArrayList<VideoDto>();
		for (Video video : videos) {
			VideoDto dto = new VideoDto();
			dto.setId(video.getId());
			dto.setTitle(video.getTitle());
			dto.setUrl(video.getUrl());
			dto.setTimeCount(video.getTimeCount());
			dto.setCourseId(video.getCourseId());
			dtos.add(dto);
		}
		return dtos;
	}

	@Override
	public VideoDto getById(int id) {
		Video video = videoRepository.findById(id).get();
		VideoDto dto = new VideoDto();
		dto.setId(video.getId());
		dto.setTitle(video.getTitle());
		dto.setUrl(video.getUrl());
		dto.setTimeCount(video.getTimeCount());
		dto.setCourseId(video.getCourseId());
		return null;
	}

	@Override
	public void save(VideoDto dto) {
		Video video = new Video();
		video.setTitle(dto.getTitle());
		video.setUrl(dto.getUrl());
		video.setTimeCount(dto.getCourseId());
		video.setCourseId(dto.getCourseId());
		videoRepository.save(video);

	}

	@Override
	public void edit(VideoDto dto) {
		Video video = videoRepository.findById(dto.getId()).get();
		if (video != null) {
			video.setTitle(dto.getTitle());
			video.setUrl(dto.getUrl());
			video.setTimeCount(dto.getCourseId());
			video.setCourseId(dto.getCourseId());
			videoRepository.save(video);
		}

	}

	@Override
	public void remove(int id) {
		videoRepository.deleteById(id);

	}

}
