/**
 * Dec 15, 2020
 * 9:31:06 PM
 * @author LeThien
 */
package com.myclass.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myclass.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
