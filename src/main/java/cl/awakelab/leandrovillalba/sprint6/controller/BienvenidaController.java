package cl.awakelab.leandrovillalba.sprint6.controller;

import cl.awakelab.leandrovillalba.sprint6.entity.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/bienvenida")
public class BienvenidaController {
    @GetMapping
    public String mostrarBienvenida(Model model) {
        Usuario usuario = new Usuario();
        model.addAttribute("usuario", usuario);
        return "bienvenida";
    }
}
