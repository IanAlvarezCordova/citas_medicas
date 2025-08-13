//File: /src/main/java/com/example/citas_medicas_BE/servicios/CitaServicio.java
package com.example.citas_medicas_BE.servicios;

import com.example.citas_medicas_BE.modelos.Cita;
import com.example.citas_medicas_BE.repositorios.CitaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CitaServicio {
    @Autowired
    private CitaRepositorio repositorio;

    public List<Cita> obtenerTodos() {
        return repositorio.findAll();
    }

    public Cita guardar(Cita cita) {
        return repositorio.save(cita);
    }

    public Cita obtenerPorId(Integer id) {
        return repositorio.findById(id).orElse(null);
    }

    public Cita actualizar(Integer id, Cita citaActualizada) {
        Cita cita = repositorio.findById(id).orElse(null);
        if (cita != null) {
            cita.setPaciente(citaActualizada.getPaciente());
            cita.setMedico(citaActualizada.getMedico());
            cita.setConsultorio(citaActualizada.getConsultorio());
            cita.setFecha(citaActualizada.getFecha());
            cita.setHora(citaActualizada.getHora());
            return repositorio.save(cita);
        }
        return null;
    }

    public void eliminar(Integer id) {
        repositorio.deleteById(id);
    }
}