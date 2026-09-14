package com.example.genedor_horarios.docente;

import java.util.List;

public interface DocenteService {
    
   List<Docente> listarTodos (); 

   void agregarDocente (Docente docente);
   Docente buscarPorId (Long id);
   void eliminarPorId (Long id);
}
