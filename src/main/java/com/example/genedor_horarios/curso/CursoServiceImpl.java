package com.example.genedor_horarios.curso;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.genedor_horarios.horario.HorarioService;
import com.example.genedor_horarios.nrc.NrcEntity;
import com.example.genedor_horarios.nrc.NrcRepository;

@Service
public class CursoServiceImpl implements CursoService {

    private final NrcRepository nrcRepository;

    private final HorarioService horarioService;

    private final CursoRepository cursoRepository;

    CursoServiceImpl(CursoRepository cursoRepository, NrcRepository nrcRepository,HorarioService horarioService) {
        this.cursoRepository = cursoRepository;
        this.nrcRepository = nrcRepository;
        this.horarioService = horarioService;
    }

    @Override
    public List<Curso> listarTodos () {

        return CursoAdapter.toModelList(cursoRepository.findAll());

    }

    @Override
    public void agregarCurso (Curso curso) {

        cursoRepository.save(CursoAdapter.toEntity(curso));

    }

    @Override
    public Curso buscarPorId(Long id) {

        return CursoAdapter.toModel(cursoRepository.findById(id).orElse(null));

    }

    @Override
    public void eliminarPorId(Long id) {

        cursoRepository.deleteById(id);

    }

    @Override
    public Long cantidadCurso () {

        return cursoRepository.count();

    }   

    @Override 
    public boolean programacionHorasSyllabus (Long nrcId) {

        boolean resultado = true;
        double cantidadHoras = 0;

        
        NrcEntity nrcEncontrado = nrcRepository.findById(nrcId).orElse(null);

        if(nrcEncontrado.getEsPrincipal()){

            cantidadHoras += horarioService.obtenerTodosLosBloquesPorNrc(nrcEncontrado.getCodigo()).size() * 1.5;

        }else {

            cantidadHoras += horarioService.obtenerTodosLosBloquesPorNrc(nrcEncontrado.getNrcVinculado().getCodigo()).size() * 1.5;

        }

        if(cantidadHoras != nrcEncontrado.getCurso().getHoras()) {

            resultado = false;

        }


        return  resultado;

    }
}
