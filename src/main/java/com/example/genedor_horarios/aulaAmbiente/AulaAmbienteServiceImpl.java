package com.example.genedor_horarios.aulaAmbiente;

import java.util.List;

import org.springframework.stereotype.Service;

@Service 
public class AulaAmbienteServiceImpl implements AulaAmbienteService {
    
    private final AulaAmbienteRepository aulaAmbienteRepository;

    AulaAmbienteServiceImpl (AulaAmbienteRepository aulaAmbienteRepository){

        this.aulaAmbienteRepository = aulaAmbienteRepository;

    }

    @Override 
    public List<AulaAmbiente> listarTodos () {

        return  AulaAmbienteAdapter.toModelList(aulaAmbienteRepository.findAll());

    }

    @Override 
    public void agregarAula (AulaAmbiente aulaAmbiente) {

        aulaAmbienteRepository.save(AulaAmbienteAdapter.toEntity(aulaAmbiente));

    }

    @Override 
    public AulaAmbiente buscarPorId (Long id) {

        return AulaAmbienteAdapter.toModel(aulaAmbienteRepository.findById(id).orElse(null));

    }

    @Override 
    public void eliminarPorId (Long id) {

        aulaAmbienteRepository.deleteById(id);

    }

}
