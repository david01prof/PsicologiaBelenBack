package com.project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table (name = "sobremi")
public class SobreMiVO {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int idsobremi;
	
	private String titulo;
	
	@Column(length = 700)
	private String descripcion;
	
	@Lob
	private String imagenperfil;
}
