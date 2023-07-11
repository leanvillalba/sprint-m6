package cl.awakelab.leandrovillalba.sprint6.service;

import cl.awakelab.leandrovillalba.sprint6.entity.Perfil;

import java.util.List;

public interface IPerfilService {
    Perfil crearPerfil(Perfil perfil);
    List<Perfil> listarPerfiles();
    Perfil buscarPerfilPorId(int idPerfil);
    Perfil actualizarPerfil(Perfil perfil, int idPerfil);
    Perfil actualizarPerfil2(Perfil perfilActualizar);
    void eliminarPerfil(Perfil perfil);
    void eliminarPerfil2(int idPerfil);
}
