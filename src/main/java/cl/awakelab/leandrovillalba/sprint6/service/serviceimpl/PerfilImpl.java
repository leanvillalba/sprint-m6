package cl.awakelab.leandrovillalba.sprint6.service.serviceimpl;

import cl.awakelab.leandrovillalba.sprint6.entity.Perfil;
import cl.awakelab.leandrovillalba.sprint6.repository.IPerfilRepository;
import cl.awakelab.leandrovillalba.sprint6.service.IPerfilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service("perfilImpl")
public class PerfilImpl implements IPerfilService {
    @Autowired
    IPerfilRepository objPerfilRepo;

    @Override
    public Perfil crearPerfil(Perfil perfil) {
        return objPerfilRepo.save(perfil);
    }

    @Override
    public List<Perfil> listarPerfiles() {
        return objPerfilRepo.findAll();
    }

    @Override
    public Perfil buscarPerfilPorId(int idPerfil) {
        return objPerfilRepo.findById(idPerfil).orElseThrow(() -> new NoSuchElementException("Perfil no encontrado"));
    }

    @Override
    public Perfil actualizarPerfil(Perfil perfilActualizar, int idPerfil) {
        Perfil perfil = objPerfilRepo.findById(idPerfil).orElseThrow(() -> new NoSuchElementException("Perfil no encontrado"));
        perfil.setDescripcion(perfilActualizar.getDescripcion());
        perfil.setEstado(perfilActualizar.getEstado());
        return objPerfilRepo.save(perfil);
    }

    @Override
    public Perfil actualizarPerfil2(Perfil perfilActualizar) {
        Perfil perfil = objPerfilRepo.findById(perfilActualizar.getIdPerfil()).orElseThrow(() -> new NoSuchElementException("Perfil no encontrado"));
        perfil.setDescripcion(perfilActualizar.getDescripcion());
        perfil.setEstado(perfilActualizar.getEstado());
        return objPerfilRepo.save(perfil);
    }

    @Override
    public void eliminarPerfil(Perfil perfil) {
        objPerfilRepo.delete(perfil);
    }

    @Override
    public void eliminarPerfil2(int idPerfil) {
        objPerfilRepo.deleteById(idPerfil);
    }
}
