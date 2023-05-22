package com.balmes.cursos.Controller;

import com.balmes.cursos.model.Curs;
import com.balmes.cursos.service.CursService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/cursos")
public class CursController {
    @Autowired
    CursService cursService;

    @PostMapping("/alta")
    public String nouCurs(Curs curs, Model model) {

        cursService.save(curs);
        return "redirect:/api/cursos";
    }

    @GetMapping("/new")
    public String mostrarFormulariCurs(Model model) {

        Curs curs = new Curs();
        model.addAttribute("curs", curs);

        return "cursos/nouCurs";
    }

    @GetMapping
    public String cursos(Model model){
        model.addAttribute("cursos", cursService.findAll());

        return "cursos/llista-cursos";

    }

}
