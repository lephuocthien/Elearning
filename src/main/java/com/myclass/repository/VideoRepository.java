/**
 * Dec 15, 2020
 * 10:20:05 PM
 * @author LeThien
 */
package com.myclass.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.myclass.dto.VideoDto;
import com.myclass.entity.Video;
@Repository
public interface VideoRepository extends JpaRepository<Video, Integer>{

	@Query("SELECT new com.myclass.dto.VideoDto"
			+ "(v.id, "
			+ "v.title, "
			+ "v.url, "
			+ "v.timeCount, "
			+ "v.courseId, "
			+ "c.title) "
			+ "FROM Course c JOIN Video v "
			+ "ON c.id = v.courseId "
			+ "WHERE v.courseId = :courseId")
	List<VideoDto> getAllVideoByCourseId(@Param("courseId") int courseId);
}
