package com.project.service;

import java.util.List;
import java.util.Optional;

import com.project.model.SobreMiVO;

public interface SobreMiService {

	SobreMiVO saveSobreMi(SobreMiVO sobremi);
	
	List<SobreMiVO> getAllSobreMi();
	
	Optional<SobreMiVO> getOne(int idsobremi);
	
	List<SobreMiVO> deleteSobreMi(int idsobremi);
	
	List<SobreMiVO> updateSobreMi(SobreMiVO sobremi);
	
	boolean existsById(int idsobremi);
	
	Optional<SobreMiVO> findById(Integer id);
	
}