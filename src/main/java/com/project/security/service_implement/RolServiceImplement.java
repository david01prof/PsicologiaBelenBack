package com.project.security.service_implement;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.security.enums.RolNombre;
import com.project.security.model.Rol;
import com.project.security.repository.RolRepository;

@Service
@Transactional
public class RolServiceImplement {

	@Autowired
	RolRepository rolRepository;
	
	public Optional<Rol> getByRolNombre(RolNombre rolNombre){
		return rolRepository.findByRolNombre(rolNombre);
	}
	
	public void save(Rol rol) {
		rolRepository.save(rol);
	}
}
