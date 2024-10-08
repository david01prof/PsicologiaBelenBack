package com.project.security.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table (name = "usuarios")
public class Usuario {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotNull
	private String nombre;
	
	@NotNull
	@Column (unique = true)
	private String nombreUsuario;
	
	@NotNull
	private String email;
	
	@NotNull
	private String password;
	
	@NotNull
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable (name = "usuario_rol", joinColumns = @JoinColumn(name = "usuario_id"),inverseJoinColumns = @JoinColumn(name = "rol_id"))
	private Set<Rol> roles = new HashSet<Rol>();

	public Usuario(String nombre,String nombreUsuario,String email,String password) {
		this.nombre = nombre;
		this.nombreUsuario = nombreUsuario;
		this.email = email;
		this.password = password;
	}
	
	
	
}
