package com.example.genedor_horarios.curso;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class CursoServiceImpl implements CursoService {



    private final CursoRepository cursoRepository;

    CursoServiceImpl(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
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

    
    
}
