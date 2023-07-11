package cl.awakelab.leandrovillalba.sprint6.service;

import cl.awakelab.leandrovillalba.sprint6.entity.InstitucionSalud;

import java.util.List;

public interface IInstitucionSaludService {
    InstitucionSalud crearInstitucionSalud(InstitucionSalud instSalud);
    List<InstitucionSalud> listarInstitucionesSalud();
    InstitucionSalud buscarInstitucionSaludPorId(int idInstSalud);
    InstitucionSalud actualizarInstitucionSalud(InstitucionSalud instSalud, int idInstSalud);
    InstitucionSalud actualizarInstitucionSalud2(InstitucionSalud instSaludActualizar);
    void eliminarInstSalud(InstitucionSalud instSalud);
    void eliminarInstSalud(int idInstSalud);

}
