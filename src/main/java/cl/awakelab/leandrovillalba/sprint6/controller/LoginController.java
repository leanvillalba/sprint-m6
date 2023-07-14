package cl.awakelab.leandrovillalba.sprint6.controller;

import cl.awakelab.leandrovillalba.sprint6.entity.Usuario;
import cl.awakelab.leandrovillalba.sprint6.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    public String logIn(){
        return "login";
    }
    @PostMapping
    public String iniciarSesion(@RequestParam("runLogin") int run, @RequestParam("passwordLogin") String clave, Model model) {

        List<Usuario> listaUsuarios = objUsuarioService.listarUsuarios();
        // Verificar si las credenciales del usuario son válidas
        for (Usuario usuario : listaUsuarios) {
            if (usuario.getRun() == run && usuario.getClave().equals(clave)) {
                // Si es válido, agrega al usuario al modelo y lo redirige a "bienvenida.html"
                model.addAttribute("usuario", usuario); // Lo agrego para usarlo en el html
                return "bienvenida";
            }
        }
        // Si las credenciales son inválidas, redirige al usuario nuevamente al login
        return "redirect:/login";
    }


}
