/**
 * Dec 14, 2020
 * 9:19:23 PM
 * @author LeThien
 */
package com.myclass.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "user_courses")
public class UserCourse {
	
	@EmbeddedId
	private UserCourseId userCourseId;
	
	// Quan hệ nhiều - 1 với User
	@ManyToOne(cascade = CascadeType.ALL)
	// Chỉ tên khoá ngoại là user_id
	@MapsId("userId")
	@JsonIgnore
	private User user;

	// Quan hệ nhiều - 1 với Course
	@ManyToOne(cascade = CascadeType.ALL)
	// Chỉ tên khoá ngoại là course_id
	@MapsId("courseId")
	@JsonIgnore
	private Course course;

	@Column(name = "role_id")
	private int roleId;
	/**
	 * 
	 */
	public UserCourse() {
		super();
	}
	/**
	 * @param userCourseId
	 * @param roleId
	 */
	public UserCourse(UserCourseId userCourseId, int roleId) {
		super();
		this.userCourseId = userCourseId;
		this.roleId = roleId;
	}
	/**
	 * @return the userCourseId
	 */
	public UserCourseId getUserCourseId() {
		return userCourseId;
	}
	/**
	 * @param userCourseId the userCourseId to set
	 */
	public void setUserCourseId(UserCourseId userCourseId) {
		this.userCourseId = userCourseId;
	}
	/**
	 * @return the roleId
	 */
	public int getRoleId() {
		return roleId;
	}
	/**
	 * @param roleId the roleId to set
	 */
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	
	
	
}
