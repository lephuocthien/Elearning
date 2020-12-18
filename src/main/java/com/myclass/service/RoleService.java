/**
 * Dec 18, 2020
 * 3:38:23 PM
 * @author LeThien
 */
package com.myclass.service;

import java.util.List;

import com.myclass.dto.RoleDto;

public interface RoleService {
	List<RoleDto> getAll();
	RoleDto getById(int id);;
	void save(RoleDto dto);
	void edit(RoleDto dto);
	void remove(int id);
}
