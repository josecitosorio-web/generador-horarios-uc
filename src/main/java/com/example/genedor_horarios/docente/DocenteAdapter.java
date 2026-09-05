package com.example.genedor_horarios.docente;

import java.util.List;
import java.util.stream.Collectors;

public class DocenteAdapter {
    
    public static Docente toModel (DocenteEntity entity) {
        if(entity == null) return null;

        Docente model = new Docente();
        model.setId(entity.getId());
        model.setNombre(entity.getNombre());
        model.setHorasLaborales(entity.getHorasLaborales());

        return model;
    }

    public static DocenteEntity  toEntity (Docente model){
        if(model == null) return null;

        DocenteEntity entity = new DocenteEntity();
        entity.setId(model.getId());
        entity.setNombre(model.getNombre());
        entity.setHorasLaborales(model.getHorasLaborales());

        return entity;
    }

    public static  List<Docente> toModelList(List<DocenteEntity> entities){

        return entities.stream()
                .map(DocenteAdapter::toModel)
                .collect(Collectors.toList());

    }

}
