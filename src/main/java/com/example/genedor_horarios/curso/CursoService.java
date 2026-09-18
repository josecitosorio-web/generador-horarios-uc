package com.example.genedor_horarios.curso;

import java.util.List;

import com.example.genedor_horarios.bloqueHorario.BloqueHorarioEntity;

public interface CursoService {

    List<Curso> listarTodos ();

    void agregarCurso (Curso curso);
    Curso  buscarPorId (Long id);
    void eliminarPorId (Long id);
    Long cantidadCurso ();
    boolean programacionHorasSyllabus (CursoEntity curso, List<BloqueHorarioEntity> bloquesCandidatos);  
}