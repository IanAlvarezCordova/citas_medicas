package com.example.citas_medicas_BE.repositorios;

import com.example.citas_medicas_BE.modelos.Consultorio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultorioRepositorio extends JpaRepository<Consultorio, Integer> {
}