/**
 * Dec 18, 2020
 * 6:21:19 PM
 * @author LeThien
 */
package com.myclass.service;

import java.util.List;

import com.myclass.dto.VideoDto;

public interface VideoService {
	List<VideoDto> getAll();
	VideoDto getById(int id);
	void save(VideoDto dto);
	void edit(VideoDto dto);
	void remove(int id);;
}
