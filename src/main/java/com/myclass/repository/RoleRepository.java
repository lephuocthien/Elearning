/**
 * Dec 15, 2020
 * 9:33:23 PM
 * @author LeThien
 */
package com.myclass.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myclass.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {

}
