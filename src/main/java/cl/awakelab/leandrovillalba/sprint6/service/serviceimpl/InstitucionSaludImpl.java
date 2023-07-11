package cl.awakelab.leandrovillalba.sprint6.service.serviceimpl;

import cl.awakelab.leandrovillalba.sprint6.entity.InstitucionSalud;
import cl.awakelab.leandrovillalba.sprint6.repository.IInstitucionSaludRepository;
import cl.awakelab.leandrovillalba.sprint6.service.IInstitucionSaludService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.NoSuchElementException;

@Repository("institucionSaludImpl")
public class InstitucionSaludImpl implements IInstitucionSaludService {
    @Autowired
    IInstitucionSaludRepository objInstSaludRepo;
    @Override
    public InstitucionSalud crearInstitucionSalud(InstitucionSalud instSalud) {
        return objInstSaludRepo.save(instSalud);
    }

    @Override
    public List<InstitucionSalud> listarInstitucionesSalud() {
        return objInstSaludRepo.findAll();
    }

    @Override
    public InstitucionSalud buscarInstitucionSaludPorId(int idInstSalud) {
        return objInstSaludRepo.findById(idInstSalud).orElseThrow(() -> new NoSuchElementException("Institución de Salud no encontrada"));
    }

    @Override
    public InstitucionSalud actualizarInstitucionSalud(InstitucionSalud instSaludActualizar, int idInstSalud) {
        InstitucionSalud instSalud = objInstSaludRepo.findById(idInstSalud).orElseThrow(() -> new NoSuchElementException("Institución de Salud no encontrada"));
        instSalud.setIdInstitucionSalud(instSaludActualizar.getIdInstitucionSalud());
        instSalud.setDescripcion(instSaludActualizar.getDescripcion());
        instSalud.setPorcDcto(instSaludActualizar.getPorcDcto());
        return objInstSaludRepo.save(instSalud);
    }

    @Override
    public InstitucionSalud actualizarInstitucionSalud2(InstitucionSalud instSaludActualizar) {
        InstitucionSalud instSalud = objInstSaludRepo.findById(instSaludActualizar.getIdInstitucionSalud()).orElseThrow(() -> new NoSuchElementException("Institución de Salud no encontrada"));
        instSalud.setIdInstitucionSalud(instSaludActualizar.getIdInstitucionSalud());
        instSalud.setDescripcion(instSaludActualizar.getDescripcion());
        instSalud.setPorcDcto(instSaludActualizar.getPorcDcto());
        return objInstSaludRepo.save(instSalud);
    }

    @Override
    public void eliminarInstSalud(InstitucionSalud instSalud) {
        objInstSaludRepo.delete(instSalud);
    }

    @Override
    public void eliminarInstSalud(int idInstSalud) {
        objInstSaludRepo.deleteById(idInstSalud);
    }
}
