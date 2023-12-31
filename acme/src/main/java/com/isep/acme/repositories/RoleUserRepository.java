package com.isep.acme.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.isep.acme.model.RoleUser;
import java.util.List;


public interface RoleUserRepository extends CrudRepository<RoleUser, Long> {
    Optional<RoleUser> findById(Long id);
    List<RoleUser> findByRole(String role);
}
