package com.example.citas_medicas_BE.servicios;

import com.example.citas_medicas_BE.modelos.Paciente;
import com.example.citas_medicas_BE.repositorios.PacienteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteServicio {
    @Autowired
    private PacienteRepositorio repositorio;

    public List<Paciente> obtenerTodos() {
        return repositorio.findAll();
    }

    public Paciente guardar(Paciente paciente) {
        return repositorio.save(paciente);
    }

    public Paciente obtenerPorId(Integer id) {
        return repositorio.findById(id).orElse(null);
    }

    public Paciente actualizar(Integer id, Paciente pacienteActualizado) {
        Paciente paciente = repositorio.findById(id).orElse(null);
        if (paciente != null) {
            paciente.setNombre(pacienteActualizado.getNombre());
            paciente.setApellido(pacienteActualizado.getApellido());
            paciente.setFechaNacimiento(pacienteActualizado.getFechaNacimiento());
            paciente.setEmail(pacienteActualizado.getEmail());
            return repositorio.save(paciente);
        }
        return null;
    }

    public void eliminar(Integer id) {
        repositorio.deleteById(id);
    }
}