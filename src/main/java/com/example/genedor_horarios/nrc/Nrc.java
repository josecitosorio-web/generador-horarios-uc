package com.example.genedor_horarios.nrc;

import com.example.genedor_horarios.curso.Curso;

public class Nrc {
    
    private Long id;
    private String codigo;
    private String docente;
    private String modalidad;
    private Boolean esPrincipal;
    private Curso curso;
    private Nrc nrcVinculado;

    public Nrc () {}

    public Nrc (Long id, String codigo, String docente, String modalidad, Boolean esPrincipal, Curso curso, Nrc nrcVinculado) {

        this.id = id;
        this.codigo = codigo;
        this.docente = docente;
        this.modalidad = modalidad;
        this.esPrincipal = esPrincipal;
        this.curso = curso;
        this.nrcVinculado = nrcVinculado;

    }

    public Long getId() {return this.id;}
    public void setId(Long id) { this.id = id;}

    public String getCodigo() {return this.codigo;}
    public void setCodigo(String codigo) { this.codigo = codigo;}

    public String getDocente() {return this.docente;}
    public void setDocente(String docente) { this.docente = docente;}

    public String getModalidad() {return this.modalidad;}
    public void setModalidad(String modalidad) { this.modalidad = modalidad;}

    public Boolean getEsPrincipal() {return this.esPrincipal;}
    public void setEsPrincipal(Boolean esPrincipal) { this.esPrincipal = esPrincipal;}

    public Curso getCurso() {return this.curso;}
    public void setCurso(Curso curso) {this.curso = curso;}

    public Nrc getNrcVinculado() {return this.nrcVinculado;}
    public void setNrcVinculado(Nrc nrcVinculado) {this.nrcVinculado = nrcVinculado;}

}
