package com.example.genedor_horarios.bloqueHorario;

import java.time.LocalTime;

import com.example.genedor_horarios.nrc.Nrc;

public class BloqueHorario {
    
    private Long id;
    private DiaSemana dia;
    private LocalTime horaInicio;
    private LocalTime horaFin;
    private String aula;
    private Nrc nrc;

    public BloqueHorario () {}

    public BloqueHorario (Long id, DiaSemana dia, LocalTime horaInicio, LocalTime horaFin, String aula, Nrc nrc) {

        this.id = id;
        this.dia = dia;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.aula = aula;
        this.nrc = nrc;

    }

    public Long getId () {return this.id;}
    public void setId (Long id) {this.id = id;}

    public DiaSemana getDia () { return this.dia;}
    public void setDia (DiaSemana dia) {this.dia = dia;}

    public LocalTime getHoraInicio () {return this.horaInicio;}
    public void setHoraInicio (LocalTime horaInicio) {this.horaInicio = horaInicio;} 

    public LocalTime getHoraFin () {return this.horaFin;}
    public void setHoraFin (LocalTime horaFin) {this.horaFin = horaFin;}

    public String getAula () {return this.aula;}
    public void setAula (String aula) {this.aula = aula;}

    public Nrc getNrc () {return this.nrc;}
    public void setNrc (Nrc nrc) {this.nrc = nrc;}



}
