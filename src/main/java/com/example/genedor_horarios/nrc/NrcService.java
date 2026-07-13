package com.example.genedor_horarios.nrc;

import java.util.List;

public interface NrcService {

    List<NrcEntity> nrcElegibles (Long idCurso, Boolean esPrincipal);
    
}
