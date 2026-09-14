package com.example.genedor_horarios.aulaAmbiente;

import java.util.List;

public interface AulaAmbienteService{
    
    List<AulaAmbiente> listarTodos ();

    void agregarAula (AulaAmbiente aulaAmbiente);
    AulaAmbiente buscarPorId (Long id);
    void eliminarPorId (Long id);

}
