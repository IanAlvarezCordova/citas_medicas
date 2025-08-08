package com.example.citas_medicas_BE.servicios;

import com.example.citas_medicas_BE.modelos.Medico;
import com.example.citas_medicas_BE.repositorios.MedicoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicoServicio {
    @Autowired
    private MedicoRepositorio repositorio;

    public List<Medico> obtenerTodos() {
        return repositorio.findAll();
    }

    public Medico guardar(Medico medico) {
        return repositorio.save(medico);
    }

    public Medico obtenerPorId(Integer id) {
        return repositorio.findById(id).orElse(null);
    }

    public Medico actualizar(Integer id, Medico medicoActualizado) {
        Medico medico = repositorio.findById(id).orElse(null);
        if (medico != null) {
            medico.setNombre(medicoActualizado.getNombre());
            medico.setApellido(medicoActualizado.getApellido());
            medico.setEspecialidad(medicoActualizado.getEspecialidad());
            return repositorio.save(medico);
        }
        return null;
    }

    public void eliminar(Integer id) {
        repositorio.deleteById(id);
    }
}