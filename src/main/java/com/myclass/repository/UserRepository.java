/**
 * Dec 15, 2020
 * 9:31:06 PM
 * @author LeThien
 */
package com.myclass.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myclass.entity.User;
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
