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
import org.springframework.stereotype.Repository;

import com.myclass.dto.UserDto;
import com.myclass.entity.User;
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	@Query("SELECT new com.myclass.dto.UserDto(u.id, u.email, u.password, u.fullname, u.phone, u.address, u.avatar, u.roleId, r.name) FROM User u JOIN Role r ON u.roleId = r.id")
	Page<UserDto> findAllUserRole(Pageable paging);
	@Query("SELECT new com.myclass.dto.UserDto(u.id, u.email, u.password, u.fullname, u.phone, u.address, u.avatar, u.roleId, r.name) FROM User u JOIN Role r ON u.roleId = r.id")
	List<UserDto> findAllUserRole();
}
