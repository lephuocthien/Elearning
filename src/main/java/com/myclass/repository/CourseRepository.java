/**
 * Dec 15, 2020
 * 9:35:17 PM
 * @author LeThien
 */
package com.myclass.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.myclass.dto.CourseDto;
import com.myclass.entity.Course;
@Repository
public interface CourseRepository extends JpaRepository<Course, Integer>{
	
	@Query("SELECT new com.myclass.dto.CourseDto(c.id, c.title, c.image, c.leturesCount, c.hourCount, c.viewCount, c.price, c.discount, c.promotionPrice, c.description, c.content, c.categoryId, c.lastUpdate, r.title) FROM Course c JOIN Category r ON c.categoryId = r.id")
	List<CourseDto> findAllCourseCategory();
}
