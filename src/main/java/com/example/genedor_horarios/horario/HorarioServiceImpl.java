package com.example.genedor_horarios.horario;

import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.example.genedor_horarios.bloqueHorario.BloqueHorarioEntity;
import com.example.genedor_horarios.bloqueHorario.BloqueHorarioRepository;
import com.example.genedor_horarios.bloqueHorario.DiaSemana;
import com.example.genedor_horarios.curso.Curso;
import com.example.genedor_horarios.curso.CursoService;
import com.example.genedor_horarios.nrc.NrcEntity;
import com.example.genedor_horarios.nrc.NrcRepository;
import com.example.genedor_horarios.nrc.NrcService;

@Service
public class HorarioServiceImpl implements HorarioService {

    private final BloqueHorarioRepository bloqueHorarioRepository;
    private final NrcRepository nrcRepository;
    private final NrcService nrcService;
    private final CursoService cursoService;

    public HorarioServiceImpl(BloqueHorarioRepository bloqueHorarioRepository, NrcRepository nrcRepository,
            NrcService nrcService, CursoService cursoService) {
        this.bloqueHorarioRepository = bloqueHorarioRepository;
        this.nrcRepository = nrcRepository;
        this.nrcService = nrcService;
        this.cursoService = cursoService;
    }

    @Override
    public String validarDatos(List<Long> cursos, String preferencia) {

        if (preferencia == null || preferencia.isEmpty()) {

            return "Debe elegir un turno";

        }

        if (cursos == null || cursos.isEmpty()) {

            return "Debe elegir un curso";

        }

        List<Curso> listaCursos = new ArrayList<>();

        for (Long curso : cursos) {

            listaCursos.add(cursoService.buscarPorId(curso));

        }

        int creditos = 0;

        for (Curso curso : listaCursos) {

            creditos += curso.getCreditos();

        }

        if (creditos < 12) {

            return "Debe escoger un mínimo de 12 créditos";

        }

        if (cursos.size() > 8) {

            return "Kairos permite generar horarios con un máximo de 8 cursos por consulta";

        }

        return "";

    }

    @Override
    public boolean tieneCruce(BloqueHorarioEntity bloqueInsertado, BloqueHorarioEntity bloqueEvaluar) {

        if (bloqueInsertado.getDia() == bloqueEvaluar.getDia()) {

            if (bloqueEvaluar.getHoraInicio().isBefore(bloqueInsertado.getHoraFin())
                    && bloqueEvaluar.getHoraFin().isAfter(bloqueInsertado.getHoraInicio())) {

                return true;

            }

        }

        return false;

    }

    @Override
    public List<BloqueHorarioEntity> obtenerTodosLosBloquesPorNrc(String nrc) {

        NrcEntity nrcEncontrado = nrcRepository.findByCodigo(nrc);

        if (nrcEncontrado.getNrcVinculado() != null) {

            List<BloqueHorarioEntity> bloquesPrincipales = bloqueHorarioRepository.findByNrcCodigo(nrc);
            List<BloqueHorarioEntity> bloquesLigados = bloqueHorarioRepository
                    .findByNrcCodigo(nrcEncontrado.getNrcVinculado().getCodigo());

            bloquesPrincipales.addAll(bloquesLigados);

            return bloquesPrincipales;
        }

        return bloqueHorarioRepository.findByNrcCodigo(nrc);

    }

    @Override
    public List<BloqueHorarioEntity> esCompatible(String nrc, List<BloqueHorarioEntity> horarioActual,
            Map<String, List<BloqueHorarioEntity>> bloquesPorNrc) {

        List<BloqueHorarioEntity> bloquesAEvaluar = bloquesPorNrc.get(nrc);

        for (BloqueHorarioEntity bloqueInsertado : horarioActual) {

            for (BloqueHorarioEntity bloqueAEvaluar : bloquesAEvaluar) {

                if (tieneCruce(bloqueInsertado, bloqueAEvaluar)) {

                    return null;

                }

            }

        }

        return bloquesAEvaluar;

    }

    @Override
    public List<List<BloqueHorarioEntity>> generadorHorario(List<Long> cursosId, String preferencia) {

        cursosId.sort(Comparator.comparing(cursoId -> nrcService.cantidadNrc(cursoId)));

        List<BloqueHorarioEntity> horarioCandidato = new ArrayList<>();

        List<List<BloqueHorarioEntity>> listaHorariosElegidos = new ArrayList<>();

        Map<Long, List<NrcEntity>> nrcsPorCurso = new HashMap<>();
        Map<String, List<BloqueHorarioEntity>> bloquesPorNrc = new HashMap<>();

        for (Long cursoId : cursosId) {

            List<NrcEntity> nrcs = nrcService.nrcElegibles(cursoId, true);

            nrcsPorCurso.put(cursoId, nrcs);

            for (NrcEntity nrc : nrcs) {

                List<BloqueHorarioEntity> bloquesHorarios = obtenerTodosLosBloquesPorNrc(nrc.getCodigo());
                bloquesPorNrc.put(nrc.getCodigo(), bloquesHorarios);

            }

        }

        generarHorariosElegibles(cursosId, horarioCandidato, listaHorariosElegidos, nrcsPorCurso, bloquesPorNrc, preferencia);

        ordenarPorRanking(listaHorariosElegidos, preferencia);

        
        return listaHorariosElegidos;

    }

