package cl.awakelab.leandrovillalba.sprint6.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "institucion_prevision")
public class InstitucionPrevision {
    @Id
    @Column (nullable = false)
    private int idInstitucionPrevision;
    @Column (length = 50, nullable = false)
    private String descripcion;
    @Column (nullable = false)
    private float porcDcto;

    @OneToMany(mappedBy = "institucionPrevision")
    private List<Trabajador> listaTrabajadores;

    @OneToMany(mappedBy = "institucionPrevision")
    private List<Liquidacion> listaLiquidaciones;

}
