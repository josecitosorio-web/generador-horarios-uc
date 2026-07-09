package com.example.genedor_horarios.curso;

import java.util.ArrayList;
import java.util.List;

import com.example.genedor_horarios.nrc.NrcEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity(name = "Curso")
public class CursoEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "creditos")
    private Integer creditos;

    @OneToMany(mappedBy = "curso")
    private List<NrcEntity> nrcs = new ArrayList<>();

    public CursoEntity () {}


    public CursoEntity (String nombre, Integer creditos) {

        this.nombre = nombre;
        this.creditos = creditos;

    }

    public Long getId() { return this.id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() {return this.nombre;}
    public Integer getCreditos() {return this.creditos;}

    public void setNombre(String nombre) { this.nombre = nombre;}
    public void setCreditos(Integer creditos) { this.creditos = creditos;}
    
    public List<NrcEntity> getNrcs() { return this.nrcs; }
    public void setNrcs(List<NrcEntity> nrcs) { this.nrcs = nrcs; }

}
