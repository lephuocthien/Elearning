/**
 * Dec 15, 2020
 * 9:33:23 PM
 * @author LeThien
 */
package com.myclass.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myclass.entity.Role;
@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

}
