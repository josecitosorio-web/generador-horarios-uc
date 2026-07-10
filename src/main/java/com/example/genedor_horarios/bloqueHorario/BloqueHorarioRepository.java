package com.example.genedor_horarios.bloqueHorario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BloqueHorarioRepository extends JpaRepository<BloqueHorarioEntity, Long> {
    
}
