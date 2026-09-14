package com.example.genedor_horarios.docenteCurso;

import com.example.genedor_horarios.docente.Docente;
import com.example.genedor_horarios.curso.Curso;

public class DocenteCurso {
    
    private Long id;

    private Docente docente;

    private Curso curso;

    public DocenteCurso () {}

    public DocenteCurso ( Long id, Docente docente, Curso curso) {

        this.id = id;
        this.docente = docente;
        this.curso = curso;

    }

    public Long getId() { return this.id; }
    public void setId(Long id) {this.id = id;}

    public Docente getDocente() {return this.docente;}
    public void setDocente(Docente docente) {this.docente = docente;}

    public Curso getCurso() {return this.curso;}
    public void setCurso(Curso curso) {this.curso = curso;}

}




