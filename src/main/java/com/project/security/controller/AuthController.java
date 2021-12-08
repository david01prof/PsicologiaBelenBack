package com.project.security.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.dto.Mensaje;
import com.project.security.dto.JwtDto;
import com.project.security.dto.LoginUsuario;
import com.project.security.dto.NuevoUsuario;
import com.project.security.enums.RolNombre;
import com.project.security.jwt.JwtProvider;
import com.project.security.model.Rol;
import com.project.security.model.Usuario;
import com.project.security.service_implement.RolServiceImplement;
import com.project.security.service_implement.UsuarioServiceImplement;

@RestController
@RequestMapping("/auth")
@CrossOrigin("*")
public class AuthController {

	@Autowired
	PasswordEncoder passwordEncoder;

	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	UsuarioServiceImplement usuarioService;

	@Autowired
	RolServiceImplement rolService;

	@Autowired
	JwtProvider jwtProvider;

	@PostMapping("/nuevo")
	public ResponseEntity<?> nuevo(@Valid @RequestBody NuevoUsuario nuevousuario, BindingResult bindingResult) {

		if (bindingResult.hasErrors())
			return new ResponseEntity(new Mensaje("Campos mal puestos o email invalido"), HttpStatus.BAD_REQUEST);

		if (usuarioService.existsByNombreUsuario(nuevousuario.getNombreUsuario()))
			return new ResponseEntity(new Mensaje("ese nombre ya existe"), HttpStatus.BAD_REQUEST);

		if (usuarioService.existsByEmail(nuevousuario.getEmail()))
			return new ResponseEntity(new Mensaje("ese email ya existe"), HttpStatus.BAD_REQUEST);

		Usuario usuario = new Usuario(nuevousuario.getNombre(), nuevousuario.getNombreUsuario(),
				nuevousuario.getEmail(), passwordEncoder.encode(nuevousuario.getPassword()));

		Set<Rol> roles = new HashSet<>();

		roles.add(rolService.getByRolNombre(RolNombre.ROLE_USER).get());

		if (nuevousuario.getRoles().contains("admin"))
			roles.add(rolService.getByRolNombre(RolNombre.ROLE_ADMIN).get());

		usuario.setRoles(roles);
		usuarioService.save(usuario);
		
		return new ResponseEntity(new Mensaje("usuario guardado"), HttpStatus.CREATED);
	}

	@PostMapping("/login")
	public ResponseEntity<JwtDto> login(@Valid @RequestBody LoginUsuario loginUsuario, BindingResult bindingResult) {
		 
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginUsuario.getNombreUsuario(), loginUsuario.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtProvider.generateToken(authentication);

		UserDetails userDetails = (UserDetails) authentication.getPrincipal();

		JwtDto jwtDto = new JwtDto(jwt, userDetails.getUsername(), userDetails.getAuthorities());

		return new ResponseEntity(jwtDto, HttpStatus.OK);

	}
	
	@GetMapping("/getAll")
	public List<Usuario> findAllUsers(){
		return usuarioService.getAllUsers();
	}
}
