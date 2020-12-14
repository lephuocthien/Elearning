/**
 * Dec 14, 2020
 * 9:19:23 PM
 * @author LeThien
 */
package com.myclass.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "user_courses")
public class UserCourse {
	@Id
	@Column(name = "user_id")
	private int userId;

	@Id
	@Column(name = "course_id")
	private int courseId;

	@Column(name = "role_id")
	private int roleId;

	// Quan hệ nhiều - 1 với User
	@ManyToOne(cascade = CascadeType.ALL)
	// Chỉ tên khoá ngoại là user_id
	@JoinColumn(name = "user_id", insertable = false, updatable = false)
	@JsonIgnore
	private User user;

	// Quan hệ nhiều - 1 với Course
	@ManyToOne(cascade = CascadeType.ALL)
	// Chỉ tên khoá ngoại là course_id
	@JoinColumn(name = "course_id", insertable = false, updatable = false)
	@JsonIgnore
	private Course course;
}
