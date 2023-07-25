package cl.awakelab.leandrovillalba.sprint6.service.serviceimpl;

import cl.awakelab.leandrovillalba.sprint6.entity.InstitucionPrevision;
import cl.awakelab.leandrovillalba.sprint6.entity.InstitucionSalud;
import cl.awakelab.leandrovillalba.sprint6.entity.Liquidacion;
import cl.awakelab.leandrovillalba.sprint6.entity.Trabajador;
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
    public Liquidacion crearLiquidacion(Liquidacion liquidacion, Trabajador trabajador, InstitucionSalud instSalud, InstitucionPrevision instPrev, float sueldoImponible, int anticipo) {
        liquidacion.setTrabajador(trabajador);
        liquidacion.setInstitucionSalud(instSalud);
        liquidacion.setInstitucionPrevision(instPrev);
        liquidacion.setPeriodo(LocalDate.now());

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
    public Liquidacion actualizarLiquidacion(Liquidacion liquidacion, Trabajador trabajador, InstitucionSalud instSalud, InstitucionPrevision instPrev, float sueldoImponible, int anticipo) {
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

        return objLiquidacionRepo.save(liquidacion);
    }

    @Override
    public void eliminarLiquidacion(long idLiquidacion) {
        objLiquidacionRepo.deleteById(idLiquidacion);
    }
}
