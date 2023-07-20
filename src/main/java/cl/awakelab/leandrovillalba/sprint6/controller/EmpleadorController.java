package cl.awakelab.leandrovillalba.sprint6.controller;

import cl.awakelab.leandrovillalba.sprint6.entity.Empleador;
import cl.awakelab.leandrovillalba.sprint6.entity.Usuario;
import cl.awakelab.leandrovillalba.sprint6.service.IEmpleadorService;
import cl.awakelab.leandrovillalba.sprint6.service.IUsuarioService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/empleador")
public class EmpleadorController {
    @Autowired
    IEmpleadorService objEmpleadorService;
    @Autowired
    IUsuarioService objUsuarioService;

    @GetMapping("/listaEmpleadores")
    public String listarEmpleadores(HttpSession session, Model model) {
        int idUsuario = (int) session.getAttribute("idUsuario");
        List<Empleador> listaEmpleadores = objEmpleadorService.listarEmpleadores();
        Usuario usuario = objUsuarioService.buscarUsuarioPorId(idUsuario);
        model.addAttribute("empleadores", listaEmpleadores);
        model.addAttribute("usuario", usuario);
        return "listarEmpleadores";
    }

    @GetMapping("/crearEmpleador")
    public String mostrarFormularioCrearEmpleador(HttpSession session, Model model) {
        // Obtengo el valor del atributo idUsuario de la sesión creada en el login
        int idUsuario = (int) session.getAttribute("idUsuario");
        Usuario usuario = objUsuarioService.buscarUsuarioPorId(idUsuario);
        model.addAttribute("usuario", usuario);
        model.addAttribute("empleador", new Empleador());
        return "crearEmpleador";
    }

    @PostMapping("/crearEmpleador")
    public String crearEmpleador(@ModelAttribute("empleador") Empleador empleador) {
        Usuario usuario = objUsuarioService.buscarUsuarioPorId(empleador.getUsuario().getIdUsuario());
        empleador.setUsuario(usuario);
        objEmpleadorService.crearEmpleador(empleador);
        return "redirect:/empleador/listaEmpleadores";
    }

    @GetMapping("/{idEmpleador}/editar")
    public String mostrarFormularioEditarEmpleador(@PathVariable int idEmpleador, Model model){
        Empleador empleador = objEmpleadorService.buscarEmpleardorPorId(idEmpleador);
        model.addAttribute("empleador", empleador);
        // Agrego el objeto usuario al modelo, antes me daba error en editarEmpleador.html porque no me reconocía el idUsuario
        model.addAttribute("usuario", empleador.getUsuario());
        return "editarEmpleador";
    }

    @PostMapping("/{idEmpleador}/editar")
    public String actualizarEmpleador(@ModelAttribute Empleador empleador) {
        objEmpleadorService.actualizarEmpleador(empleador);
        return "redirect:/empleador/listaEmpleadores";
    }

    @GetMapping("/{idEmpleador}/eliminar")
    public String eliminarEmpleador(@PathVariable int idEmpleador) {
        Empleador empleador = objEmpleadorService.buscarEmpleardorPorId(idEmpleador);
        objEmpleadorService.eliminarEmpleador(idEmpleador);
        return "redirect:/empleador/listaEmpleadores";
    }






}


