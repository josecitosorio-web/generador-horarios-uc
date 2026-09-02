package com.example.genedor_horarios.aulaAmbiente;

import java.util.ArrayList;
import java.util.List;

import com.example.genedor_horarios.bloqueHorario.BloqueHorarioEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity(name = "AulaAmbiente")
public class AulaAmbienteEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "codigo")
    private String codigo;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo")
    private TipoAula tipoAula;

    @OneToMany(mappedBy = "aulaAmbiente")
    private List<BloqueHorarioEntity> bloques = new ArrayList<>();

    public AulaAmbienteEntity() {}

    public AulaAmbienteEntity (String codigo,TipoAula tipoAula ) {

        this.codigo = codigo;
        this.tipoAula = tipoAula;

    }

    public String getCodigo() {return this.codigo;}
    public void setCodigo(String codigo) {this.codigo = codigo;}

    public TipoAula getTipoAula () { return this.tipoAula;}
    public void setTipoAula ( TipoAula tipoAula) {this.tipoAula = tipoAula;}


}
