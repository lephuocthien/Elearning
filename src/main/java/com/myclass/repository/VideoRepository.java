/**
 * Dec 15, 2020
 * 10:20:05 PM
 * @author LeThien
 */
package com.myclass.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myclass.entity.Video;
@Repository
public interface VideoRepository extends JpaRepository<Video, Integer>{

}
