package cl.awakelab.leandrovillalba.sprint6.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "trabajador")
public class Trabajador {
    @Id
    @Column (nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTrabajador;
    @Column (unique = true, nullable = false)
    private int run;
    @Column (length = 100, nullable = false)
    private String nombre;
    @Column (name ="apellido_1", length = 100, nullable = false)
    private String apellido1;
    @Column (name ="apellido_2", length = 100)
    private String apellido2;
    @Column
    private String email;

    @ManyToOne (optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn (name = "id_inst_prevision", nullable = false)
    private InstitucionPrevision institucionPrevision;

    @ManyToOne (optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn (name = "id_inst_salud", nullable = false)
    private InstitucionSalud institucionSalud;

    @Column
    private Long telefono;

    @OneToMany (mappedBy = "trabajador")
    private List<Liquidacion> listaLiquidaciones;

    @ManyToMany
    @JoinTable (name = "empl_trab",
                joinColumns = @JoinColumn(name = "id_trabajador", nullable = false),
                inverseJoinColumns = @JoinColumn (name = "id_empleador", nullable = false))
    private List<Empleador> listaEmpleadores;

}
