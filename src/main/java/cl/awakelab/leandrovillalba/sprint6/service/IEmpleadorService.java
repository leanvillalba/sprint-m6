package cl.awakelab.leandrovillalba.sprint6.service;

import cl.awakelab.leandrovillalba.sprint6.entity.Empleador;

import java.util.List;

public interface IEmpleadorService {
    Empleador crearEmpleador(Empleador empleador);
    List<Empleador> listarEmpleadores();
    Empleador buscarEmpleardorPorId(int idEmpleador);
    Empleador actualizarEmpleador(Empleador empleador, int idEmpleador);
    Empleador actualizarEmpleador2(Empleador empleadorActualizar);
    void eliminarEmpleador(Empleador empleador);
    void eliminarEmpleador2(int idEmpleador);
}
