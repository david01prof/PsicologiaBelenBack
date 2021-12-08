package com.project.service;

import java.util.List;
import java.util.Optional;

import com.project.model.SeccionVO;

public interface SeccionService {

	SeccionVO saveSeccion(SeccionVO seccion);
	
	List<SeccionVO> updateSeccion(SeccionVO newSeccion);
	
	List<SeccionVO> deleteSeccion(int idseccion);
	
	List<SeccionVO> getAllSeccion();
	
	boolean existsById(int idseccion);
	
	Optional<SeccionVO> getOne(int idseccion);
	
	Optional<SeccionVO> findById(Integer id);
	
	
}
