package com.project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;

import com.project.model.ArticuloVO;


public interface ArticuloService {

	ArticuloVO saveArticulo(ArticuloVO articulo);

	List<ArticuloVO> getAllArticulos();

	Optional<ArticuloVO> getOne(int idarticulo);

	List<ArticuloVO> deleteArticulo(int idarticulo);

	List<ArticuloVO> updateArticulo(ArticuloVO newArticulo);

	boolean existsById(int idarticulo);
	
	Optional<ArticuloVO> findById(Integer id);
	
	List<ArticuloVO> findByArticulos(Pageable pageable);
	

}