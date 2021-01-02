/**
 * Dec 15, 2020
 * 9:31:06 PM
 * @author LeThien
 */
package com.myclass.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.myclass.dto.UserDto;
import com.myclass.entity.User;
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	@Query("SELECT new com.myclass.dto.UserDto(u.id, u.email, u.fullname, u.password, u.avatar, u.phone, u.address, u.roleId, r.name) FROM User u JOIN Role r ON u.roleId = r.id")
	Page<UserDto> findAllUserRole(Pageable paging);
	@Query("SELECT new com.myclass.dto.UserDto(u.id, u.email, u.fullname, u.password, u.avatar, u.phone, u.address, u.roleId, r.name) FROM User u JOIN Role r ON u.roleId = r.id")
	List<UserDto> findAllUserDto();
	@Query("SELECT new com.myclass.dto.UserDto(u.email, u.password, r.name) FROM User u JOIN Role r ON u.roleId = r.id WHERE u.email = :email")
	UserDto findByEmail(@Param("email") String email);
	@Query("SELECT new com.myclass.dto.UserDto(u.id, u.email, u.fullname, u.password, u.avatar, u.phone, u.address, u.roleId, r.name) FROM User u JOIN Role r ON u.roleId = r.id WHERE u.email = :email")
	UserDto findUserDtoByEmail(@Param("email") String email);
	@Query("SELECT new com.myclass.dto.UserDto(u.id, u.email, u.fullname, u.password, u.avatar, u.phone, u.address, u.roleId, r.name) FROM User u JOIN Role r ON u.roleId = r.id WHERE u.id = :id")
	UserDto findUserDtoById(@Param("id") int id);
	@Query("SELECT new com.myclass.dto.UserDto(u.id, u.email, u.fullname, u.password, u.avatar, u.phone, u.address, u.roleId, r.name) FROM User u JOIN Role r ON u.roleId = r.id "
			+ "JOIN UserCourse uc "
			+ "ON u.id = uc.userCourseId.userId "
			+ "WHERE uc.userCourseId.courseId = :courseId "
			+ "AND uc.roleId = 3")
	List<UserDto> findUserDtoOfCourseByTeacher(@Param("courseId") int courseId);
}
