package com.example.genedor_horarios.usuario;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.genedor_horarios.curso.CursoService;
import com.example.genedor_horarios.horario.HorarioService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

    private final CursoService cursoService;
    private final HorarioService horarioService;


    public UsuarioController (CursoService cursoService, HorarioService horarioService) {
        this.cursoService = cursoService;
        this.horarioService = horarioService;
    }

    @GetMapping("/bienvenida")
    public String bienvenida() {

        return "usuario/bienvenida";

    }

    @PostMapping("/registro")
    public String registrarUsuario(@RequestParam String nombre, HttpSession session, Model model) {

        session.setAttribute("nombre", nombre );
        

        return "redirect:/usuario/cursos";

    }

    @GetMapping("/cursos")
    public String mostrarCursos(HttpSession session, Model model) {

        String nombre = (String) session.getAttribute("nombre");
        

        model.addAttribute("nombre", nombre);
        model.addAttribute("cursos", cursoService.listarTodos());


        return "usuario/curso-seleccion";

    }

    
}
