package com.example.genedor_horarios.usuario;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.genedor_horarios.bloqueHorario.BloqueHorarioEntity;
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

    @GetMapping("/generar")
    public String crearHorario(@RequestParam List<Long> cursos, HttpSession session, Model model) {

        String nombre = (String) session.getAttribute("nombre");
        List<List<BloqueHorarioEntity>> top5 = horarioService.generadorHorario(cursos);
        
        session.setAttribute("top5", top5);
        model.addAttribute("horas", horarioService.listHorasMuertas(top5));
        session.setAttribute("horas", horarioService.listHorasMuertas(top5));
        model.addAttribute("nombre", nombre);


        return "usuario/lista-horarios";
        

    }

    @SuppressWarnings("unchecked")
    @GetMapping("/ver")
    public String verHorario (@RequestParam int posicion, HttpSession session, Model model) {

        String nombre = (String) session.getAttribute("nombre");
        List<List<BloqueHorarioEntity>> top5 = (List<List<BloqueHorarioEntity>>) session.getAttribute("top5");
        List<BloqueHorarioEntity> horarioEscogido = top5.get(posicion);
        List<Integer> horasMuertas = (List<Integer>) session.getAttribute("horas"); 

        model.addAttribute("nombre", nombre);
        model.addAttribute("horarioMap", horarioService.mostrarHorario(horarioEscogido));
        model.addAttribute("horaMuerta", horasMuertas.get(posicion));
        model.addAttribute("posicion" , posicion);

        return "usuario/ver-horarios";
    }

    @SuppressWarnings("unchecked")
    @GetMapping("/volver")
    public String volver (HttpSession session, Model model) {

        String nombre = (String) session.getAttribute("nombre");
        List<Integer> horas = (List<Integer>) session.getAttribute("horas"); 

        model.addAttribute("nombre", nombre);
        model.addAttribute("horas",horas);


        return "usuario/lista-horarios";
    }

    @GetMapping("volver-cursos")
    public String volverCursos() {

        return "redirect:/usuario/cursos";

    }

    
}
