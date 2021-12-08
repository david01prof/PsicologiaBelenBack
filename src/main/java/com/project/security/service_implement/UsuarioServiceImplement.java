package com.project.security.service_implement;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.security.model.Usuario;
import com.project.security.repository.UsuarioRepository;

@Service
@Transactional
public class UsuarioServiceImplement {

	@Autowired
	UsuarioRepository usuarioRepository;
	
	public Optional<Usuario> getByNombreUsuario(String nombreUsuario){
		
		return usuarioRepository.findByNombreUsuario(nombreUsuario);
	}
	
	public boolean existsByNombreUsuario(String nombreUsuario) {
		return usuarioRepository.existsByNombreUsuario(nombreUsuario);
	}
	
	public boolean existsByEmail(String email) {
		return usuarioRepository.existsByEmail(email);
	}
	
	public void save(Usuario usuario) {
		usuarioRepository.save(usuario);
	}
	
	public List<Usuario> getAllUsers(){
	return usuarioRepository.findAll();
}

}
