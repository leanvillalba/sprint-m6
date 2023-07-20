package cl.awakelab.leandrovillalba.sprint6.service;

import cl.awakelab.leandrovillalba.sprint6.entity.Empleador;
import cl.awakelab.leandrovillalba.sprint6.entity.Usuario;

import java.util.List;

public interface IEmpleadorService {
    Empleador crearEmpleador(Empleador empleador);
    List<Empleador> listarEmpleadores();
    Empleador buscarEmpleardorPorId(int idEmpleador);
    Empleador actualizarEmpleador(Empleador empleadorActualizar);
    void eliminarEmpleador(int idEmpleador);
    Empleador crearEmpleadorDesdeUsuario(Usuario usuario);

}
