package cl.awakelab.leandrovillalba.sprint6.service.serviceimpl;

import cl.awakelab.leandrovillalba.sprint6.entity.InstitucionPrevision;
import cl.awakelab.leandrovillalba.sprint6.repository.IInstitucionPrevisionRepository;
import cl.awakelab.leandrovillalba.sprint6.service.IInstitucionPrevisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.NoSuchElementException;

@Repository("institucionPrevisionImpl")
public class InstitucionPrevisionImpl implements IInstitucionPrevisionService {
    @Autowired
    IInstitucionPrevisionRepository objInstPrevRepo;

    @Override
    public InstitucionPrevision crearInstituciontPrevision(InstitucionPrevision instPrev) {
        return objInstPrevRepo.save(instPrev);
    }

    @Override
    public List<InstitucionPrevision> listarInstitucionesPrevision() {
        return objInstPrevRepo.findAll();
    }

    @Override
    public InstitucionPrevision buscarInstitucionPrevisionPorId(int idInstPrev) {
        return objInstPrevRepo.findById(idInstPrev).orElseThrow(() -> new NoSuchElementException("Institución Previsional no encontrada"));
    }

    @Override
    public InstitucionPrevision actualizarInstitucionPrevision(InstitucionPrevision instPrevActualizar, int idInstPrev) {
        InstitucionPrevision instPrev = objInstPrevRepo.findById(idInstPrev).orElseThrow(() -> new NoSuchElementException("Institución Previsional no encontrada"));
        instPrev.setIdInstitucionPrevision(instPrevActualizar.getIdInstitucionPrevision());
        instPrev.setDescripcion(instPrevActualizar.getDescripcion());
        instPrev.setPorcDcto(instPrevActualizar.getPorcDcto());
        return objInstPrevRepo.save(instPrev);
    }

    @Override
    public InstitucionPrevision actualizarInstitucionPrevision2(InstitucionPrevision instPrevActualizar) {
        InstitucionPrevision instPrev = objInstPrevRepo.findById(instPrevActualizar.getIdInstitucionPrevision()).orElseThrow(() -> new NoSuchElementException("Institución Previsional no encontrada"));
        instPrev.setIdInstitucionPrevision(instPrevActualizar.getIdInstitucionPrevision());
        instPrev.setDescripcion(instPrevActualizar.getDescripcion());
        instPrev.setPorcDcto(instPrevActualizar.getPorcDcto());
        return objInstPrevRepo.save(instPrev);
    }

    @Override
    public void eliminarInstitucionPrevision(InstitucionPrevision instPrev) {
        objInstPrevRepo.delete(instPrev);
    }

    @Override
    public void eliminarInstitucionPrevision2(int idInstPrev) {
        objInstPrevRepo.deleteById(idInstPrev);
    }
}
