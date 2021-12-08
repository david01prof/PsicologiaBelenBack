package com.project.service_implement;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.project.model.ArticuloVO;
import com.project.repository.ArticuloRepository;
import com.project.service.ArticuloService;

@Service
public class ArticuloServiceImplement implements ArticuloService {

	@Autowired
	ArticuloRepository articuloRepository;
	
//	Add

	@Override
	public ArticuloVO saveArticulo(ArticuloVO articulo) {

		if (articulo != null) {
			return articuloRepository.save(articulo);
		}

		return articulo;
	}
	

//	Update

	@Override
	public List<ArticuloVO> updateArticulo(ArticuloVO ArticuloUpdated) {

		int num = ArticuloUpdated.getIdarticulo();

		if (articuloRepository.findById(num).isPresent()) {

			ArticuloUpdated.setIdarticulo(ArticuloUpdated.getIdarticulo());
			ArticuloUpdated.setTitulo(ArticuloUpdated.getTitulo());
			ArticuloUpdated.setDescripcion(ArticuloUpdated.getDescripcion());

			articuloRepository.save(ArticuloUpdated);
			System.out.println(ArticuloUpdated);
			return articuloRepository.findAll();
		}
		return (List<ArticuloVO>) ArticuloUpdated;
	}
	
//	Delete

	@Override
	public List<ArticuloVO> deleteArticulo(int idarticulo) {

		if (articuloRepository.findById(idarticulo).isPresent()) {
			articuloRepository.deleteById(idarticulo);
			return articuloRepository.findAll();
		}
		return null;
		
	}

	
//	Get All
	
	@Override
	public List<ArticuloVO> getAllArticulos() {

		return articuloRepository.findAll();
	}
	
	@Override
	public List<ArticuloVO> findByArticulos(Pageable pageable) {
		
		return articuloRepository.findByArticulos(pageable);
	}

//	Check find
	
	@Override
	public boolean existsById(int idarticulo) {

		return articuloRepository.existsById(idarticulo);
	}

	@Override
	public Optional<ArticuloVO> getOne(int idarticulo) {

		return articuloRepository.findById(idarticulo);
	}

	public Optional<ArticuloVO> findById(Integer id) {
		return articuloRepository.findById(id);
	}





	

}
