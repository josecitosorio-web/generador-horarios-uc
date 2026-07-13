package com.example.genedor_horarios.horario;


import java.util.List;

import com.example.genedor_horarios.bloqueHorario.BloqueHorarioEntity;

public interface HorarioService {
    
    boolean tieneCruce (BloqueHorarioEntity bloqueInsertado, BloqueHorarioEntity bloqueEvaluar);
    List<BloqueHorarioEntity> obtenerTodosLosBloquesPorNrc(String nrc);
    boolean esCompatible (String nrc , List<BloqueHorarioEntity> horarioActual);
    void generarHorariosElegibles (List<Long> cursosId , List <BloqueHorarioEntity> horarioCndidato, List<List<BloqueHorarioEntity>> listaHorariosElegidos);
    int calcularHoraMuertas (List<BloqueHorarioEntity> horario);
    List<List<BloqueHorarioEntity>> ordenarPorRanking (List<List<BloqueHorarioEntity>> horarios);

}
