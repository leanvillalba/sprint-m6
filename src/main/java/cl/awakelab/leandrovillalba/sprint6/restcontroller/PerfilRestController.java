package cl.awakelab.leandrovillalba.sprint6.restcontroller;

import cl.awakelab.leandrovillalba.sprint6.entity.Perfil;
import cl.awakelab.leandrovillalba.sprint6.service.IPerfilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/perfil")
public class PerfilRestController {
    @Autowired
    IPerfilService objPerfilService;
    @PostMapping
    public Perfil crearPerfil(@RequestBody Perfil perfil){
        return objPerfilService.crearPerfil(perfil);
    }

    @GetMapping("/{idPerfil}")
    public Perfil buscarPerfilPorId(@PathVariable int idPerfil){
        return objPerfilService.buscarPerfilPorId(idPerfil);
    }

    @GetMapping
    public List<Perfil> listarPerfiles(){
        return objPerfilService.listarPerfiles();
    }

    @PutMapping("{idPerfil}")
    public Perfil actualizarPerfil(@RequestBody Perfil perfilActualizar, @PathVariable int idPerfil){
        return objPerfilService.actualizarPerfil(perfilActualizar, idPerfil);
    }

    @PutMapping
    public Perfil actualizarPerfil2(@RequestBody Perfil perfilActualizar){
        return objPerfilService.actualizarPerfil2(perfilActualizar);
    }

    @DeleteMapping
    public void eliminarPerfil(@RequestBody Perfil perfil){
        objPerfilService.eliminarPerfil(perfil);
    }

    @DeleteMapping("/{idPerfil}")
    public void eliminarPerfil2(@PathVariable int idPerfil){
        objPerfilService.eliminarPerfil2(idPerfil);
    }

}
