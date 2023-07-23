package cl.awakelab.leandrovillalba.sprint6.service;

import cl.awakelab.leandrovillalba.sprint6.entity.Liquidacion;

import java.util.List;

public interface ILiquidacionService {
    Liquidacion crearLiquidacion(Liquidacion liquidacion);
    List<Liquidacion> listarLiquidaciones();
    Liquidacion buscarLiquidacionPorId(long idLiquidacion);
    Liquidacion actualizarLiquidacion(Liquidacion liquidacion, long idLiquidacion);
    Liquidacion actualizarLiquidacion2(Liquidacion liquidacionActualizar);

    Liquidacion crearLiquidacion2(Liquidacion liquidacionActualizar);

    void eliminarLiquidacion(Liquidacion liquidacion);
    void eliminarLiquidacion2(long idLiquidacion);
}
