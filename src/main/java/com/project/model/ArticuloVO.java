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

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "articulos")
public class ArticuloVO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idarticulo;

	private String titulo;
	private String descripcion;
	
	@Lob
	private String imagenarticulo;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fecha;
	
}
