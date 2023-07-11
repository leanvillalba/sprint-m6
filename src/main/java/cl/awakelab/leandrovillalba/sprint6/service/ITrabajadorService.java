package cl.awakelab.leandrovillalba.sprint6.service;

import cl.awakelab.leandrovillalba.sprint6.entity.Trabajador;

import java.util.List;

public interface ITrabajadorService {
    Trabajador crearTrabajador(Trabajador trabajador);
    List<Trabajador> listarTrabajadores();
    Trabajador buscarTrabajadorPorId(int idTrabajador);
    Trabajador actualizarTrabajador(Trabajador trabajador, int idTrabajador);
    Trabajador actualizarTrabajador2(Trabajador trabajadorActualizar);
    void eliminarTrabajador(Trabajador trabajador);
    void eliminarTrabajador2(int idTrabajador);
}
