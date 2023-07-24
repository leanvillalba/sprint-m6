package cl.awakelab.leandrovillalba.sprint6.controller;

import cl.awakelab.leandrovillalba.sprint6.entity.*;
import cl.awakelab.leandrovillalba.sprint6.service.*;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
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

        // Preguntar sobre cálculos fuera del controller
        // variable = objLiquidacionService.operacionMatematica(parametros, queNecesite)

        liquidacion.setInstitucionPrevision(instPrev);
        liquidacion.setInstitucionSalud(instSalud);
        liquidacion.setTrabajador(trabajador);
        liquidacion.setPeriodo(LocalDate.now());
        //System.out.println("Sueldo Imponible: $" + sueldoImponible);
        float dctoSalud = instSalud.getPorcDcto();
        float dctoPrev = instPrev.getPorcDcto();
        float montoSalud1 = sueldoImponible * (dctoSalud / 100);
        float montoPrev1 = sueldoImponible * (dctoPrev / 100);
        liquidacion.setMontoInstitucionSalud(montoSalud1);
        liquidacion.setMontoInstitucionPrevisional(montoPrev1);
        float totalDcto = montoSalud1 + montoPrev1;
        liquidacion.setTotalDescuento(totalDcto);
        liquidacion.setTotalHaberes(sueldoImponible);
        float sueldoLiquido = sueldoImponible - totalDcto - anticipo;
        liquidacion.setSueldoLiquido(sueldoLiquido);

        objLiquidacionService.crearLiquidacion(liquidacion);
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
                                        @RequestParam int anticipo
                                        ) {

        Trabajador trabajador = objTrabajadorService.buscarTrabajadorPorId(trabajadorId);
        System.out.println("******************** ID Trabajador: " + trabajadorId);
        InstitucionSalud instSalud = objInstSaludService.buscarInstitucionSaludPorId(institucionSalud);
        InstitucionPrevision instPrev = objInstPrevService.buscarInstitucionPrevisionPorId(institucionPrevision);
        System.out.println("******************** ID Prevision: " + institucionPrevision);
        liquidacion.setTrabajador(trabajador);
        liquidacion.setInstitucionSalud(instSalud);
        liquidacion.setInstitucionPrevision(instPrev);

        float dctoSalud = instSalud.getPorcDcto();
        float dctoPrev = instPrev.getPorcDcto();
        float montoSalud1 = sueldoImponible * (dctoSalud / 100);
        float montoPrev1 = sueldoImponible * (dctoPrev / 100);
        liquidacion.setMontoInstitucionSalud(montoSalud1);
        liquidacion.setMontoInstitucionPrevisional(montoPrev1);
        float totalDcto = montoSalud1 + montoPrev1;
        liquidacion.setTotalDescuento(totalDcto);
        liquidacion.setTotalHaberes(sueldoImponible);
        float sueldoLiquido = sueldoImponible - totalDcto - anticipo;
        liquidacion.setSueldoLiquido(sueldoLiquido);

        objLiquidacionService.actualizarLiquidacion2(liquidacion);
        return "redirect:/liquidacion/listaLiquidaciones";
    }




    @GetMapping("{idLiquidacion}/eliminar")
    public String eliminarLiquidacion(@PathVariable long idLiquidacion) {
        Liquidacion liquidacion = objLiquidacionService.buscarLiquidacionPorId(idLiquidacion);
        objLiquidacionService.eliminarLiquidacion2(idLiquidacion);
        return "redirect:/liquidacion/listaLiquidaciones";
    }








}
