package com.masini.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masini.model.Masina;

@Repository
public interface MasinaRepository extends JpaRepository<Masina, Long> {
}
