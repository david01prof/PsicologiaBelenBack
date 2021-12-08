package com.project.service;

import java.util.List;
import java.util.Optional;

import com.project.model.ContactoVO;

public interface ContactoService {

	ContactoVO saveContacto(ContactoVO contacto);
	
	List<ContactoVO> getAllContactos();
	
	Optional<ContactoVO> getOne(int idcontacto);
	
	List<ContactoVO> deleteContacto(int idcontacto);
	
	Optional<ContactoVO> findById(Integer id);
}