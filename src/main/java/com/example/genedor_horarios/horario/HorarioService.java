package com.example.genedor_horarios.horario;

import com.example.genedor_horarios.bloqueHorario.BloqueHorario;

public interface HorarioService {
    
    boolean tieneCruce (BloqueHorario bloqueInsertado, BloqueHorario bloqueEvaluar);

}
