package com.example.genedor_horarios.nrc;

import java.util.List;
import java.util.stream.Collectors;

import com.example.genedor_horarios.curso.CursoAdapter;


public class NrcAdapter {

    public static Nrc toModel (NrcEntity entity) {
        if(entity == null) return null;

        Nrc model = new Nrc();
        model.setId(entity.getId());
        model.setCodigo(entity.getCodigo());
        model.setDocente(entity.getDocente());
        model.setModalidad(entity.getModalidad());
        model.setEsPrincipal(entity.getEsPrincipal());
        model.setCurso(CursoAdapter.toModel(entity.getCurso()));
        model.setNrcVinculado(NrcAdapter.toModel(entity.getNrcVinculado()));

        return model;
    }

    public static NrcEntity toEntity (Nrc model) {
        if(model == null) return null;

        NrcEntity entity = new NrcEntity();
        entity.setId(model.getId());
        entity.setCodigo(model.getCodigo());
        entity.setDocente(model.getDocente());
        entity.setModalidad(model.getModalidad());
        entity.setEsPrincipal(model.getEsPrincipal());
        entity.setCurso(CursoAdapter.toEntity(model.getCurso()));
        entity.setNrcVinculado(NrcAdapter.toEntity(model.getNrcVinculado()));

        return entity;
    }

    public static List<Nrc> toModelList(List<NrcEntity> entities){

        return entities.stream()
                .map(NrcAdapter::toModel)
                .collect(Collectors.toList());

    }

}
