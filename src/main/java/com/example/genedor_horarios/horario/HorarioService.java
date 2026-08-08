package com.example.genedor_horarios.horario;


import java.util.List;
import java.util.Map;

import com.example.genedor_horarios.bloqueHorario.BloqueHorarioEntity;

public interface HorarioService {
    
    String validarDatos (List<Long> cursos, String preferencia);
    boolean tieneCruce (BloqueHorarioEntity bloqueInsertado, BloqueHorarioEntity bloqueEvaluar);
    List<BloqueHorarioEntity> obtenerTodosLosBloquesPorNrc(String nrc);
    boolean esCompatible (String nrc , List<BloqueHorarioEntity> horarioActual);
    void generarHorariosElegibles (List<Long> cursosId , List <BloqueHorarioEntity> horarioCndidato, List<List<BloqueHorarioEntity>> listaHorariosElegidos);
    int calcularHoraMuertas (List<BloqueHorarioEntity> horario);
    int obtenerPuntaje (List<BloqueHorarioEntity> horario, String preferencia);
    int puntajeFinal (List<BloqueHorarioEntity> horario, String preferencia);
    List<List<BloqueHorarioEntity>> ordenarPorRanking (List<List<BloqueHorarioEntity>> horarios, String preferencia);
    List<List<BloqueHorarioEntity>> generadorHorario (List<Long> cursosId, String preferencia);
    List<Integer> listHorasMuertas (List<List<BloqueHorarioEntity>> horarios);
    Map<String,String> mostrarHorario (List<BloqueHorarioEntity> horario);
    List<BloqueHorarioEntity> obtenerListaUnica(List<BloqueHorarioEntity> horario);

}
