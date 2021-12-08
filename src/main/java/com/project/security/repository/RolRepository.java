package com.project.security.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.security.enums.RolNombre;
import com.project.security.model.Rol;

@Repository
public interface RolRepository extends JpaRepository<Rol, Integer> {

	Optional<Rol> findByRolNombre(RolNombre rolnombre);
}
