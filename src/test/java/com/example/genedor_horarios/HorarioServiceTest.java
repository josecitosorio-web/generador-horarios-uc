package com.example.genedor_horarios;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalTime;

import org.junit.jupiter.api.Test;

import com.example.genedor_horarios.bloqueHorario.BloqueHorarioEntity;
import com.example.genedor_horarios.bloqueHorario.DiaSemana;
import com.example.genedor_horarios.horario.HorarioService;
import com.example.genedor_horarios.horario.HorarioServiceImpl;

public class HorarioServiceTest {

    @Test
    void verificarQueElMetodoCaptureCruces() {

        // preparamos los dos bloques de prueba uno insertado y el otro no

        BloqueHorarioEntity bloqueInsertado = new BloqueHorarioEntity(DiaSemana.LUNES, LocalTime.of(9, 0),
                LocalTime.of(10, 0), "H103", null);
        BloqueHorarioEntity bloqueEvaluado = new BloqueHorarioEntity(DiaSemana.LUNES, LocalTime.of(9, 30),
                LocalTime.of(10, 30), "J402", null);

        // ejecutamos el cruce

        HorarioService horarioService = new HorarioServiceImpl(null, null, null , null);

        Boolean resultado = horarioService.tieneCruce(bloqueInsertado, bloqueEvaluado);

        // imprimimos el resultado

        assertTrue(resultado);

    }

    @Test
    void verificarQueElMetodoNoCaptureConHorasConsecutivas() {

        // preparamos los dos bloques de prueba uno insertao y el otro no
        BloqueHorarioEntity bloqueInsertado = new BloqueHorarioEntity(DiaSemana.LUNES, LocalTime.of(9, 0),
                LocalTime.of(10, 0), "H103", null);
        BloqueHorarioEntity bloqueEvaluado = new BloqueHorarioEntity(DiaSemana.LUNES, LocalTime.of(10, 00),
                LocalTime.of(11, 00), "J402", null);

        // ejecutamos el cruce

        HorarioService horarioService = new HorarioServiceImpl(null, null, null , null);


        Boolean resultado = horarioService.tieneCruce(bloqueInsertado, bloqueEvaluado);

        // imprimimos el resultado

        assertFalse(resultado);

    }

    @Test
    void verificarQueElMetodoNoCpatureConDiasDiferentes() {

        // preparamos los dos bloques de prueba uno insertao y el otro no
        BloqueHorarioEntity bloqueInsertado = new BloqueHorarioEntity(DiaSemana.LUNES, LocalTime.of(9, 0),
                LocalTime.of(10, 0), "H103", null);
        BloqueHorarioEntity bloqueEvaluado = new BloqueHorarioEntity(DiaSemana.MARTES, LocalTime.of(9, 30),
                LocalTime.of(10, 30), "J402", null);

        // ejecutamos el cruce

        HorarioService horarioService = new HorarioServiceImpl(null, null, null, null);


        Boolean resultado = horarioService.tieneCruce(bloqueInsertado, bloqueEvaluado);

        // imprimimos el resultado

        assertFalse(resultado);

    }

    @Test
    void verificarQueElMetodoCaptureConSolapamientoExtremo() {

        // preparamos los dos bloques de prueba uno insertao y el otro no
        BloqueHorarioEntity bloqueInsertado = new BloqueHorarioEntity(DiaSemana.LUNES, LocalTime.of(9, 0),
                LocalTime.of(11, 0), "H103", null);
        BloqueHorarioEntity bloqueEvaluado = new BloqueHorarioEntity(DiaSemana.LUNES, LocalTime.of(9, 30),
                LocalTime.of(10, 30), "J402", null);

        // ejecutamos el cruce

        HorarioService horarioService = new HorarioServiceImpl(null, null, null, null);


        Boolean resultado = horarioService.tieneCruce(bloqueInsertado, bloqueEvaluado);

        // imprimimos el resultado

        assertTrue(resultado);

    }

}
