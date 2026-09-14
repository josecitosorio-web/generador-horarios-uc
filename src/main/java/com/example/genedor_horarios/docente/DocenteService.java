package com.example.genedor_horarios.docente;

import java.util.List;
import com.example.genedor_horarios.curso.CursoEntity;

public interface DocenteService {
    
   List<Docente> listarTodos (); 

   void agregarDocente (Docente docente);
   Docente buscarPorId (Long id);
   void eliminarPorId (Long id);

   boolean cargaHorariaCursos (List<CursoEntity> cursos, DocenteEntity docente);
}
