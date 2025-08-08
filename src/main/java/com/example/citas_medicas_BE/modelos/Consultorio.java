package com.example.citas_medicas_BE.modelos;

import jakarta.persistence.*;

@Entity
public class Consultorio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String numero;
    private Integer piso;

    public Consultorio() {}

    public Consultorio(String numero, Integer piso) {
        this.numero = numero;
        this.piso = piso;
    }

    // Getters y Setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getNumero() { return numero; }
    public void setNumero(String numero) { this.numero = numero; }
    public Integer getPiso() { return piso; }
    public void setPiso(Integer piso) { this.piso = piso; }
}