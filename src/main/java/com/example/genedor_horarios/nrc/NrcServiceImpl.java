package com.example.genedor_horarios.nrc;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.genedor_horarios.curso.Curso;
import com.example.genedor_horarios.curso.CursoService;

@Service
public class NrcServiceImpl implements NrcService {

    private NrcRepository nrcRepository;
    private CursoService cursoService;

    public NrcServiceImpl(NrcRepository nrcRepository,CursoService cursoService) {

        this.nrcRepository = nrcRepository;
        this.cursoService = cursoService;

    }

    @Override
    public List<Nrc> listarTodos() {

        return NrcAdapter.toModelList(nrcRepository.findAll());

    }

    @Override
    public List<NrcEntity> nrcElegibles(Long idCurso, Boolean esPrincipal) {

        return nrcRepository.findByCursoIdAndEsPrincipal(idCurso, esPrincipal);

    }

    @Override
    public Nrc buscarPorCodigo (String codigo) {

        return NrcAdapter.toModel(nrcRepository.findByCodigo(codigo));

    }

    @Override
    public void registrarNrc(Long id ,String codigo, Long cursoId, String docente, String modalidad, Boolean esPrincipal,
            String nrcVinculado) {

        Curso curso = cursoService.buscarPorId(cursoId);
        Nrc nrcvinculado = buscarPorCodigo(nrcVinculado);

        Nrc nrcNuevo = new Nrc(id, codigo,docente,modalidad,esPrincipal,curso,nrcvinculado);

        nrcRepository.save(NrcAdapter.toEntity(nrcNuevo));
        
        
    }

    @Override
    public Nrc buscarPorId (Long id) {

        return NrcAdapter.toModel(nrcRepository.findById(id).orElse(null));

    }

    @Override
    public void eliminarPorId (Long id) {

        nrcRepository.deleteById(id);

    }

    @Override
    public Long cantidadNrc () {

        return nrcRepository.count();
        
    }

}
