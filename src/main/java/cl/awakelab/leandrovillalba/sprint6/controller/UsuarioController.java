package cl.awakelab.leandrovillalba.sprint6.controller;


import cl.awakelab.leandrovillalba.sprint6.entity.Usuario;
import cl.awakelab.leandrovillalba.sprint6.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    IUsuarioService objUsuarioService;

    @GetMapping //Todos los métodos de los controllers son de tipo String
    public String listarUsuarios(Model model){
        List<Usuario> listaUsuarios = objUsuarioService.listarUsuarios();
        model.addAttribute("usuarios", listaUsuarios);
        return "listarUsuarios";
    }
}
