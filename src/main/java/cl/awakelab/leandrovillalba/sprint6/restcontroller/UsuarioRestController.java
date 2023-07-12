package cl.awakelab.leandrovillalba.sprint6.restcontroller;

import cl.awakelab.leandrovillalba.sprint6.entity.Usuario;
import cl.awakelab.leandrovillalba.sprint6.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioRestController {
    @Autowired
    IUsuarioService objUsuarioService;
    @PostMapping
    public Usuario crearUsuario(@RequestBody Usuario usuario){
        return objUsuarioService.crearUsuario(usuario);
    }

    @GetMapping("/{idUsuario}")
    public Usuario buscarUsuarioPorId(@PathVariable int idUsuario){
        return objUsuarioService.buscarUsuarioPorId(idUsuario);
    }

    @GetMapping
    public List<Usuario> listarUsuarios(){
        return objUsuarioService.listarUsuarios();
    }

    @PutMapping("/{idUsuario}")
    public Usuario actualizarUsuario(@RequestBody Usuario usuarioActualizar, @PathVariable int idUsuario){
        return objUsuarioService.actualizarUsuario(usuarioActualizar,idUsuario);
    }

    @PutMapping
    public Usuario actualizarUsuario2(@RequestBody Usuario usuarioActualizar){
        return objUsuarioService.actualizarUsuario2(usuarioActualizar);
    }

    @DeleteMapping
    public void eliminarUsuario(@RequestBody Usuario usuario){
        objUsuarioService.eliminarUsuario(usuario);
    }

    @DeleteMapping("/{idUsuario}")
    public void eliminarUsuario2(@PathVariable int idUsuario){
        objUsuarioService.eliminarUsuario2(idUsuario);
    }

}
