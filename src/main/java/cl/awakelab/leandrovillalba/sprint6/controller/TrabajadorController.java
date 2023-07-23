package cl.awakelab.leandrovillalba.sprint6.controller;

import cl.awakelab.leandrovillalba.sprint6.entity.*;
import cl.awakelab.leandrovillalba.sprint6.service.*;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/trabajador")
public class TrabajadorController {
    @Autowired
    private ITrabajadorService objTrabajadorService;
    @Autowired
    private IEmpleadorService objEmpleadorService;
    @Autowired
    private IUsuarioService objUsuarioService;
    @Autowired
    private IInstitucionPrevisionService objInstPrevService;
    @Autowired
    private IInstitucionSaludService objInstSaludService;

    @GetMapping("/crearTrabajador")
    public String mostrarFormularioCrearTrabajador(HttpSession session, Model model){
        int idUsuario = (int) session.getAttribute("idUsuario");
        Usuario usuario = objUsuarioService.buscarUsuarioPorId(idUsuario);
        List<Empleador> empleadores =objEmpleadorService.listarEmpleadores();
        List<InstitucionPrevision> institucionesPrevision = objInstPrevService.listarInstitucionesPrevision();
        List<InstitucionSalud> institucionesSalud = objInstSaludService.listarInstitucionesSalud();
        model.addAttribute("usuario", usuario);
        model.addAttribute("trabajador", new Trabajador());
        model.addAttribute("empleadores", empleadores);
        model.addAttribute("institucionesPrevision", institucionesPrevision);
        model.addAttribute("institucionesSalud", institucionesSalud);
        return "crearTrabajador";
    }

    @PostMapping("/crearTrabajador")
    public String crearTrabajador(@ModelAttribute Trabajador trabajador,
                                  @RequestParam int institucionPrevision,
                                  @RequestParam int institucionSalud,
                                  @RequestParam int empleadorId){
        if (StringUtils.isEmpty(institucionPrevision) || StringUtils.isEmpty(institucionSalud) || StringUtils.isEmpty(empleadorId)) {
            System.out.println("V A C I O");
            return "redirect:/bienvenida";
        }
        InstitucionPrevision instPrev = objInstPrevService.buscarInstitucionPrevisionPorId(institucionPrevision);
        InstitucionSalud instSalud = objInstSaludService.buscarInstitucionSaludPorId(institucionSalud);
        Empleador empleador = objEmpleadorService.buscarEmpleardorPorId(empleadorId);
        trabajador.setInstitucionPrevision(instPrev);
        trabajador.setInstitucionSalud(instSalud);
        List<Empleador> listaEmpleadores = new ArrayList<>();
        listaEmpleadores.add(empleador);
        trabajador.setListaEmpleadores(listaEmpleadores);

        objTrabajadorService.crearTrabajador(trabajador);
        return "redirect:/trabajador/listaTrabajadores";
    }

    @GetMapping("/listaTrabajadores")
    public String listarTrabajadores(HttpSession session, Model model) {
        int idUsuario = (int) session.getAttribute("idUsuario");
        List<Trabajador> listaTrabajadores = objTrabajadorService.listarTrabajadores();
        Usuario usuario = objUsuarioService.buscarUsuarioPorId(idUsuario);
        model.addAttribute("trabajadores", listaTrabajadores);
        model.addAttribute("usuario", usuario);
        return "listarTrabajadores";
    }

    @GetMapping("/{idTrabajador}/editar")
    public String mostrarFormularioEditarTrabajador(@PathVariable int idTrabajador, Model model) {
        Trabajador trabajador = objTrabajadorService.buscarTrabajadorPorId(idTrabajador);
        model.addAttribute("trabajador", trabajador);
        List<InstitucionSalud> institucionesSalud = objInstSaludService.listarInstitucionesSalud();
        List<InstitucionPrevision> institucionesPrevision = objInstPrevService.listarInstitucionesPrevision();
        model.addAttribute("institucionesSalud", institucionesSalud);
        model.addAttribute("institucionesPrevision", institucionesPrevision);
        return "editarTrabajador";

    }

    @PostMapping("/{idTrabajador}/editar")
    public String actualizarTrabajador(@ModelAttribute Trabajador trabajador, @RequestParam int institucionPrevision, @RequestParam int institucionSalud){
        InstitucionSalud instSalud = objInstSaludService.buscarInstitucionSaludPorId(institucionSalud);
        InstitucionPrevision instPrev = objInstPrevService.buscarInstitucionPrevisionPorId(institucionPrevision);
        // System.out.println("ID INST: " + instPrev + " " + instSalud);
        trabajador.setInstitucionSalud(instSalud);
        trabajador.setInstitucionPrevision(instPrev);
        objTrabajadorService.actualizarTrabajador(trabajador);
        return "redirect:/trabajador/listaTrabajadores";
    }

    @GetMapping("/{idTrabajador}/eliminar")
    public String eliminarTrabajador(@PathVariable int idTrabajador){
        Trabajador trabajador = objTrabajadorService.buscarTrabajadorPorId(idTrabajador);
        objTrabajadorService.eliminarTrabajador(idTrabajador);
        return "redirect:/trabajador/listaTrabajadores";
    }

}
