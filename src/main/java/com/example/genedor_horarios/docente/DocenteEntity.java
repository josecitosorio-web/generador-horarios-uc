package com.example.genedor_horarios.docente;

import java.util.ArrayList;
import java.util.List;

import com.example.genedor_horarios.docenteCurso.DocenteCursoEntity;
import com.example.genedor_horarios.nrc.NrcEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity(name = "Docente")
public class DocenteEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "horas_laborales")
    private Integer horasLaborales;

    @OneToMany(mappedBy = "docente")
    private List<DocenteCursoEntity> docenteCursos = new ArrayList<>();

    @OneToMany(mappedBy = "docente")
    private List<NrcEntity> nrcs = new ArrayList<>();


    public DocenteEntity () {}

    public DocenteEntity (String nombre, Integer horasLaborales) {
        
        this.nombre = nombre;
        this.horasLaborales = horasLaborales;
    }

    public Long getId() { return this.id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() {return this.nombre;}
    public void setNombre(String nombre) {this.nombre = nombre;}

    public Integer getHorasLaborales() {return this.horasLaborales;}
    public void setHorasLaborales(Integer horasLaborales){this.horasLaborales = horasLaborales;}

    public List<DocenteCursoEntity> getDocentesCursos(){return this.docenteCursos;}
    public void setDocentesCursos(List<DocenteCursoEntity> docenteCursos) {this.docenteCursos = docenteCursos;}

    public List<NrcEntity> getNrcs () { return this.nrcs;}
    public void setNrcs (List<NrcEntity> nrcs) {this.nrcs = nrcs;}

}
