/**
 * Dec 15, 2020
 * 9:35:17 PM
 * @author LeThien
 */
package com.myclass.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myclass.entity.Course;
@Repository
public interface CourseRepository extends JpaRepository<Course, Integer>{

}
