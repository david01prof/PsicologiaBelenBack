package com.project.repository;


import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.project.model.ArticuloVO;


@Repository
public interface ArticuloRepository extends JpaRepository<ArticuloVO, Integer>{

	
	@Query("select a from ArticuloVO a ORDER BY a.fecha DESC")
	List<ArticuloVO> findByArticulos(Pageable pageable);
}
