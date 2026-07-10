package com.example.genedor_horarios.nrc;

public class Nrc {
    
    private Long id;
    private String codigo;
    private String docente;
    private String modalidad;
    private Boolean esPrincipal;

    public Nrc () {}

    public Nrc (String codigo, String docente, String modalidad, Boolean esPrincipal) {

        this.codigo = codigo;
        this.docente = docente;
        this.modalidad = modalidad;
        this.esPrincipal = esPrincipal;

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

}
