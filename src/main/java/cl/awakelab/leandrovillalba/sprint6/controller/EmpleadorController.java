package cl.awakelab.leandrovillalba.sprint6.controller;

import cl.awakelab.leandrovillalba.sprint6.entity.Empleador;
import cl.awakelab.leandrovillalba.sprint6.entity.Usuario;
import cl.awakelab.leandrovillalba.sprint6.service.IEmpleadorService;
import cl.awakelab.leandrovillalba.sprint6.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/empleador")
public class EmpleadorController {
    @Autowired
    IEmpleadorService objEmpleadorService;
    @Autowired
    IUsuarioService objUsuarioService;

    @GetMapping("/listaEmpleadores/{idUsuario}")
    public String listarEmpleadores(@PathVariable int idUsuario, Model model){
        List<Empleador> listaEmpleadores = objEmpleadorService.listarEmpleadores();
        model.addAttribute("empleadores", listaEmpleadores);
        return "listarEmpleadores";
    }

    @GetMapping("/crearEmpleador/{idUsuario}")
    public String mostrarFormularioCrearEmpleador(@PathVariable int idUsuario, Model model){
        Usuario usuario = objUsuarioService.buscarUsuarioPorId(idUsuario);
        model.addAttribute("usuario", usuario);
        model.addAttribute("empleador", new Empleador());
        return "crearEmpleador";
    }

    @PostMapping("/crearEmpleador")
    public String crearEmpleador(@ModelAttribute("empleador") Empleador empleador, RedirectAttributes redirectAttributes) {
        Usuario usuario = objUsuarioService.buscarUsuarioPorId(empleador.getUsuario().getIdUsuario());
        empleador.setUsuario(usuario);
        objEmpleadorService.crearEmpleador(empleador);
        // Guardo idUsuario para poder redireccionar a la lista de empleadores + id del Usuario que creará los empleadores
        redirectAttributes.addAttribute("idUsuario", empleador.getUsuario().getIdUsuario());

        return "redirect:/empleador/listaEmpleadores/{idUsuario}";
    }


}


