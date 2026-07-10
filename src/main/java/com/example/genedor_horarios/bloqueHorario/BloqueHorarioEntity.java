package com.example.genedor_horarios.bloqueHorario;

import java.time.LocalTime;

import com.example.genedor_horarios.nrc.NrcEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity(name = "BloqueHorario")
public class BloqueHorarioEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "dia")
    private DiaSemana dia;

    @Column(name = "hora_inicio")
    private LocalTime horaInicio;

    @Column(name = "hora_fin")
    private LocalTime horaFin;

    @Column(name = "aula")
    private String aula;

    @ManyToOne
    @JoinColumn(name = "nrc_id")
    private NrcEntity nrc;

    public BloqueHorarioEntity () {}

    public BloqueHorarioEntity (DiaSemana dia, LocalTime horaInicio, LocalTime horaFin, String aula, NrcEntity nrc) {

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

    public NrcEntity getNrc () { return this.nrc;}
    public void setNrc (NrcEntity nrc) { this.nrc = nrc;}

}
