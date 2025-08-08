package com.example.citas_medicas_BE.servicios;

import com.example.citas_medicas_BE.modelos.Consultorio;
import com.example.citas_medicas_BE.repositorios.ConsultorioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsultorioServicio {
    @Autowired
    private ConsultorioRepositorio repositorio;

    public List<Consultorio> obtenerTodos() {
        return repositorio.findAll();
    }

    public Consultorio guardar(Consultorio consultorio) {
        return repositorio.save(consultorio);
    }

    public Consultorio obtenerPorId(Integer id) {
        return repositorio.findById(id).orElse(null);
    }

    public Consultorio actualizar(Integer id, Consultorio consultorioActualizado) {
        Consultorio consultorio = repositorio.findById(id).orElse(null);
        if (consultorio != null) {
            consultorio.setNumero(consultorioActualizado.getNumero());
            consultorio.setPiso(consultorioActualizado.getPiso());
            return repositorio.save(consultorio);
        }
        return null;
    }

    public void eliminar(Integer id) {
        repositorio.deleteById(id);
    }
}