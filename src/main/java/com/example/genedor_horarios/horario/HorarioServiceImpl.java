package com.example.genedor_horarios.horario;

import org.springframework.stereotype.Service;


import com.example.genedor_horarios.bloqueHorario.BloqueHorarioEntity;

@Service
public class HorarioServiceImpl implements HorarioService {

    @Override
    public boolean tieneCruce(BloqueHorarioEntity bloqueInsertado, BloqueHorarioEntity bloqueEvaluar) {

        if (bloqueInsertado.getDia() == bloqueEvaluar.getDia()) {

            if (bloqueEvaluar.getHoraInicio().isBefore(bloqueInsertado.getHoraFin())
                    && bloqueEvaluar.getHoraFin().isAfter(bloqueInsertado.getHoraInicio())) {

                return true;

            }

        }

        return false;

    }

}
