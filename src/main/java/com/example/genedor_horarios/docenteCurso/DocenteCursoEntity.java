package com.example.genedor_horarios.docenteCurso;

import com.example.genedor_horarios.curso.CursoEntity;
import com.example.genedor_horarios.docente.DocenteEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity(name = "DocenteCurso")
public class DocenteCursoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name= "docente_id")
    private DocenteEntity docente;

    @ManyToOne
    @JoinColumn(name = "curso_id")
    private CursoEntity curso;

    public DocenteCursoEntity () {}

    public Long getId() { return this.id; }
    public void setId(Long id) { this.id = id; }

    public DocenteEntity getDocente() {return this.docente;}
    public void setDocente(DocenteEntity docente) {this.docente = docente;}

    public CursoEntity getCurso() {return this.curso;}
    public void setCurso(CursoEntity curso) {this.curso = curso;}
    
}
