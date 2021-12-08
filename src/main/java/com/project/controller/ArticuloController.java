package com.project.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.project.model.ArticuloVO;
import com.project.service.ArticuloService;

@RestController
@RequestMapping("/articulo")
@CrossOrigin(origins = "*")
public class ArticuloController {

	@Autowired
	private ArticuloService articuloService;

//	Add

	@PostMapping("/add")
	public ArticuloVO add(@RequestBody ArticuloVO articulo) {

		try {
			articuloService.saveArticulo(articulo);
			System.out.println("Push realizado");
			return articulo;

		} catch (Exception e) {
			System.out.println(e);
			return articulo;
		}

	}

//	Update
	@PutMapping("/update")
	public List<ArticuloVO> update(@RequestBody ArticuloVO newArticulo) {

		return articuloService.updateArticulo(newArticulo);

	}

//	Delete
	@DeleteMapping("/delete/{id}")
	public List<ArticuloVO> delete(@PathVariable("id") int idarticulo) {

		return articuloService.deleteArticulo(idarticulo);

	}

//	Show all

	@GetMapping("/getAll")
	public List<ArticuloVO> getAllArticulos() {

		return articuloService.getAllArticulos();
	}
	
	@GetMapping("/getLimitArticle")
	public List<ArticuloVO> getLimitArticulos(){
		
		Pageable pageable = PageRequest.of(0,5);
		return articuloService.findByArticulos(pageable);
	}
	
	

//	Show by id

	@GetMapping("/detail/{id}")
	public Optional<ArticuloVO> getById(@PathVariable("id") int idarticulo) {

		if (!articuloService.existsById(idarticulo))
			return null;
		return articuloService.findById(idarticulo);
	}
	

}