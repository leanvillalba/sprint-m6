package cl.awakelab.leandrovillalba.sprint6.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "institucion_salud")
public class InstitucionSalud {
    @Id
    @Column (nullable = false)
    private int idInstitucionSalud;
    @Column (length = 50, nullable = false)
    private String descripcion;
    @Column (nullable = false)
    private float porcDcto;

    @OneToMany(mappedBy = "institucionSalud")
    private List<Trabajador> listaTrabajadores;

    @OneToMany(mappedBy = "institucionSalud")
    private List<Liquidacion> listaLiquidaciones;

}

