//File: /src/main/java/com/example/citas_medicas_BE/repositorios/PacienteRepositorio.java
package com.example.citas_medicas_BE.repositorios;

import com.example.citas_medicas_BE.modelos.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepositorio extends JpaRepository<Paciente, Integer> {
}