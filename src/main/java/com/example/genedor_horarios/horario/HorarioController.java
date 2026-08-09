package com.example.genedor_horarios.horario;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.genedor_horarios.bloqueHorario.BloqueHorarioEntity;
import com.example.genedor_horarios.curso.CursoService;

import jakarta.servlet.http.HttpSession;

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
        model.addAttribute("horarioMap", new HashMap<>());
        model.addAttribute("posicion", 0);
        model.addAttribute("paginaActiva", "generador");

        return "admin/generar-horario";

    }

    @GetMapping("/generar")
    public String crearHorarios (@RequestParam List<Long> cursos,@RequestParam String preferencia,HttpSession session, Model model) {

        List<List<BloqueHorarioEntity>> top5 = horarioService.generadorHorario(cursos,preferencia);
        List<BloqueHorarioEntity> horarioGanador = top5.get(0);

        List<Integer> listaHorasMuertas =  horarioService.listHorasMuertas(top5, preferencia);

        model.addAttribute("horas", listaHorasMuertas);
        session.setAttribute("listaHorasMuertas", listaHorasMuertas);
        model.addAttribute("cursos", cursoService.listarTodos());
        model.addAttribute("horarioMap", horarioService.mostrarHorario(horarioGanador));
        session.setAttribute("top5", top5);
        model.addAttribute("posicion", 0);
        model.addAttribute("paginaActiva", "generador");

        return "admin/generar-horario";


    }

    @SuppressWarnings("unchecked")
    @GetMapping("/ver")
    public String verHorario (@RequestParam int posicion, HttpSession session, Model model){

        List<List<BloqueHorarioEntity>> top5 = (List<List<BloqueHorarioEntity>>) session.getAttribute("top5");
        List<BloqueHorarioEntity> horarioEscogido = top5.get(posicion);

        model.addAttribute("horas", (List<Integer>) session.getAttribute("listaHorasMuertas"));
        model.addAttribute("cursos", cursoService.listarTodos());
        model.addAttribute("horarioMap", horarioService.mostrarHorario(horarioEscogido));
        model.addAttribute("posicion", posicion);
        model.addAttribute("paginaActiva", "generador");


        return "admin/generar-horario";
    }

    
}
