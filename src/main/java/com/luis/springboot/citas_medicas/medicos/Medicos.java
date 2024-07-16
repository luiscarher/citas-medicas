package com.luis.springboot.citas_medicas.medicos;

import jakarta.persistence.*;

@Entity
@Table(name="medicos")
public class Medicos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 30, nullable = false, name = "nombre")
    private
    String nombre;
    @Column(length = 30, nullable = false, name = "apellidoPaterno")
    private
    String apellidoPaterno;
    @Column(length = 30, nullable = false, name = "apellidoMaterno")
    private
    String apellidoMaterno;
    @Column(length = 30, nullable = false, name = "especialidad")
    private
    String especialidad;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
}
