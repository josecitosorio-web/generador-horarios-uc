package com.example.genedor_horarios.nrc;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface NrcRepository extends JpaRepository<NrcEntity, Long> {

    NrcEntity findByCodigo (String codigo);
    List<NrcEntity> findByCursoIdAndEsPrincipal(Long idCurso,Boolean esPrincipal);
    
    
}
