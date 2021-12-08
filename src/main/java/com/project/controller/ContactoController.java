package com.project.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.model.ContactoVO;
import com.project.service.ContactoService;

@RestController
@RequestMapping("/contacto")
@CrossOrigin( origins = "*")
public class ContactoController {

	@Autowired
	private ContactoService contactoService;
	
//	Add
	
	@PostMapping("/add")
	public ContactoVO add(@RequestBody ContactoVO contacto) {
		try {
			contactoService.saveContacto(contacto);
			System.out.println("Push realizado");
			return contacto;
		}catch (Exception e) {
			System.out.println(e);
			return contacto;
		}
	}
	
//	Delete
	@DeleteMapping("/delete/{id}")
	public List<ContactoVO> delete(@PathVariable("id") int idcontacto){
		return contactoService.deleteContacto(idcontacto);
	}
	
//	Show All
	
	@GetMapping("/getAll")
	public List<ContactoVO> getAllContactos(){
		return contactoService.getAllContactos();
	}
	
//	Show by id
	
	@GetMapping("detail/{id}")
	public Optional<ContactoVO> getById(@PathVariable("id") int idcontacto){
		return contactoService.findById(idcontacto);
	}
}
