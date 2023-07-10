package cl.awakelab.leandrovillalba.sprint6.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "institucion_salud")
public class InstitucionSalud {
    @Id
    @Column
    private int idInstitucionSalud;
    @Column
    private String descripcion;
    @Column
    private float porcDcto;
}

