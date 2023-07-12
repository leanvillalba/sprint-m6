package cl.awakelab.leandrovillalba.sprint6.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "liquidacion")
public class Liquidacion {
    @Id
    @Column (nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idLiquidacion;

    @ManyToOne (optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn (name = "id_trabajador", nullable = false)
    private Trabajador trabajador;

    @Column (nullable = false)
    private LocalDate periodo;

    @Column (nullable = false)
    private int sueldoImponible;
    @Column (nullable = false)
    private int sueldoLiquido;

    @ManyToOne (optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_inst_salud", nullable = false)
    private InstitucionSalud institucionSalud;

    @Column (nullable = false)
    private float montoInstitucionSalud;

    @ManyToOne (optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_inst_prevision", nullable = false)
    private InstitucionPrevision institucionPrevision;

    @Column (nullable = false)
    private float montoInstitucionPrevisional;
    @Column (nullable = false)
    private float totalDescuento;
    @Column (nullable = false)
    private float totalHaberes;
    @Column (nullable = false)
    private int anticipo;

}
