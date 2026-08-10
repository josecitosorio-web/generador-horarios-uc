package com.example.genedor_horarios.horario;


import java.util.List;
import java.util.Map;

import com.example.genedor_horarios.bloqueHorario.BloqueHorarioEntity;
import com.example.genedor_horarios.nrc.NrcEntity;

public interface HorarioService {
    
    String validarDatos (List<Long> cursos, String preferencia);
    boolean tieneCruce (BloqueHorarioEntity bloqueInsertado, BloqueHorarioEntity bloqueEvaluar);
    List<BloqueHorarioEntity> obtenerTodosLosBloquesPorNrc(String nrc);
    List<BloqueHorarioEntity> esCompatible (String nrc , List<BloqueHorarioEntity> horarioActual, Map<String, List<BloqueHorarioEntity>> bloquesPorNrc);
    void generarHorariosElegibles (List<Long> cursosId , List <BloqueHorarioEntity> horarioCndidato, List<List<BloqueHorarioEntity>> listaHorariosElegidos,Map<Long, List<NrcEntity>> nrcsPorCurso,Map<String, List<BloqueHorarioEntity>> bloquesPorNrc, String preferencia );
    int calcularHoraMuertas (List<BloqueHorarioEntity> horario, String preferencia);
    List<List<BloqueHorarioEntity>> ordenarPorRanking (List<List<BloqueHorarioEntity>> horarios, String preferencia);
    List<List<BloqueHorarioEntity>> generadorHorario (List<Long> cursosId, String preferencia);
    List<Integer> listHorasMuertas (List<List<BloqueHorarioEntity>> horarios, String preferencia);
    Map<String,BloqueHorarioEntity> mostrarHorario (List<BloqueHorarioEntity> horario);
    List<BloqueHorarioEntity> obtenerListaUnica(List<BloqueHorarioEntity> horario);

}
