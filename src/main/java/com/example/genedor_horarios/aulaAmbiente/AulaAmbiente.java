package com.example.genedor_horarios.aulaAmbiente;

public class AulaAmbiente {
    
    private Long id;
    private String codigo;
    private TipoAula tipoAula;

    public AulaAmbiente(){}

    public AulaAmbiente ( Long id, String codigo, TipoAula tipoAula ){

        this.id = id;
        this.codigo = codigo;
        this.tipoAula = tipoAula;

    }

    public Long getId () {return  this.id;}
    public void setId (Long id) {this.id = id;}

    public String getCodigo() {return this.codigo;}
    public void setCodigo(String codigo) {this.codigo = codigo;}

    public TipoAula getTipoAula () { return this.tipoAula;}
    public void setTipoAula ( TipoAula tipoAula) {this.tipoAula = tipoAula;}

}
