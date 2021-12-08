package com.project.service_implement;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.model.SeccionVO;
import com.project.repository.SeccionRepository;
import com.project.service.SeccionService;

@Service
public class SeccionServiceImplement implements SeccionService{

	@Autowired
	SeccionRepository seccionrepository;
	
//	Add
	
	@Override
	public SeccionVO saveSeccion(SeccionVO seccion) {
		
		if(seccion !=null) {
			return seccionrepository.save(seccion);
		}
		
		return seccion;
	}

//	Update
	
	@Override
	public List<SeccionVO> updateSeccion(SeccionVO SeccionUpdated) {
		
		int num = SeccionUpdated.getIdseccion();
		
		if(seccionrepository.findById(num).isPresent()) {
			
			SeccionUpdated.setIdseccion(SeccionUpdated.getIdseccion());
			SeccionUpdated.setTituloseccion(SeccionUpdated.getTituloseccion());
			SeccionUpdated.setTitulo(SeccionUpdated.getTitulo());
			SeccionUpdated.setDescripcion(SeccionUpdated.getDescripcion());	
			SeccionUpdated.setFecha(SeccionUpdated.getFecha());
			SeccionUpdated.setImagen(SeccionUpdated.getImagen());
			
			seccionrepository.save(SeccionUpdated);
			System.out.println(SeccionUpdated);
			return seccionrepository.findAll();
		}
		
		return (List<SeccionVO>) SeccionUpdated;
	}

//	Delete
	
	@Override
	public List<SeccionVO> deleteSeccion(int idseccion) {
		
		if(seccionrepository.findById(idseccion).isPresent()) {
			seccionrepository.deleteById(idseccion);
			return  seccionrepository.findAll();
		}
		
		return null;
	}

//	Get All
	
	@Override
	public List<SeccionVO> getAllSeccion() {
		
		return seccionrepository.findAll();
	}

//	Check find
	
	@Override
	public boolean existsById(int idseccion) {
		
		return seccionrepository.existsById(idseccion);
	}

	@Override
	public Optional<SeccionVO> getOne(int idseccion) {
		return seccionrepository.findById(idseccion);
	}

	@Override
	public Optional<SeccionVO> findById(Integer id) {
		return seccionrepository.findById(id);
	}

}
