package com.example.genedor_horarios.nrc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.genedor_horarios.curso.CursoService;

@Controller
@RequestMapping("/nrc")
public class NrcController {

    private final NrcService nrcService;
    private final CursoService cursoService;

    public NrcController(NrcService nrcService, CursoService cursoService) {
        this.nrcService = nrcService;
        this.cursoService = cursoService;
    }

    @GetMapping("/gestion")
    public String listar (Model model) {

        model.addAttribute("nrcs" , nrcService.listarTodos());
        model.addAttribute("cursos", cursoService.listarTodos());
        model.addAttribute("nrc", new NrcEntity());


        return "gestion-nrc";

    }

    @PostMapping("/registrar")
    public String registrar(@RequestParam(required = false) Long id ,@RequestParam String codigo, @RequestParam Long cursoId , @RequestParam String docente, @RequestParam String modalidad, @RequestParam Boolean esPrincipal , @RequestParam String nrcVinculado) {

        nrcService.registrarNrc(id, codigo, cursoId, docente, modalidad, esPrincipal, nrcVinculado);

        return "redirect:/nrc/gestion";
    }

    @GetMapping("/editar")
    public String editar(@RequestParam Long id, Model model) {

        model.addAttribute("nrc",nrcService.buscarPorId(id));
        model.addAttribute("nrcs" , nrcService.listarTodos());
        model.addAttribute("cursos", cursoService.listarTodos());
        

        return "gestion-nrc";
    }

    @GetMapping("/eliminar")
    public String eliminar(@RequestParam Long id) {

        nrcService.eliminarPorId(id);

        return "redirect:/nrc/gestion";
    }
    
}
