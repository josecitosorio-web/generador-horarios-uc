package com.example.genedor_horarios.bloqueHorario;

import java.time.LocalTime;

public class BloqueHorario {
    
    private Long id;
    private DiaSemana dia;
    private LocalTime horaInicio;
    private LocalTime horaFin;
    private String aula;

    public BloqueHorario () {}

    public BloqueHorario (DiaSemana dia, LocalTime horaInicio, LocalTime horaFin, String aula) {

        this.dia = dia;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.aula = aula;

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



}
