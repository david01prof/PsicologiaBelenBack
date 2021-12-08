package com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.model.SobreMiVO;

@Repository
public interface SobreMiRepository extends JpaRepository<SobreMiVO, Integer> {

}
