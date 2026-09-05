package com.example.genedor_horarios.docente;

public class Docente {

    private Long id;
    private String nombre;
    private Integer horasLaborales;

    public Docente () {}

    public Docente (Long id, String nombre, Integer horasLaborales) {

        this.id = id;
        this.nombre = nombre;
        this.horasLaborales = horasLaborales;

    }

    public Long getId() { return this.id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() {return this.nombre;}
    public void setNombre(String nombre) {this.nombre = nombre;}

    public Integer getHorasLaborales() {return this.horasLaborales;}
    public void setHorasLaborales(Integer horasLaborales){this.horasLaborales = horasLaborales;}

}
