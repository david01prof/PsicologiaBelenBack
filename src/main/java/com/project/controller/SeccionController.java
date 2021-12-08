package com.project.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.model.SeccionVO;
import com.project.service.SeccionService;

@RestController
@RequestMapping("/seccion")
@CrossOrigin( origins = "*")
public class SeccionController {

	@Autowired
	private SeccionService seccionservice;

//	Add
	@PostMapping("/add")
	public SeccionVO add(@RequestBody SeccionVO seccion) {
		
		try {			
			seccionservice.saveSeccion(seccion);
			System.out.println("Push realizado");
			return seccion;
		}catch(Exception e) {
			return seccion;
		}
	}
	
//	Update
	@PutMapping("/update")
	public List<SeccionVO> update(@RequestBody SeccionVO newSeccion){
		
		return  seccionservice.updateSeccion(newSeccion);
	}
	
//	Delete
	@DeleteMapping("/delete/{id}")
	public List<SeccionVO> delete(@PathVariable("id") int idseccion){
		return seccionservice.deleteSeccion(idseccion);
	}
	
//	Show all
	
	@GetMapping("/getAll")
	public List<SeccionVO> getAllSecciones(){
		return seccionservice.getAllSeccion();
	}
	
//	Show by id
	
	@GetMapping("/detail/{id}")
	public Optional<SeccionVO> getById(@PathVariable("id") int idseccion){
		
		if(!seccionservice.existsById(idseccion))
			return null;
		return seccionservice.findById(idseccion);
	}

	
	
	
}
