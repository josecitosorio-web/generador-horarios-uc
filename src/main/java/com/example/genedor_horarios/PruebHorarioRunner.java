package com.example.genedor_horarios;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.genedor_horarios.bloqueHorario.BloqueHorarioEntity;
import com.example.genedor_horarios.horario.HorarioService;

@Component
public class PruebHorarioRunner implements CommandLineRunner {

    private HorarioService horarioService;


    public PruebHorarioRunner (HorarioService horarioService) {

        this.horarioService = horarioService;

    }

    @Override
    public void run(String... args) {

        // definimos nuestras listas

        List<Long> cursos = Arrays.asList(1L,2L,3L,4L,5L,6L);

        List <BloqueHorarioEntity> horarioCandidato = new ArrayList<>();

        List<List<BloqueHorarioEntity>> listaHorariosElegidos = new ArrayList<>();


        // ejecutamos el metodo a evaluar

        horarioService.generarHorariosElegibles(cursos, horarioCandidato, listaHorariosElegidos);

        System.out.println("TOTAL DE HORARIOS ENCONTRADOS :" + listaHorariosElegidos.size());


        for(int i = 0; i < 1 ; i++) {

            
            
            System.out.println("HORARIO NUMERO :" + (i));
            

            List<BloqueHorarioEntity> horarios = listaHorariosElegidos.get(i);

            for(BloqueHorarioEntity horario : horarios) {

                System.out.println("CURSO :" + horario.getNrc().getCurso().getNombre());
                System.out.println("NRC : " + horario.getNrc().getCodigo());
                System.out.println("Día : " + horario.getDia());
                System.out.println("Hora: " +horario.getHoraInicio() + " - " + horario.getHoraFin());


            }

        }
        

    }
    
}
