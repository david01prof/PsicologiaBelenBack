package com.project.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table (name = "contacto")
public class ContactoVO {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int idcontacto;
	
	private String nombre;
	private String email;
	private String comentario;
}
