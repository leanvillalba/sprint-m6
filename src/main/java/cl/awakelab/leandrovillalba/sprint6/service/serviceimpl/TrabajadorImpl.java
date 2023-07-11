package cl.awakelab.leandrovillalba.sprint6.service.serviceimpl;

import cl.awakelab.leandrovillalba.sprint6.entity.Trabajador;
import cl.awakelab.leandrovillalba.sprint6.repository.ITrabajadorRepository;
import cl.awakelab.leandrovillalba.sprint6.service.ITrabajadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.NoSuchElementException;

@Repository("trabajadorImpl")
public class TrabajadorImpl implements ITrabajadorService {
    @Autowired
    ITrabajadorRepository objTrabajadorRepo;
    @Override
    public Trabajador crearTrabajador(Trabajador trabajador) {
        return objTrabajadorRepo.save(trabajador);
    }

    @Override
    public List<Trabajador> listarTrabajadores() {
        return objTrabajadorRepo.findAll();
    }

    @Override
    public Trabajador buscarTrabajadorPorId(int idTrabajador) {
        return objTrabajadorRepo.findById(idTrabajador).orElseThrow(() -> new NoSuchElementException("Trabajador no encontrado"));
    }

    @Override
    public Trabajador actualizarTrabajador(Trabajador trabajadorActualizar, int idTrabajador) {
        Trabajador trabajador = objTrabajadorRepo.findById(idTrabajador).orElseThrow(() -> new NoSuchElementException("Trabajador no encontrado"));
        trabajador.setRun(trabajadorActualizar.getRun());
        trabajador.setNombre(trabajadorActualizar.getNombre());
        trabajador.setApellido1(trabajadorActualizar.getApellido1());
        trabajador.setApellido2(trabajadorActualizar.getApellido2());
        trabajador.setEmail(trabajadorActualizar.getEmail());
        trabajador.setIdInstitucionPrevision(trabajadorActualizar.getIdInstitucionPrevision());
        trabajador.setIdInstitucionSalud(trabajadorActualizar.getIdInstitucionSalud());
        trabajador.setTelefono(trabajadorActualizar.getTelefono());
        return objTrabajadorRepo.save(trabajador);
    }

    @Override
    public Trabajador actualizarTrabajador2(Trabajador trabajadorActualizar) {
        Trabajador trabajador = objTrabajadorRepo.findById(trabajadorActualizar.getIdTrabajador()).orElseThrow(() -> new NoSuchElementException("Trabajador no encontrado"));
        trabajador.setRun(trabajadorActualizar.getRun());
        trabajador.setNombre(trabajadorActualizar.getNombre());
        trabajador.setApellido1(trabajadorActualizar.getApellido1());
        trabajador.setApellido2(trabajadorActualizar.getApellido2());
        trabajador.setEmail(trabajadorActualizar.getEmail());
        trabajador.setIdInstitucionPrevision(trabajadorActualizar.getIdInstitucionPrevision());
        trabajador.setIdInstitucionSalud(trabajadorActualizar.getIdInstitucionSalud());
        trabajador.setTelefono(trabajadorActualizar.getTelefono());
        return objTrabajadorRepo.save(trabajador);
    }

    @Override
    public void eliminarTrabajador(Trabajador trabajador) {
        objTrabajadorRepo.delete(trabajador);
        }

    @Override
    public void eliminarTrabajador2(int idTrabajador) {
        objTrabajadorRepo.deleteById(idTrabajador);
    }
}
