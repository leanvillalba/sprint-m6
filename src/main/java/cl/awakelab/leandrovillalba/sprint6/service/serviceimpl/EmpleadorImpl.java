package cl.awakelab.leandrovillalba.sprint6.service.serviceimpl;

import cl.awakelab.leandrovillalba.sprint6.entity.Empleador;
import cl.awakelab.leandrovillalba.sprint6.entity.Usuario;
import cl.awakelab.leandrovillalba.sprint6.repository.IEmpleadorRepository;
import cl.awakelab.leandrovillalba.sprint6.service.IEmpleadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.NoSuchElementException;

@Repository("empleadorImpl")
public class EmpleadorImpl implements IEmpleadorService {
    @Autowired
    IEmpleadorRepository objEmpleadorRepo;

    @Override
    public Empleador crearEmpleador(Empleador empleador) {
        return objEmpleadorRepo.save(empleador);
    }

    @Override
    public List<Empleador> listarEmpleadores() {
        return objEmpleadorRepo.findAll();
    }

    @Override
    public Empleador buscarEmpleardorPorId(int idEmpleador) {
        return objEmpleadorRepo.findById(idEmpleador).orElseThrow(() -> new NoSuchElementException("Empleador no encontrado"));
    }

    @Override
    public Empleador actualizarEmpleador(Empleador empleadorActualizar) {
        Empleador empleador = objEmpleadorRepo.findById(empleadorActualizar.getIdEmpleador()).orElseThrow(() -> new NoSuchElementException("Empleador no encontrado"));
        empleador.setRun(empleadorActualizar.getRun());
        empleador.setNombre(empleadorActualizar.getNombre());
        empleador.setApellido1(empleadorActualizar.getApellido1());
        empleador.setApellido2(empleadorActualizar.getApellido2());
        empleador.setDireccion(empleadorActualizar.getDireccion());
        empleador.setEmail(empleadorActualizar.getEmail());
        empleador.setTelefono(empleadorActualizar.getTelefono());
        return objEmpleadorRepo.save(empleador);
    }

    @Override
    public void eliminarEmpleador(int idEmpleador) {
        objEmpleadorRepo.deleteById(idEmpleador);
    }

    @Override
    public Empleador crearEmpleadorDesdeUsuario(Usuario usuario) {
        Empleador empleador = new Empleador();
        empleador.setRun(usuario.getRun());
        empleador.setNombre(usuario.getNombre());
        empleador.setApellido1(usuario.getApellido1());
        empleador.setApellido2(usuario.getApellido2());
        empleador.setEmail(usuario.getEmail());
        empleador.setTelefono(usuario.getTelefono());
        empleador.setUsuario(usuario);
        return objEmpleadorRepo.save(empleador);
    }

}
