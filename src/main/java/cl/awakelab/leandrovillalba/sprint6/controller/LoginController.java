package cl.awakelab.leandrovillalba.sprint6.controller;


import cl.awakelab.leandrovillalba.sprint6.service.IUsuarioService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private IUsuarioService objUsuarioService;

    @GetMapping
    public String logIn() {
        return "login";
    }

    @PostMapping
    public String iniciarSesion(@RequestParam("runLogin") int run, @RequestParam("passwordLogin") String clave, HttpSession session) {
        // Lógica de autenticación, obtengo el idUsuario del usuario autenticado
        int idUsuario = objUsuarioService.autenticacionUsuario(run, clave);
        if (idUsuario != 0) {
            // Si la autenticación fue exitosa, guardo el idUsuario en la sesión
            session.setAttribute("idUsuario", idUsuario);
            return "redirect:/bienvenida";
        } else {
            // Si la autenticación falla, redirige al login nuevamente
            return "redirect:/login";
        }
    }
}

