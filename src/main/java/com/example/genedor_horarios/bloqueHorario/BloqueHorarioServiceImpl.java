package com.example.genedor_horarios.bloqueHorario;

import java.time.LocalTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.genedor_horarios.nrc.Nrc;
import com.example.genedor_horarios.nrc.NrcService;

@Service
public class BloqueHorarioServiceImpl implements BloqueHorarioService {

    private final BloqueHorarioRepository bloqueHorarioRepository;
    private final NrcService nrcService;

    public BloqueHorarioServiceImpl(BloqueHorarioRepository bloqueHorarioRepository, NrcService nrcService) {

        this.bloqueHorarioRepository = bloqueHorarioRepository;
        this.nrcService = nrcService;

    }

    @Override
    public List<BloqueHorario> listarTodos() {

        return BloqueHorarioAdapter.toModelList(bloqueHorarioRepository.findAll());

    }

    @Override
    public void registrarBloque(Long id, DiaSemana dia, LocalTime horaInicio, LocalTime horaFin, String aula,
            String nrcCodigo) {

                Nrc nrc = nrcService.buscarPorCodigo(nrcCodigo);

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

}
