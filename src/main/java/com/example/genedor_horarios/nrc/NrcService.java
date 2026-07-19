package com.example.genedor_horarios.nrc;

import java.util.List;

public interface NrcService {

    List<Nrc> listarTodos();

    List<NrcEntity> nrcElegibles (Long idCurso, Boolean esPrincipal);

    Nrc buscarPorCodigo (String codigo);

    void registrarNrc (Long id, String codigo, Long cursoId, String docente, String modalidad, Boolean esPrincipal, String nrcVinculado);

    Nrc buscarPorId (Long id);

    void eliminarPorId (Long id);

    
    
}
