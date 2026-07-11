package com.example.genedor_horarios.horario;


import java.util.List;

import com.example.genedor_horarios.bloqueHorario.BloqueHorarioEntity;

public interface HorarioService {
    
    boolean tieneCruce (BloqueHorarioEntity bloqueInsertado, BloqueHorarioEntity bloqueEvaluar);
    List<BloqueHorarioEntity> obtenerTodosLosBloquesPorNrc(String nrc);

}
