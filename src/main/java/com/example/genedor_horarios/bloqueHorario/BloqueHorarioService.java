package com.example.genedor_horarios.bloqueHorario;

import java.time.LocalTime;
import java.util.List;
import java.util.Map;

public interface BloqueHorarioService {

    List<BloqueHorario> listarTodos();
    void registrarBloque(Long id, DiaSemana dia, LocalTime horaInicio, LocalTime horaFin, String aula, String nrcCodigo);
    BloqueHorario encontrarPorId (Long id);
    void eliminarPorId(Long id);
    Map<String,String> mostrarHorario (String nrc);
}
