package com.example.genedor_horarios.curso;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
@RequestMapping("/curso")
public class CursoController {

    private final CursoService cursoService;


    public CursoController(CursoService cursoService) {
        this.cursoService = cursoService;
    }
    

    @GetMapping("/gestion")
    public String listar(Model model) {

        model.addAttribute("cursos" , cursoService.listarTodos());
        model.addAttribute("paginaActiva", "cursos");

        return "admin/gestion-cursos";
    }

    @PostMapping("/registrar")
    public String registrar(@ModelAttribute Curso curso) {

        cursoService.agregarCurso(curso);
        

        return "redirect:/curso/gestion";
    }

    @GetMapping("/editar")
    public String editar(@RequestParam Long id, Model model) {

        model.addAttribute("cursos" , cursoService.listarTodos());
        model.addAttribute("curso", cursoService.buscarPorId(id));
        model.addAttribute("paginaActiva", "cursos");

        return "admin/gestion-cursos";

    }

    @GetMapping("/eliminar")
    public String eliminar(@RequestParam Long id, Model model) {

        cursoService.eliminarPorId(id);
        model.addAttribute("cursos" , cursoService.listarTodos());
        model.addAttribute("paginaActiva", "cursos");

        return "admin/gestion-cursos";

    }

    
}
