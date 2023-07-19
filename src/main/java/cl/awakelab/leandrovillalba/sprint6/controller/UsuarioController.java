package cl.awakelab.leandrovillalba.sprint6.controller;


import cl.awakelab.leandrovillalba.sprint6.entity.Empleador;
import cl.awakelab.leandrovillalba.sprint6.entity.Perfil;
import cl.awakelab.leandrovillalba.sprint6.entity.Usuario;
import cl.awakelab.leandrovillalba.sprint6.service.IEmpleadorService;
import cl.awakelab.leandrovillalba.sprint6.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    IUsuarioService objUsuarioService;
    @Autowired
    IEmpleadorService objEmpleadorService;

    @GetMapping //Todos los métodos de los controllers son de tipo String
    public String listarUsuarios(Model model){
        List<Usuario> listaUsuarios = objUsuarioService.listarUsuarios();
        model.addAttribute("usuarios", listaUsuarios);
        return "listarUsuarios";
    }

    @GetMapping("/{idUsuario}")
    public String listarUsuarioPorId(@PathVariable int idUsuario, Model model){
        Usuario usuario = objUsuarioService.buscarUsuarioPorId(idUsuario);
        model.addAttribute("usuario", usuario);
        return "usuario";
    }

    @GetMapping("/crearUsuario")
    public String mostrarFormularioCrearUsuario(Model model){
        return "crearUsuario";
    }

    @PostMapping("/crearUsuario")
    public String crearUsuario(@ModelAttribute Usuario usuario, @RequestParam("perfil") int idPerfil, Model model){
        Perfil perfil = new Perfil();
        perfil.setIdPerfil(idPerfil);
        usuario.setPerfil(perfil);
        objUsuarioService.crearUsuario(usuario);
        model.addAttribute("usuario", usuario);

        if (idPerfil == 3){
            Empleador empleador = objEmpleadorService.crearEmpleadorDesdeUsuario(usuario);
        }

        return "bienvenida";
    }

    @PostMapping("/registrarUsuario")
    public String registrarUsuario(@ModelAttribute Usuario usuario, @RequestParam("perfil") int idPerfil){
        Perfil perfil = new Perfil();
        perfil.setIdPerfil(idPerfil);
        usuario.setPerfil(perfil);
        objUsuarioService.crearUsuario(usuario);

        if (idPerfil == 3){
            Empleador empleador = objEmpleadorService.crearEmpleadorDesdeUsuario(usuario);
        }

        return "redirect:/login";
    }



    @GetMapping("/{idUsuario}/editar")
    public String mostrarFormularioEditarUsuario(@PathVariable int idUsuario, Model model){
        Usuario usuarioParaEditar = objUsuarioService.buscarUsuarioPorId(idUsuario);
        model.addAttribute("usuario", usuarioParaEditar);
        return "editarUsuario";
    }

    @PostMapping("/{idUsuario}/editar")
    public String actualizarUsuario(@PathVariable int idUsuario, @ModelAttribute Usuario usuario){
        objUsuarioService.actualizarUsuario2(usuario);
        return "redirect:/usuario";
    }

    @GetMapping("/{idUsuario}/eliminar")
    public String eliminarUsuario(@PathVariable int idUsuario){
        objUsuarioService.eliminarUsuario2(idUsuario);
        return "redirect:/usuario";
    }



}
