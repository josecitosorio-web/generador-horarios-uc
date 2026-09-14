package com.example.genedor_horarios.docente;

import java.util.List;

import org.springframework.stereotype.Service;
import com.example.genedor_horarios.curso.CursoEntity;

@Service 
public class DocenteServiceImpl implements DocenteService {
    
    private final DocenteRepository docenteRepository;

    DocenteServiceImpl (DocenteRepository docenteRepository) {
        this.docenteRepository = docenteRepository;
    }

    @Override 
    public  List<Docente> listarTodos () {
        return DocenteAdapter.toModelList(docenteRepository.findAll());
    }


    @Override 
    public void agregarDocente (Docente docente) {

        docenteRepository.save(DocenteAdapter.toEntity(docente));

    }

    @Override 
    public Docente buscarPorId (Long id) {

        return DocenteAdapter.toModel(docenteRepository.findById(id).orElse(null));

    }

    @Override 
    public void eliminarPorId (Long id){

        docenteRepository.deleteById(id);

    }

    @Override 
    public boolean cargaHorariaCursos (List<CursoEntity> cursos, DocenteEntity docente) {

        int horasTotales = 0;
        boolean resultado = true;

        for(CursoEntity curso : cursos) {

            horasTotales += curso.getHoras();

        }

        if(horasTotales <= docente.getHorasLaborales()) {

            resultado = false;

        }


        return resultado;


    }

}
