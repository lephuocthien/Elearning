/**
 * Dec 15, 2020
 * 9:33:23 PM
 * @author LeThien
 */
package com.myclass.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.myclass.dto.RoleDto;
import com.myclass.entity.Role;
@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

	@Query("SELECT new com.myclass.dto.RoleDto(id, name, description) FROM Role WHERE name <> 'ROLE_ADMIN'")
	List<RoleDto> findAllNotAdmin();
}
