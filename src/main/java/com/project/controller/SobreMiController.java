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

import com.project.model.SobreMiVO;
import com.project.service.SobreMiService;

@RestController
@RequestMapping("/sobremi")
@CrossOrigin(origins = "*")
public class SobreMiController {

	@Autowired
	private SobreMiService sobremiService;
	
//	Add
	@PostMapping("/add")
	public SobreMiVO add(@RequestBody SobreMiVO sobremi) {
		try {
			sobremiService.saveSobreMi(sobremi);
			System.out.println("Push realizado");
			return sobremi;
		}catch (Exception e) {
			System.out.println(e);
			return sobremi;
		}
	}
	
//	Update
	@PutMapping("/update")
	public List<SobreMiVO> update (@RequestBody SobreMiVO newContacto){
		return sobremiService.updateSobreMi(newContacto);
	}
	
//	Delete
	@DeleteMapping("/delete/{id}")
	public List<SobreMiVO> delete(@PathVariable("id") int idsobremi){
		return sobremiService.deleteSobreMi(idsobremi);
	}
	
//	Show All
	
	@GetMapping("/getAll")
	public List<SobreMiVO> getAllSobreMi(){
		return sobremiService.getAllSobreMi();
	}
	
//	Show By Id
	
	@GetMapping("detail/{id}")
	public Optional<SobreMiVO> getById(@PathVariable("id") int idsobremi){
		
		if(!sobremiService.existsById(idsobremi))
			return null;
		return sobremiService.findById(idsobremi);
	}
	
}
