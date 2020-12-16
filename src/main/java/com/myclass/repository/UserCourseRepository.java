/**
 * Dec 15, 2020
 * 10:20:58 PM
 * @author LeThien
 */
package com.myclass.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myclass.entity.UserCourse;
import com.myclass.entity.UserCourseId;
@Repository
public interface UserCourseRepository extends JpaRepository<UserCourse, UserCourseId> {

}
