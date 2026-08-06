package com.example.genedor_horarios.curso;

import java.util.List;

public interface CursoService {

    List<Curso> listarTodos ();

    void agregarCurso (Curso curso);
    Curso  buscarPorId (Long id);
    void eliminarPorId (Long id);
    Long cantidadCurso ();
    
    
}