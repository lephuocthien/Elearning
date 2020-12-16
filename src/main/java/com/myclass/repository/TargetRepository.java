/**
 * Dec 15, 2020
 * 9:36:02 PM
 * @author LeThien
 */
package com.myclass.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myclass.entity.Target;
@Repository
public interface TargetRepository extends JpaRepository<Target, Integer> {

}
