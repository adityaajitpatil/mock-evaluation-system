package com.mock.mock_evaluation_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.mock.mock_evaluation_system.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByName(String roleName);

}