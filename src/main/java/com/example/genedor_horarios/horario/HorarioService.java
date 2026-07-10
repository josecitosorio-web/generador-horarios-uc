package com.example.genedor_horarios.horario;


import com.example.genedor_horarios.bloqueHorario.BloqueHorarioEntity;

public interface HorarioService {
    
    boolean tieneCruce (BloqueHorarioEntity bloqueInsertado, BloqueHorarioEntity bloqueEvaluar);

}
