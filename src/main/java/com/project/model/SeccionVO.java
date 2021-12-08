package com.project.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table (name = "secciones")
public class SeccionVO {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int idseccion;
	
	private String tituloseccion;
	
	private String titulo;
	private String descripcion;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fecha;
	
	@Lob
	private String imagen;
	
	
}
