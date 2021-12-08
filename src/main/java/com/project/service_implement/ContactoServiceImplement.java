package com.project.service_implement;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.model.ContactoVO;
import com.project.repository.ContactoRepository;
import com.project.service.ContactoService;

@Service
public class ContactoServiceImplement implements ContactoService {

	@Autowired
	ContactoRepository contactorepository;

//	Add
	
	@Override
	public ContactoVO saveContacto(ContactoVO contacto) {
		
		if(contacto != null) {
			return contactorepository.save(contacto);
		}
		return contacto;
	}
	
//	Delete
	
	@Override
	public List<ContactoVO> deleteContacto(int idcontacto) {
		
		if(contactorepository.findById(idcontacto).isPresent()) {
			contactorepository.deleteById(idcontacto);
			return contactorepository.findAll();
		}
		
		return null;
	}
	
//	Get All

	@Override
	public List<ContactoVO> getAllContactos() {
		
		return contactorepository.findAll();
	}

//	Check find
	
	@Override
	public Optional<ContactoVO> getOne(int idcontacto) {
		
		return contactorepository.findById(idcontacto);
	}



	@Override
	public Optional<ContactoVO> findById(Integer id) {
		
		return  contactorepository.findById(id);
	}
	
}
