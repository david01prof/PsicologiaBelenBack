package com.project.security.service_implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.project.security.model.Usuario;
import com.project.security.model.UsuarioPrincipal;

@Service
public class UserDetailImplement  implements UserDetailsService{

	@Autowired
	UsuarioServiceImplement usuarioService;
	
	@Override
	public UserDetails loadUserByUsername(String nombreUsuario) throws UsernameNotFoundException {
		
		Usuario usuario = usuarioService.getByNombreUsuario(nombreUsuario).get();
		
		return UsuarioPrincipal.build(usuario);
	}

}
