package cl.awakelab.leandrovillalba.sprint6.service;

import cl.awakelab.leandrovillalba.sprint6.entity.Liquidacion;

import java.util.List;

public interface ILiquidacionService {
    Liquidacion crearLiquidacion(Liquidacion liquidacion);
    List<Liquidacion> listarLiquidaciones();
    Liquidacion buscarLiquidacionPorId(int idLiquidacion);
    Liquidacion actualizarLiquidacion(Liquidacion liquidacion, int idLiquidacion);
    Liquidacion actualizarLiquidacion2(Liquidacion liquidacionActualizar);
    void eliminarLiquidacion(Liquidacion liquidacion);
    void eliminarLiquidacion2(int idLiquidacion);
}
