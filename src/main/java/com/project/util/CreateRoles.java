package com.project.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.project.security.enums.RolNombre;
import com.project.security.model.Rol;
import com.project.security.service_implement.RolServiceImplement;

@Component
public class CreateRoles implements CommandLineRunner{

	@Autowired
	RolServiceImplement rolService;
	
	@Override
	public void run(String... args) throws Exception {
		
		Rol rolAdmin = new Rol(RolNombre.ROLE_ADMIN);
		Rol rolUser = new Rol(RolNombre.ROLE_USER);
		
//		rolService.save(rolAdmin);
//		rolService.save(rolUser);
	}

}