    @Override
    public void generarHorariosElegibles(
            List<Long> cursosId, 
            List<BloqueHorarioEntity> horarioCandidato,
            List<List<BloqueHorarioEntity>> listaHorariosElegidos, 
            Map<Long, List<NrcEntity>> nrcsPorCurso,
            Map<String, List<BloqueHorarioEntity>> bloquesPorNrc, String preferencia) {

        if (cursosId.isEmpty()) {

            List<BloqueHorarioEntity> posibleHorario = new ArrayList<>(horarioCandidato);

            if(listaHorariosElegidos.size() < 5) {

                listaHorariosElegidos.add(posibleHorario);

                 return;

            }

            List<BloqueHorarioEntity> peor = Collections.max(listaHorariosElegidos,Comparator.comparing(horario -> calcularHoraMuertas(horario, preferencia)));

            int puntajePeor = calcularHoraMuertas(peor, preferencia);
            int puntajeEvaluar = calcularHoraMuertas(posibleHorario, preferencia);

            if(puntajeEvaluar < puntajePeor) {

                listaHorariosElegidos.remove(peor);
                listaHorariosElegidos.add(posibleHorario);

            }

            return;

        }

        List<NrcEntity> nrcElegibles = nrcsPorCurso.get(cursosId.get(0));

        for (NrcEntity nrcElegible : nrcElegibles) {

            List<BloqueHorarioEntity> bloquesSeleccionados = esCompatible(nrcElegible.getCodigo(), horarioCandidato,
                    bloquesPorNrc);

            if (bloquesSeleccionados != null) {

                horarioCandidato.addAll(bloquesSeleccionados);

                List<Long> cursosPendientes = new ArrayList<>(cursosId);

                cursosPendientes.remove(0);

                generarHorariosElegibles(cursosPendientes, horarioCandidato, listaHorariosElegidos, nrcsPorCurso, bloquesPorNrc, preferencia);

                horarioCandidato.removeAll(bloquesSeleccionados);

            }

        }

    }

    public static Map<DiaSemana, List<BloqueHorarioEntity>> agruparYordenarPorDia(List<BloqueHorarioEntity> horario) {

        Map<DiaSemana, List<BloqueHorarioEntity>> bloquesPorDia = new HashMap<>();

        for (BloqueHorarioEntity bloque : horario) {

            bloquesPorDia.computeIfAbsent(bloque.getDia(), k -> new ArrayList<>()).add(bloque);

        }

        for (List<BloqueHorarioEntity> bloquesDelDia : bloquesPorDia.values()) {

            bloquesDelDia.sort(Comparator.comparing(BloqueHorarioEntity::getHoraInicio));

        }

        return bloquesPorDia;

    }

    @Override
    public int calcularHoraMuertas(List<BloqueHorarioEntity> horario, String preferencia) {

        int puntaje = 0;
        boolean condicionAlmuerzo;

        Map<DiaSemana, List<BloqueHorarioEntity>> bloquesPorDia = agruparYordenarPorDia(horario);

        for (List<BloqueHorarioEntity> bloquesDelDia : bloquesPorDia.values()) {

            for (int i = 0; i < bloquesDelDia.size() - 1; i++) {

                BloqueHorarioEntity actual = bloquesDelDia.get(i);
                BloqueHorarioEntity siguiente = bloquesDelDia.get(i + 1);

                Long tiempoMuerto = Duration.between(actual.getHoraFin(), siguiente.getHoraInicio()).toMinutes();

                if (actual.getHoraFin().equals(LocalTime.of(13, 29))
                        && siguiente.getHoraInicio().equals(LocalTime.of(14, 0))) {

                    condicionAlmuerzo = true;

                } else {
                    condicionAlmuerzo = false;
                }

                if (tiempoMuerto > 11 && !condicionAlmuerzo) {

                    puntaje += tiempoMuerto;

                }

            }

            for (int i = 0; i < bloquesDelDia.size(); i++) {

                BloqueHorarioEntity actual = bloquesDelDia.get(i);

                if (preferencia.equals("MANANA")) {

                    if (actual.getHoraFin().isAfter(LocalTime.of(13, 29))) {

                        puntaje += 60;

                    }

                }

                if (preferencia.equals("TARDE")) {

                    if (actual.getHoraFin().isBefore(LocalTime.of(14, 0))) {

                        puntaje += 60;

                    }

                }

            }

        }

        return puntaje;

    }

    @Override
    public List<List<BloqueHorarioEntity>> ordenarPorRanking(List<List<BloqueHorarioEntity>> horarios,
            String preferencia) {

        horarios.sort(Comparator.comparing(horario -> calcularHoraMuertas(horario, preferencia)));

        return horarios;

    }

    @Override
    public List<Integer> listHorasMuertas(List<List<BloqueHorarioEntity>> horarios, String preferencia) {

        List<Integer> puntajes = new ArrayList<>();

        for (List<BloqueHorarioEntity> horario : horarios) {

            puntajes.add(calcularHoraMuertas(horario, preferencia));

        }

        return puntajes;

    }

    @Override
    public Map<String, BloqueHorarioEntity> mostrarHorario(List<BloqueHorarioEntity> horario) {

        Map<String, BloqueHorarioEntity> horarioMap = new HashMap<>();

        DateTimeFormatter formato = DateTimeFormatter.ofPattern("HH:mm");

        for (BloqueHorarioEntity bloque : horario) {

            String horaInicioFormateado = bloque.getHoraInicio().format(formato);

            String clave = bloque.getDia().toString() + "-" + horaInicioFormateado;

            horarioMap.put(clave, bloque);

        }

        return horarioMap;

    }

    @Override
    public List<BloqueHorarioEntity> obtenerListaUnica(List<BloqueHorarioEntity> horario) {

        Set<String> codigo = new HashSet<>();
        List<BloqueHorarioEntity> listaUnica = new ArrayList<>();

        for (BloqueHorarioEntity bloque : horario) {

            if (codigo.add(bloque.getNrc().getCodigo())) {

                listaUnica.add(bloque);

            }

        }

        return listaUnica;

    }

}
