package com.example.genedor_horarios.curso;

import java.util.List;
import java.util.stream.Collectors;

public class CursoAdapter {
    
    public static Curso toModel (CursoEntity entity) {
        if(entity == null) return null;

        Curso model = new Curso();
        model.setId(entity.getId());
        model.setCodigo(entity.getCodigo());
        model.setNombre(entity.getNombre());
        model.setCreditos(entity.getCreditos());

        return model;
    }

    public static CursoEntity toEntity (Curso model) {
        if(model == null) return null;

        CursoEntity entity = new CursoEntity();
        entity.setId(model.getId());
        entity.setCodigo(model.getCodigo());
        entity.setNombre(model.getNombre());
        entity.setCreditos(model.getCreditos());

        return entity;
    }

    public static List<Curso> toModelList(List<CursoEntity> entities){

        return entities.stream()
                .map(CursoAdapter::toModel)
                .collect(Collectors.toList());

    }

}
