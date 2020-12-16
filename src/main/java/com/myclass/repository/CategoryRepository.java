/**
 * Dec 15, 2020
 * 9:56:27 PM
 * @author LeThien
 */
package com.myclass.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myclass.entity.Category;
@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer>{

}
