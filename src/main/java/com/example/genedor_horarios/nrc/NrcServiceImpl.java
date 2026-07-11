package com.example.genedor_horarios.nrc;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class NrcServiceImpl implements NrcService {

    private NrcRepository nrcRepository;

    public NrcServiceImpl (NrcRepository nrcRepository) {

        this.nrcRepository = nrcRepository;

    }

    @Override
    public List<NrcEntity> nrcElegibles (Long idCurso ,Boolean esPrincipal) {

        return nrcRepository.findByCursoIdAndEsPrincipal(idCurso, esPrincipal);

    }
    
}
