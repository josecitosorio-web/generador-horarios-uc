package com.example.genedor_horarios.bloqueHorario;

import java.time.LocalTime;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/bloqueHorario")
public class BloqueHorarioController {

    private final BloqueHorarioService bloqueHorarioService;

    public BloqueHorarioController (BloqueHorarioService bloqueHorarioService) {

        this.bloqueHorarioService = bloqueHorarioService;

    }

    @GetMapping("/gestion")
    public String listar(Model model){

        model.addAttribute("bloques", bloqueHorarioService.listarTodos());
        model.addAttribute("bloque", new BloqueHorario());
        model.addAttribute("dias", DiaSemana.values());

        return "gestion-bloques";

    }

    @PostMapping("/registrar")
    public String registrar (
        @RequestParam(required = false) Long id , 
        @RequestParam DiaSemana dia, 
        @RequestParam LocalTime horaInicio, 
        @RequestParam LocalTime horaFin, 
        @RequestParam String aula, 
        @RequestParam String nrcCodigo) {

            bloqueHorarioService.registrarBloque(id,dia,horaInicio,horaFin,aula,nrcCodigo);

            return "redirect:/bloqueHorario/gestion";

    }

    @GetMapping("/editar")
    public String editar (@RequestParam(required = false)Long id, Model model) {

        model.addAttribute("bloques", bloqueHorarioService.listarTodos());
        model.addAttribute("bloque", bloqueHorarioService.encontrarPorId(id));
        model.addAttribute("dias", DiaSemana.values());

        return "gestion-bloques";

    }

    @GetMapping("/eliminar")
    public String eliminar (@RequestParam Long id) {

        bloqueHorarioService.eliminarPorId(id);

        return "redirect:/bloqueHorario/gestion";

    }
    
}
