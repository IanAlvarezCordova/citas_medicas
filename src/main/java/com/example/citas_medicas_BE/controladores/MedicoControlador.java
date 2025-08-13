//File: /src/main/java/com/example/citas_medicas_BE/controladores/MedicoControlador.java
package com.example.citas_medicas_BE.controladores;

import com.example.citas_medicas_BE.modelos.Medico;
import com.example.citas_medicas_BE.servicios.MedicoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/medicos")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class MedicoControlador {
    @Autowired
    private MedicoServicio servicio;

    @GetMapping
    public List<Medico> obtenerTodos() {
        return servicio.obtenerTodos();
    }

    @PostMapping
    public ResponseEntity<Medico> crear(@RequestBody Medico medico) {
        Medico guardado = servicio.guardar(medico);
        return ResponseEntity.ok(guardado);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Medico> obtenerPorId(@PathVariable Integer id) {
        Medico medico = servicio.obtenerPorId(id);
        return medico != null ? ResponseEntity.ok(medico) : ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Medico> actualizar(@PathVariable Integer id, @RequestBody Medico medico) {
        Medico actualizado = servicio.actualizar(id, medico);
        return actualizado != null ? ResponseEntity.ok(actualizado) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        servicio.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}