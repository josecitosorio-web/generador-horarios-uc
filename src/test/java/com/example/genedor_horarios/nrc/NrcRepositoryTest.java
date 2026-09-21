package com.example.genedor_horarios.nrc;

import java.time.LocalTime;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.jpa.test.autoconfigure.TestEntityManager;

import static org.assertj.core.api.Assertions.assertThat;

import com.example.genedor_horarios.docente.*;
import com.example.genedor_horarios.curso.*;
import com.example.genedor_horarios.aulaAmbiente.*;
import com.example.genedor_horarios.bloqueHorario.*;

@DataJpaTest
public class NrcRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private DocenteRepository docenteRepository;

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private NrcRepository nrcRepository;

    @Autowired
    private AulaAmbienteRepository aulaAmbienteRepository;

    @Autowired
    private BloqueHorarioRepository bloqueHorarioRepository;

    @Test
    void crear_guardar_docente_curso_aula_nrc() {

        // creacion del docente
        DocenteEntity docente = new DocenteEntity("Condori", 20);
        docente = docenteRepository.save(docente);

        // creacion del curso
        CursoEntity curso = new CursoEntity("ASUC001", "Redes Computadores", 4, 1,2);
        curso = cursoRepository.save(curso);

        // Creacion del aula ambiente
        AulaAmbienteEntity aulaAmbiente = new AulaAmbienteEntity("J301", TipoAula.AULA_ESPECIALIDAD);
        aulaAmbiente = aulaAmbienteRepository.save(aulaAmbiente);

        // Creación de los nrcs tanto teoria como practica
        NrcEntity nrcTeoria = new NrcEntity("1234", "Presencial", true, curso, docente);
        nrcTeoria = nrcRepository.save(nrcTeoria);

        NrcEntity nrcPractica = new NrcEntity("5678", "Presencial", false, curso, docente);
        nrcPractica.setNrcVinculado(nrcTeoria);
        nrcPractica = nrcRepository.save(nrcPractica);

        // Creacion de bloques de horario
        BloqueHorarioEntity bloqueHorario_1 = new BloqueHorarioEntity(DiaSemana.LUNES, LocalTime.of(7, 0),
                LocalTime.of(8, 29), nrcTeoria, aulaAmbiente);
        bloqueHorario_1 = bloqueHorarioRepository.save(bloqueHorario_1);

        BloqueHorarioEntity bloqueHorario_2 = new BloqueHorarioEntity(DiaSemana.MARTES, LocalTime.of(2, 0),
                LocalTime.of(3, 29), nrcPractica, aulaAmbiente);
        bloqueHorario_2 = bloqueHorarioRepository.save(bloqueHorario_2);

        // Una vez creado todo llamamos al nrc creado para ver si recuerda todo
        entityManager.flush();
        entityManager.clear();
        Optional<NrcEntity> nrcRecuperado = nrcRepository.findById(nrcPractica.getId());

        // Usamos el assert para verificar que los datos fueron llenados correctamente

        // verificamos que el datoe ste presente
        assertThat(nrcRecuperado).isPresent();

        // verificamos que los datos coinciden correctamente con los datos insertados
        assertThat(nrcRecuperado.get().getCurso().getCodigo()).isEqualTo(curso.getCodigo());
        assertThat(nrcRecuperado.get().getDocente().getNombre()).isEqualTo(docente.getNombre());
        assertThat(nrcRecuperado.get().getNrcVinculado().getCodigo()).isEqualTo(nrcTeoria.getCodigo());
        assertThat(nrcRecuperado.get().getBloques()).hasSize(1);

    }

}
