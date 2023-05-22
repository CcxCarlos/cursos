package com.balmes.cursos.Controller;


import com.balmes.cursos.model.Curs;
import com.balmes.cursos.model.Estudiant;
import com.balmes.cursos.repository.EstudiantRepository;
import com.balmes.cursos.service.CursService;
import com.balmes.cursos.service.EstudiantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/api/estudiants")
public class EstudiantController {

    @Autowired
    CursService cursService;
    @Autowired
    EstudiantService estudiantService;

    @GetMapping
    public String estudiants(Model model) {
        model.addAttribute("estudiants", estudiantService.findAll());
        return "estudiants/llista-estudiants";
    }

    @GetMapping("/new")
    public String mostrarFormulariEstudiant(Model model) {

        Estudiant estudiant = new Estudiant();

        model.addAttribute("estudiant", estudiant);
        model.addAttribute("cursos", cursService.findAll());

        return "estudiants/nouEstudiant";
    }

    @PostMapping("/alta")
    public String altaEstudiant(@RequestParam("cursId") long cursId, Estudiant estudiant, Model model) {

        List<Curs> cursos = new ArrayList<>();
        cursos.add(cursService.get(cursId));
        estudiant.setCursos(cursos);
        estudiantService.save(estudiant);
        return "redirect:/api/estudiants";
    }

    @GetMapping("/{id}")
    public String obtenerEstudiantPorId(@PathVariable("id") long id, Model model) {

        model.addAttribute("estudiant", estudiantService.get(id));

        return "estudiants/perfil-estudiant";
    }
}


