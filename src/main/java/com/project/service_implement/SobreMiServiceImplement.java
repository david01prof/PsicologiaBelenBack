package com.project.service_implement;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.model.SobreMiVO;
import com.project.repository.SobreMiRepository;
import com.project.service.SobreMiService;

@Service
public class SobreMiServiceImplement implements SobreMiService {

	@Autowired
	SobreMiRepository sobremirepository;

//	Add
	
	@Override
	public SobreMiVO saveSobreMi(SobreMiVO sobremi) {

		if (sobremi != null) {
			return sobremirepository.save(sobremi);
		}
		return sobremi;
	}

//	Update
	
	@Override
	public List<SobreMiVO> updateSobreMi(SobreMiVO sobremiUpdated) {
		
		int num = sobremiUpdated.getIdsobremi();
		
		if(sobremirepository.findById(num).isPresent()) {
			
			sobremiUpdated.setIdsobremi(sobremiUpdated.getIdsobremi());
			sobremiUpdated.setTitulo(sobremiUpdated.getTitulo());
			sobremiUpdated.setDescripcion(sobremiUpdated.getDescripcion());
			sobremiUpdated.setImagenperfil(sobremiUpdated.getImagenperfil());
			
			sobremirepository.save(sobremiUpdated);
			return sobremirepository.findAll();
		}
		return (List<SobreMiVO>) sobremiUpdated;
	}
	

//	Delete
	
	@Override
	public List<SobreMiVO> deleteSobreMi(int idsobremi) {
		
		if(sobremirepository.findById(idsobremi).isPresent()) {
			sobremirepository.deleteById(idsobremi);
			return sobremirepository.findAll();
		}
		
		return null;
	}

//	Get All
	
	@Override
	public List<SobreMiVO> getAllSobreMi() {
		
		return sobremirepository.findAll();
	}

//	Check find
	
	@Override
	public Optional<SobreMiVO> getOne(int idsobremi) {
		
		return sobremirepository.findById(idsobremi);
	}


	@Override
	public boolean existsById(int idsobremi) {
		
		return sobremirepository.existsById(idsobremi);
	}

	@Override
	public Optional<SobreMiVO> findById(Integer id) {
		
		return sobremirepository.findById(id);
	}
	
}
