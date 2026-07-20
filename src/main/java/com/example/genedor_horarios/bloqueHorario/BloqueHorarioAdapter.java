package com.example.genedor_horarios.bloqueHorario;

import java.util.List;
import java.util.stream.Collectors;

import com.example.genedor_horarios.nrc.NrcAdapter;

public class BloqueHorarioAdapter {

    public static BloqueHorario toModel (BloqueHorarioEntity entity) {
        if(entity == null) return null;

        BloqueHorario model = new BloqueHorario();
        model.setId(entity.getId());
        model.setDia(entity.getDia());
        model.setHoraInicio(entity.getHoraInicio());
        model.setHoraFin(entity.getHoraFin());
        model.setAula(entity.getAula());
        model.setNrc(NrcAdapter.toModel(entity.getNrc()));

        return model;
    }

    public static BloqueHorarioEntity toEntity (BloqueHorario model) {
        if(model == null) return null;

        BloqueHorarioEntity entity = new BloqueHorarioEntity();
        entity.setId(model.getId());
        entity.setDia(model.getDia());
        entity.setHoraInicio(model.getHoraInicio());
        entity.setHoraFin(model.getHoraFin());
        entity.setAula(model.getAula());
        entity.setNrc(NrcAdapter.toEntity(model.getNrc()));

        return entity;
    }

    public static List<BloqueHorario> toModelList(List<BloqueHorarioEntity> entities){

        return entities.stream()
                .map(BloqueHorarioAdapter::toModel)
                .collect(Collectors.toList());

    }
    
}
