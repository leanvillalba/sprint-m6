package cl.awakelab.leandrovillalba.sprint6.controller;

import cl.awakelab.leandrovillalba.sprint6.entity.*;
import cl.awakelab.leandrovillalba.sprint6.service.*;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/liquidacion")
public class LiquidacionController {
    @Autowired
    private ILiquidacionService objLiquidacionService;
    @Autowired
    private ITrabajadorService objTrabajadorService;
    @Autowired
    private IUsuarioService objUsuarioService;
    @Autowired
    private IInstitucionPrevisionService objInstPrevService;
    @Autowired
    private IInstitucionSaludService objInstSaludService;

    @GetMapping("/crearLiquidacion")
    public String mostrarFormularioCrearLiquidacion(HttpSession session, Model model) {
        int idUsuario = (int) session.getAttribute("idUsuario");
        Usuario usuario = objUsuarioService.buscarUsuarioPorId(idUsuario);
        List<Trabajador> trabajadores = objTrabajadorService.listarTrabajadores();
        List<InstitucionPrevision> institucionesPrevision = objInstPrevService.listarInstitucionesPrevision();
        List<InstitucionSalud> institucionesSalud = objInstSaludService.listarInstitucionesSalud();
        model.addAttribute("usuario", usuario);
        model.addAttribute("liquidacion", new Liquidacion());
        model.addAttribute("trabajadores", trabajadores);
        model.addAttribute("institucionesPrevision", institucionesPrevision);
        model.addAttribute("institucionesSalud", institucionesSalud);

        return "crearLiquidacion";
    }

    @PostMapping("/crearLiquidacion")
    public String crearLiquidacion(@ModelAttribute Liquidacion liquidacion,
                                   @RequestParam int institucionPrevision,
                                   @RequestParam int institucionSalud,
                                   @RequestParam int trabajadorId,
                                   @RequestParam float sueldoImponible,
                                   @RequestParam int anticipo) {

        InstitucionPrevision instPrev = objInstPrevService.buscarInstitucionPrevisionPorId(institucionPrevision);
        InstitucionSalud instSalud = objInstSaludService.buscarInstitucionSaludPorId(institucionSalud);
        Trabajador trabajador = objTrabajadorService.buscarTrabajadorPorId(trabajadorId);

        objLiquidacionService.crearLiquidacion(liquidacion, trabajador, instSalud, instPrev, sueldoImponible, anticipo);
        return "redirect:/liquidacion/listaLiquidaciones";
    }

    @GetMapping("/listaLiquidaciones")
    public String listarLiquidaciones(HttpSession session, Model model) {
        List<Liquidacion> listaLiquidaciones = objLiquidacionService.listarLiquidaciones();
        model.addAttribute("liquidaciones", listaLiquidaciones);
        return "listarLiquidaciones";
    }

    @GetMapping("/{idLiquidacion}/editar")
    public String mostrarFormularioEditarLiquidacion(@PathVariable long idLiquidacion, Model model){
        Liquidacion liquidacion = objLiquidacionService.buscarLiquidacionPorId(idLiquidacion);
        List<Trabajador> trabajadores = objTrabajadorService.listarTrabajadores();
        List<InstitucionSalud> institucionesSalud =objInstSaludService.listarInstitucionesSalud();
        List<InstitucionPrevision> institucionesPrevision = objInstPrevService.listarInstitucionesPrevision();
        model.addAttribute("liquidacion", liquidacion);
        model.addAttribute("trabajadores", trabajadores);
        model.addAttribute("institucionesSalud", institucionesSalud);
        model.addAttribute("institucionesPrevision", institucionesPrevision);

        return "editarLiquidacion";
    }

    @PostMapping("/{idLiquidacion}/editar")
    public String actualizarLiquidacion(@ModelAttribute Liquidacion liquidacion,
                                        @RequestParam int trabajadorId,
                                        @RequestParam int institucionPrevision,
                                        @RequestParam int institucionSalud,
                                        @RequestParam float sueldoImponible,
                                        @RequestParam int anticipo) {
        Trabajador trabajador = objTrabajadorService.buscarTrabajadorPorId(trabajadorId);
        InstitucionSalud instSalud = objInstSaludService.buscarInstitucionSaludPorId(institucionSalud);
        InstitucionPrevision instPrev = objInstPrevService.buscarInstitucionPrevisionPorId(institucionPrevision);

        objLiquidacionService.actualizarLiquidacion(liquidacion, trabajador, instSalud, instPrev, sueldoImponible, anticipo);
        return "redirect:/liquidacion/listaLiquidaciones";
    }

    @GetMapping("{idLiquidacion}/eliminar")
    public String eliminarLiquidacion(@PathVariable long idLiquidacion) {
        Liquidacion liquidacion = objLiquidacionService.buscarLiquidacionPorId(idLiquidacion);
        objLiquidacionService.eliminarLiquidacion(idLiquidacion);
        return "redirect:/liquidacion/listaLiquidaciones";
    }

}
