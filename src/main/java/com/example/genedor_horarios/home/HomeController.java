package com.example.genedor_horarios.home;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.genedor_horarios.bloqueHorario.BloqueHorarioService;
import com.example.genedor_horarios.curso.CursoService;
import com.example.genedor_horarios.nrc.NrcService;

@Controller
@RequestMapping("/home")
public class HomeController {

    private final CursoService cursoService;
    private final NrcService nrcService;
    private final BloqueHorarioService bloqueHorarioService;

    public HomeController (CursoService cursoService, NrcService nrcService, BloqueHorarioService bloqueHorarioService) {
        this.cursoService = cursoService;
        this.nrcService = nrcService;
        this.bloqueHorarioService = bloqueHorarioService;
    }
    
    @GetMapping("/inicio")
    public String inicio(Model model) {

        model.addAttribute("nCursos", cursoService.cantidadCurso());
        model.addAttribute("nNrc", nrcService.cantidadNrc());
        model.addAttribute("nBloques", bloqueHorarioService.cantidadBloque());
        model.addAttribute("paginaActiva", "home");


        return "admin/home";

    }

}
