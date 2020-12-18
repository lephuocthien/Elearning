/**
 * Dec 18, 2020
 * 4:47:24 PM
 * @author LeThien
 */
package com.myclass.service;

import java.util.List;

import com.myclass.dto.CategoryDto;

public interface CategoryService {
	List<CategoryDto> getAll();
	CategoryDto getById(int id);
	void save(CategoryDto dto);
	void edit(CategoryDto dto);
	void remove(int id);
}
