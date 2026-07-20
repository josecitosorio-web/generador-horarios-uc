package com.example.genedor_horarios.horario;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.genedor_horarios.bloqueHorario.BloqueHorarioEntity;
import com.example.genedor_horarios.curso.CursoService;

@Controller
@RequestMapping("/horario")
public class HorarioController {

    private final CursoService cursoService;
    private final HorarioService horarioService;

    public HorarioController (CursoService cursoService, HorarioService horarioService) {
        this.cursoService = cursoService;
        this.horarioService = horarioService;
    }

    @GetMapping("/inicio")
    public String iniciarHorarios (Model model) {

        model.addAttribute("cursos", cursoService.listarTodos());

        return "generar-horario";

    }

    @GetMapping("/generar")
    public String crearHorarios (@RequestParam List<Long> cursos, Model model) {

        List<List<BloqueHorarioEntity>> top5 = horarioService.generadorHorario(cursos);

        model.addAttribute("horarios", top5);
        model.addAttribute("horas", horarioService.listHorasMuertas(top5));
        model.addAttribute("cursos", cursoService.listarTodos());

        


        return "generar-horario";


    }
    
}
