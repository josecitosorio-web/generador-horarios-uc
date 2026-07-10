package com.example.genedor_horarios.curso;

public class Curso {
    
    private Long id;
    private String codigo;
    private String nombre;
    private Integer creditos;

    public Curso () {}

    public Curso (String codigo, String nombre, Integer creditos) {

        this.codigo = codigo;
        this.nombre = nombre;
        this.creditos = creditos;

    }

    public Long getId() { return this.id; }
    public void setId(Long id) { this.id = id; }

    public String getCodigo() {return this.codigo;}
    public void setCodigo(String codigo) { this.codigo = codigo;}

    public String getNombre() {return this.nombre;}
    public Integer getCreditos() {return this.creditos;}

    public void setNombre(String nombre) { this.nombre = nombre;}
    public void setCreditos(Integer creditos) { this.creditos = creditos;}
    
    

}
