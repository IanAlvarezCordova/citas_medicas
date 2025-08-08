package com.example.citas_medicas_BE.repositorios;

import com.example.citas_medicas_BE.modelos.Medico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicoRepositorio extends JpaRepository<Medico, Integer> {
}