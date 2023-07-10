package cl.awakelab.leandrovillalba.sprint6.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "trabajador")
public class Trabajador {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTrabajador;
    @Column
    private int run;
    @Column
    private String nombre;
    @Column
    private String apellido1;
    @Column
    private String apellido2;
    @Column
    private String email;
    @Column
    private int idInstitucionPrevision;
    @Column
    private int idInstitucionSalud;
    @Column
    private Long telefono;

}
