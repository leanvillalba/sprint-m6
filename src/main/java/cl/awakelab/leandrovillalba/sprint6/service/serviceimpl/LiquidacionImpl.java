package cl.awakelab.leandrovillalba.sprint6.service.serviceimpl;

import cl.awakelab.leandrovillalba.sprint6.entity.Liquidacion;
import cl.awakelab.leandrovillalba.sprint6.repository.ILiquidacionRepository;
import cl.awakelab.leandrovillalba.sprint6.service.ILiquidacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;

@Repository("liquidacionImpl")
public class LiquidacionImpl implements ILiquidacionService {
    @Autowired
    ILiquidacionRepository objLiquidacionRepo;
    @Override
    public Liquidacion crearLiquidacion(Liquidacion liquidacion) {
        return objLiquidacionRepo.save(liquidacion);
    }

    @Override
    public List<Liquidacion> listarLiquidaciones() {
        return objLiquidacionRepo.findAll();
    }

    @Override
    public Liquidacion buscarLiquidacionPorId(long idLiquidacion) {
        return objLiquidacionRepo.findById(idLiquidacion).orElseThrow(() -> new NoSuchElementException("Liquidación no encontrada"));
    }

    @Override
    public Liquidacion actualizarLiquidacion(Liquidacion liquidacionActualizar, long idLiquidacion) {
        Liquidacion liquidacion = objLiquidacionRepo.findById(idLiquidacion).orElseThrow(() -> new NoSuchElementException("Liquidación no encontrada"));
        liquidacion.setPeriodo(liquidacionActualizar.getPeriodo());
        liquidacion.setSueldoImponible(liquidacionActualizar.getSueldoImponible());
        liquidacion.setSueldoLiquido(liquidacionActualizar.getSueldoLiquido());
        liquidacion.setMontoInstitucionSalud(liquidacionActualizar.getMontoInstitucionSalud());
        liquidacion.setMontoInstitucionPrevisional(liquidacionActualizar.getMontoInstitucionPrevisional());
        liquidacion.setTotalDescuento(liquidacionActualizar.getTotalDescuento());
        liquidacion.setTotalHaberes(liquidacionActualizar.getTotalHaberes());
        liquidacion.setAnticipo(liquidacionActualizar.getAnticipo());
        return objLiquidacionRepo.save(liquidacion);
    }

    @Override
    public Liquidacion actualizarLiquidacion2(Liquidacion liquidacionActualizar) {
        Liquidacion liquidacion = objLiquidacionRepo.findById(liquidacionActualizar.getIdLiquidacion()).orElseThrow(() -> new NoSuchElementException("Liquidación no encontrada"));
        //liquidacion.setPeriodo(liquidacionActualizar.getPeriodo());
        liquidacion.setSueldoImponible(liquidacionActualizar.getSueldoImponible());
        liquidacion.setSueldoLiquido(liquidacionActualizar.getSueldoLiquido());
        liquidacion.setMontoInstitucionSalud(liquidacionActualizar.getMontoInstitucionSalud());
        liquidacion.setMontoInstitucionPrevisional(liquidacionActualizar.getMontoInstitucionPrevisional());
        liquidacion.setTotalDescuento(liquidacionActualizar.getTotalDescuento());
        liquidacion.setTotalHaberes(liquidacionActualizar.getTotalHaberes());
        liquidacion.setAnticipo(liquidacionActualizar.getAnticipo());
        liquidacion.setTrabajador(liquidacionActualizar.getTrabajador());
        liquidacion.setInstitucionSalud(liquidacionActualizar.getInstitucionSalud());
        liquidacion.setInstitucionPrevision(liquidacionActualizar.getInstitucionPrevision());
        return objLiquidacionRepo.save(liquidacion);
    }

    @Override
    public Liquidacion crearLiquidacion2(Liquidacion liquidacionActualizar) {
        Liquidacion liquidacion = new Liquidacion();
        liquidacion.setPeriodo(LocalDate.now());


        liquidacion.setSueldoImponible(liquidacionActualizar.getSueldoImponible());
        liquidacion.setSueldoLiquido(liquidacionActualizar.getSueldoLiquido());
        liquidacion.setMontoInstitucionSalud(liquidacionActualizar.getMontoInstitucionSalud());
        liquidacion.setMontoInstitucionPrevisional(liquidacionActualizar.getMontoInstitucionPrevisional());
        liquidacion.setTotalDescuento(liquidacionActualizar.getTotalDescuento());
        liquidacion.setTotalHaberes(liquidacionActualizar.getTotalHaberes());
        liquidacion.setAnticipo(liquidacionActualizar.getAnticipo());
        return objLiquidacionRepo.save(liquidacion);
    }

    @Override
    public void eliminarLiquidacion(Liquidacion liquidacion) {
        objLiquidacionRepo.delete(liquidacion);
    }

    @Override
    public void eliminarLiquidacion2(long idLiquidacion) {
        objLiquidacionRepo.deleteById(idLiquidacion);
    }
}
