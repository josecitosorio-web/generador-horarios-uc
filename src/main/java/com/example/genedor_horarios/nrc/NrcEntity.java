package com.example.genedor_horarios.nrc;

import java.util.ArrayList;
import java.util.List;

import com.example.genedor_horarios.bloqueHorario.BloqueHorarioEntity;
import com.example.genedor_horarios.curso.CursoEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity(name = "NRC")
public class NrcEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "codigo")
    private String codigo;

    @Column(name = "docente")
    private String docente;

    @Column(name = "modalidad")
    private String modalidad;

    @Column(name = "es_principal")
    private Boolean esPrincipal;

    @ManyToOne
    @JoinColumn(name = "curso_id")
    private CursoEntity curso;

    @OneToMany(mappedBy = "nrc")
    private List<BloqueHorarioEntity> bloques = new ArrayList<>();

    // relacion reflexivo : relacion asi mismo
    @ManyToOne
    @JoinColumn(name = "nrc_vinculado_id")
    private NrcEntity nrcVinculado;

    public NrcEntity() {}

    public NrcEntity (String codigo,String docente, String modalidad, Boolean esPrincipal, CursoEntity curso) {

        this.codigo = codigo;
        this.docente = docente;
        this.modalidad = modalidad;
        this.esPrincipal = esPrincipal;
        this.curso = curso;

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

    public CursoEntity getCurso() {return this.curso;}
    public void setCurso(CursoEntity curso) { this.curso = curso;}

    public List<BloqueHorarioEntity> getBloques() {return this.bloques;}
    public void setBloques(List<BloqueHorarioEntity> bloques) {this.bloques = bloques;}

    public NrcEntity getNrcVinculado() { return this.nrcVinculado;}
    public void setNrcVinculado(NrcEntity nrcVinculado) { this.nrcVinculado = nrcVinculado;}

    
}
