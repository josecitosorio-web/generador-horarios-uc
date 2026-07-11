package com.example.genedor_horarios.horario;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.genedor_horarios.bloqueHorario.BloqueHorarioEntity;
import com.example.genedor_horarios.bloqueHorario.BloqueHorarioRepository;
import com.example.genedor_horarios.nrc.NrcEntity;
import com.example.genedor_horarios.nrc.NrcRepository;
import com.example.genedor_horarios.nrc.NrcService;

@Service
public class HorarioServiceImpl implements HorarioService {

    private BloqueHorarioRepository bloqueHorarioRepository;
    private NrcRepository nrcRepository;
    private NrcService nrcService;

    public HorarioServiceImpl(BloqueHorarioRepository bloqueHorarioRepository, NrcRepository nrcRepository, NrcService nrcService) {
        this.bloqueHorarioRepository = bloqueHorarioRepository;
        this.nrcRepository = nrcRepository;
        this.nrcService = nrcService;
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

        if(nrcEncontrado.getNrcVinculado() != null){


            List<BloqueHorarioEntity> bloquesPrincipales = bloqueHorarioRepository.findByNrcCodigo(nrc);
            List<BloqueHorarioEntity> bloquesLigados = bloqueHorarioRepository.findByNrcCodigo(nrcEncontrado.getNrcVinculado().getCodigo());

            bloquesPrincipales.addAll(bloquesLigados);

            return bloquesPrincipales;
        }

        return bloqueHorarioRepository.findByNrcCodigo(nrc);

    }


    @Override
    public boolean esCompatible (String nrc , List<BloqueHorarioEntity> horarioActual) {

        List<BloqueHorarioEntity> bloquesAEvaluar = obtenerTodosLosBloquesPorNrc(nrc);

        for(BloqueHorarioEntity bloqueInsertado : horarioActual) {

            for(BloqueHorarioEntity bloqueAEvaluar : bloquesAEvaluar) {

                if(tieneCruce(bloqueInsertado, bloqueAEvaluar)) {

                    return false;

                }   

            }

        }

        return true;

    }

    @Override
    public void generarHorariosElegibles (List<Long> cursosId , List <BloqueHorarioEntity> horarioCandidato, List<List<BloqueHorarioEntity>> listaHorariosElegidos) {

        if(cursosId.isEmpty()) {

            listaHorariosElegidos.add(new ArrayList<>(horarioCandidato));

            return;

        }

        List<NrcEntity> nrcElegibles = nrcService.nrcElegibles(cursosId.get(0),true);

        for(NrcEntity nrcElegible : nrcElegibles) {

            if(esCompatible(nrcElegible.getCodigo(), horarioCandidato)) {

                List<BloqueHorarioEntity> bloquesSeleccionados = obtenerTodosLosBloquesPorNrc(nrcElegible.getCodigo());

                horarioCandidato.addAll(bloquesSeleccionados);

                List<Long> cursosPendientes = new ArrayList<>(cursosId);

                cursosPendientes.remove(0);

                generarHorariosElegibles(cursosPendientes, horarioCandidato, listaHorariosElegidos);

                horarioCandidato.removeAll(bloquesSeleccionados);

            }

            

        }

    }

}
