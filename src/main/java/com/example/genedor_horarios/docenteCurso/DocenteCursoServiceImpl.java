package com.example.genedor_horarios.docenteCurso;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import com.example.genedor_horarios.curso.CursoEntity;
import com.example.genedor_horarios.curso.CursoRepository;
import com.example.genedor_horarios.docente.DocenteEntity;
import com.example.genedor_horarios.docente.DocenteRepository;
import com.example.genedor_horarios.docente.DocenteService;

@Service
public class DocenteCursoServiceImpl implements DocenteCursoService {

    private final DocenteCursoRepository docenteCursoRepository;
    private final DocenteRepository docenteRepository;
    private final CursoRepository cursoRepository;
    private final DocenteService docenteService;

    public DocenteCursoServiceImpl(DocenteCursoRepository docenteCursoRepository, DocenteRepository docenteRepository,
            CursoRepository cursoRepository, DocenteService docenteService) {

        this.docenteCursoRepository = docenteCursoRepository;
        this.docenteRepository = docenteRepository;
        this.cursoRepository = cursoRepository;
        this.docenteService = docenteService;

    }

    @Override
    public boolean asignar(Long docenteId, Long cursoId) {

        DocenteEntity docente = docenteRepository.findById(docenteId).orElse(null);
        CursoEntity curso = cursoRepository.findById(cursoId).orElse(null);

        List<CursoEntity> cursosAsignados = new ArrayList<>();

        for (DocenteCursoEntity dc : docente.getDocentesCursos()) {

            cursosAsignados.add(dc.getCurso());

        }
        cursosAsignados.add(curso);

        if (!docenteService.cargaHorariaCursos(cursosAsignados, docente)) {

            DocenteCursoEntity docenteCurso = new DocenteCursoEntity(null, docente, curso);

            docenteCursoRepository.save(docenteCurso);

            return true;

        }

        return false;

    }

}
