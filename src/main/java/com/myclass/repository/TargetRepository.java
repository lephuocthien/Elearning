/**
 * Dec 15, 2020
 * 9:36:02 PM
 * @author LeThien
 */
package com.myclass.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myclass.entity.Target;

public interface TargetRepository extends JpaRepository<Target, Integer> {

}
