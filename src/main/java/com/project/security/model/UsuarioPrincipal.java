package com.project.security.model;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioPrincipal implements UserDetails{

//	Esta vista se encarga de los privilegios de cada usuario
	
	private String nombre;
	private String nombreusuario;
	private String email;
	private String password;
	private Collection<? extends GrantedAuthority> authorities;
	
	public static  UsuarioPrincipal build(Usuario usuario) {
//		Convertir clase rol en clase granted authority
		List<GrantedAuthority> authorities =
				usuario.getRoles().stream().map(rol -> new SimpleGrantedAuthority(rol
						.getRolNombre().name())).collect(Collectors.toList());
		
		return new UsuarioPrincipal(usuario.getNombre(),usuario.getNombreUsuario(),usuario.getEmail(),usuario.getPassword(), authorities);
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return authorities;
	}
	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}
	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return nombreusuario;
	}
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}



}
