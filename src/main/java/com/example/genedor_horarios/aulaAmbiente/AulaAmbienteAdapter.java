package com.example.genedor_horarios.aulaAmbiente;

import java.util.List;
import java.util.stream.Collectors;

public class AulaAmbienteAdapter {

    public static AulaAmbiente toModel (AulaAmbienteEntity entity){
        if(entity == null) return null;

        AulaAmbiente model = new AulaAmbiente();
        model.setId(entity.getId());
        model.setCodigo(entity.getCodigo());
        model.setTipoAula(entity.getTipoAula());

        return model;
    }

    public static AulaAmbienteEntity toEntity (AulaAmbiente model){
        if(model == null) return  null;

        AulaAmbienteEntity entity = new AulaAmbienteEntity();
        entity.setId(model.getId());
        entity.setCodigo(model.getCodigo());
        entity.setTipoAula(model.getTipoAula());

        return entity;


    }

    public static List<AulaAmbiente> toModelList(List<AulaAmbienteEntity> entities){

        return entities.stream()
                .map((AulaAmbienteAdapter::toModel))
                .collect(Collectors.toList());

    }
}
