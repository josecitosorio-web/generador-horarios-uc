package com.example.genedor_horarios.curso;

public class Curso {
    
    private Long id;
    private String codigo;
    private String nombre;
    private Integer creditos;
    private Integer horas_teoricas;
    private Integer horas_practicas;

    public Curso () {}

    public Curso (String codigo, String nombre, Integer creditos, Integer horas_teoricas, Integer horas_practicas) {

        this.codigo = codigo;
        this.nombre = nombre;
        this.creditos = creditos;
        this.horas_teoricas = horas_teoricas;
        this.horas_practicas = horas_practicas;

    }

    public Long getId() { return this.id; }
    public void setId(Long id) { this.id = id; }

    public String getCodigo() {return this.codigo;}
    public void setCodigo(String codigo) { this.codigo = codigo;}

    public String getNombre() {return this.nombre;}
    public Integer getCreditos() {return this.creditos;}

    public void setNombre(String nombre) { this.nombre = nombre;}
    public void setCreditos(Integer creditos) { this.creditos = creditos;}

    public Integer getHorasTeoricas() {return this.horas_teoricas;}
    public void setHorasTeoricas(Integer horas_teoricas) { this.horas_teoricas = horas_teoricas;}

    public Integer getHorasPracticas() {return this.horas_practicas;}
    public void setHorasPracticas(Integer horas_practicas) { this.horas_practicas = horas_practicas;}
    
    

}
