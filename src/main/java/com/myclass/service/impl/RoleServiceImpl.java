/**
 * Dec 18, 2020
 * 3:42:45 PM
 * @author LeThien
 */
package com.myclass.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.myclass.dto.RoleDto;
import com.myclass.entity.Role;
import com.myclass.repository.RoleRepository;
import com.myclass.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {

	private RoleRepository roleRepository;
	
	/**
	 * @param roleRepository
	 */
	public RoleServiceImpl(RoleRepository roleRepository) {
		super();
		this.roleRepository = roleRepository;
	}

	@Override
	public List<RoleDto> getAll() {
		List<Role> roles = roleRepository.findAll();
		List<RoleDto> dtos = new ArrayList<RoleDto>();
		for(Role role:roles) {
			RoleDto dto = new RoleDto();
			dto.setId(role.getId());
			dto.setName(role.getName());
			dto.setDescription(role.getDescription());
			dtos.add(dto);
		}
		return dtos;
	}
	
	@Override
	public List<RoleDto> getNotAdmin() {
		// TODO Auto-generated method stub
		return roleRepository.findAllNotAdmin();
	}
	
	@Override
	public RoleDto getById(int id) {
		Role role = roleRepository.findById(id).get();
		RoleDto dto = new RoleDto();
		dto.setId(role.getId());
		dto.setName(role.getName());
		dto.setDescription(role.getDescription());
		return dto;
	}

	@Override
	public void save(RoleDto dto) {
		Role role = new Role();
		role.setName(dto.getName());
		role.setDescription(dto.getDescription());
		roleRepository.save(role);	
	}

	@Override
	public void edit(RoleDto dto) {
		Role role = roleRepository.findById(dto.getId()).get();
		if(role!=null) {
			role.setName(dto.getName());
			role.setDescription(dto.getDescription());
			roleRepository.save(role);	
		}
		
	}

	@Override
	public void remove(int id) {
		// TODO Auto-generated method stub
		roleRepository.deleteById(id);
	}

}
