package com.tts.repository;

import org.springframework.data.repository.CrudRepository;

import com.tts.model.Role;

public interface RoleRepository extends CrudRepository<Role, Long> {
	Role findByRole(String role);
}
