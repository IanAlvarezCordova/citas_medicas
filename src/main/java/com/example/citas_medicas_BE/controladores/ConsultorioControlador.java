package com.example.citas_medicas_BE.controladores;

import com.example.citas_medicas_BE.modelos.Consultorio;
import com.example.citas_medicas_BE.servicios.ConsultorioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/consultorios")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ConsultorioControlador {
    @Autowired
    private ConsultorioServicio servicio;

    @GetMapping
    public List<Consultorio> obtenerTodos() {
        return servicio.obtenerTodos();
    }

    @PostMapping
    public ResponseEntity<Consultorio> crear(@RequestBody Consultorio consultorio) {
        Consultorio guardado = servicio.guardar(consultorio);
        return ResponseEntity.ok(guardado);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Consultorio> obtenerPorId(@PathVariable Integer id) {
        Consultorio consultorio = servicio.obtenerPorId(id);
        return consultorio != null ? ResponseEntity.ok(consultorio) : ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Consultorio> actualizar(@PathVariable Integer id, @RequestBody Consultorio consultorio) {
        Consultorio actualizado = servicio.actualizar(id, consultorio);
        return actualizado != null ? ResponseEntity.ok(actualizado) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        servicio.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}