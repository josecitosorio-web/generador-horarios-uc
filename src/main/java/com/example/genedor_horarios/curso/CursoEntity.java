package com.example.genedor_horarios.curso;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.example.genedor_horarios.docenteCurso.DocenteCursoEntity;
import com.example.genedor_horarios.nrc.NrcEntity;
import com.example.genedor_horarios.nrc.TipoNrc;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

@Entity(name = "Curso")
public class CursoEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "codigo")
    private String codigo;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "creditos")
    private Integer creditos;

    @Column(name = "horas_teoricas")
    private Integer horas_teoricas;

    @Column (name = "horas_practicas")
    private Integer horas_practicas;

    @OneToMany(mappedBy = "curso")
    private List<NrcEntity> nrcs = new ArrayList<>();

    @OneToMany(mappedBy = "curso")
    private List<DocenteCursoEntity> docenteCursos = new ArrayList<>();

    public CursoEntity () {}


    public CursoEntity (String codigo, String nombre, Integer creditos, Integer horas_teoricas, Integer horas_practicas) {

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

    public List<DocenteCursoEntity> getDocenteCursos() {return this.docenteCursos;}
    public void setDocentesCursos(List<DocenteCursoEntity> docenteCursos) {this.docenteCursos = docenteCursos;}
    
    public List<NrcEntity> getNrcs() { return this.nrcs; }
    public void setNrcs(List<NrcEntity> nrcs) { this.nrcs = nrcs; }


    

}
