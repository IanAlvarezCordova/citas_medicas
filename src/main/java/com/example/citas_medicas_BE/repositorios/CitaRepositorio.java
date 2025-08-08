package com.example.citas_medicas_BE.repositorios;

import com.example.citas_medicas_BE.modelos.Cita;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CitaRepositorio extends JpaRepository<Cita, Integer> {
}