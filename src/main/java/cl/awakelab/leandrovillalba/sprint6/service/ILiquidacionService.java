package cl.awakelab.leandrovillalba.sprint6.service;

import cl.awakelab.leandrovillalba.sprint6.entity.InstitucionPrevision;
import cl.awakelab.leandrovillalba.sprint6.entity.InstitucionSalud;
import cl.awakelab.leandrovillalba.sprint6.entity.Liquidacion;
import cl.awakelab.leandrovillalba.sprint6.entity.Trabajador;

import java.util.List;

public interface ILiquidacionService {
    Liquidacion crearLiquidacion(Liquidacion liquidacion, Trabajador trabajador, InstitucionSalud instSalud, InstitucionPrevision instPrev, float sueldoImponible, int anticipo);
    List<Liquidacion> listarLiquidaciones();
    Liquidacion buscarLiquidacionPorId(long idLiquidacion);
    Liquidacion actualizarLiquidacion(Liquidacion liquidacion, Trabajador trabajador, InstitucionSalud instSalud, InstitucionPrevision instPrev, float sueldoImponible, int anticipo);
    void eliminarLiquidacion(long idLiquidacion);
}
