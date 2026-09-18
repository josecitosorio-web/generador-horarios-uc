package com.example.genedor_horarios.bloqueHorario;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.genedor_horarios.nrc.Nrc;
import com.example.genedor_horarios.nrc.NrcAdapter;
import com.example.genedor_horarios.nrc.NrcEntity;
import com.example.genedor_horarios.nrc.NrcRepository;

@Service
public class BloqueHorarioServiceImpl implements BloqueHorarioService {

    private final BloqueHorarioRepository bloqueHorarioRepository;
    private final NrcRepository nrcRepository;

    public BloqueHorarioServiceImpl(BloqueHorarioRepository bloqueHorarioRepository, NrcRepository nrcRepository) {

        this.bloqueHorarioRepository = bloqueHorarioRepository;
        this.nrcRepository = nrcRepository;
    }

    @Override
    public List<BloqueHorario> listarTodos() {

        return BloqueHorarioAdapter.toModelList(bloqueHorarioRepository.findAll());

    }

    @Override
    public void registrarBloque(Long id, DiaSemana dia, LocalTime horaInicio, LocalTime horaFin, String aula,
            String nrcCodigo) {

                // Nrc nrc = nrcService.buscarPorCodigo(nrcCodigo);
                Nrc nrc = NrcAdapter.toModel(nrcRepository.findByCodigo(nrcCodigo));

                BloqueHorario bloqueNuevo = new BloqueHorario(id,dia,horaInicio,horaFin,aula,nrc);

                bloqueHorarioRepository.save(BloqueHorarioAdapter.toEntity(bloqueNuevo));


    }

    @Override
    public BloqueHorario encontrarPorId (Long id) {

        return BloqueHorarioAdapter.toModel(bloqueHorarioRepository.findById(id).orElse(null));

    }

    @Override
    public void eliminarPorId(Long id) {

        bloqueHorarioRepository.deleteById(id);

    }

    @Override
    public Map<String,String> mostrarHorario (String nrc) {

        Map<String,String> horarioMap = new HashMap<>();

        List<BloqueHorarioEntity> bloqueHorarios = obtenerTodosLosBloquesPorNrc(nrc);

        DateTimeFormatter formato = DateTimeFormatter.ofPattern("HH:mm");

        for(BloqueHorarioEntity bloque : bloqueHorarios) {

            String horaInicioFormateado = bloque.getHoraInicio().format(formato);

            String clave = bloque.getDia().toString() + "-" + horaInicioFormateado;

            horarioMap.put(clave, bloque.getNrc().getCurso().getNombre());

        }


        return horarioMap;
    }

    @Override
    public Long cantidadBloque () {

        return bloqueHorarioRepository.count();

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

}
