package cl.awakelab.leandrovillalba.sprint6.service;

import cl.awakelab.leandrovillalba.sprint6.entity.InstitucionPrevision;

import java.util.List;

public interface IInstitucionPrevisionService {
    InstitucionPrevision crearInstituciontPrevision(InstitucionPrevision instPrev);
    List<InstitucionPrevision> listarInstitucionesPrevision();
    InstitucionPrevision buscarInstitucionPrevisionPorId(int idInstPrev);
    InstitucionPrevision actualizarInstitucionPrevision(InstitucionPrevision instPrev, int idInstPrev);
    InstitucionPrevision actualizarInstitucionPrevision2(InstitucionPrevision instPrevActualizar);
    void eliminarInstitucionPrevision(InstitucionPrevision instPrev);
    void eliminarInstitucionPrevision2(int idInstPrev);

}
