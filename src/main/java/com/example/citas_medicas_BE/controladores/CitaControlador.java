//File: /src/main/java/com/example/citas_medicas_BE/controladores/CitaControlador.java 
package com.example.citas_medicas_BE.controladores;

import com.example.citas_medicas_BE.modelos.Cita;
import com.example.citas_medicas_BE.servicios.CitaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/citas")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CitaControlador {
    @Autowired
    private CitaServicio servicio;

    @GetMapping
    public List<Cita> obtenerTodos() {
        return servicio.obtenerTodos();
    }

    @PostMapping
    public ResponseEntity<Cita> crear(@RequestBody Cita cita) {
        Cita guardada = servicio.guardar(cita);
        return ResponseEntity.ok(guardada);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cita> obtenerPorId(@PathVariable Integer id) {
        Cita cita = servicio.obtenerPorId(id);
        return cita != null ? ResponseEntity.ok(cita) : ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cita> actualizar(@PathVariable Integer id, @RequestBody Cita cita) {
        Cita actualizada = servicio.actualizar(id, cita);
        return actualizada != null ? ResponseEntity.ok(actualizada) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        servicio.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}