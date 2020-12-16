/**
 * Dec 15, 2020
 * 10:20:05 PM
 * @author LeThien
 */
package com.myclass.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myclass.entity.Video;

public interface VideoRepository extends JpaRepository<Video, Integer>{

}
