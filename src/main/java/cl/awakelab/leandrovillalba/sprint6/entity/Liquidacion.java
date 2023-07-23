package cl.awakelab.leandrovillalba.sprint6.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "liquidacion")
public class Liquidacion {
    @Id
    @Column (name = "id_liquidacion", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idLiquidacion;

    @ManyToOne (optional = false, fetch = FetchType.EAGER)
    @JoinColumn (name = "id_trabajador", nullable = false)
    private Trabajador trabajador;

    @Column (nullable = false)
    private LocalDate periodo;
    @Column (name = "sueldo_imponible", nullable = false)
    private float sueldoImponible;
    @Column (name = "sueldo_liquido", nullable = false)
    private float sueldoLiquido;

    @ManyToOne (optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_inst_salud", nullable = false)
    private InstitucionSalud institucionSalud;

    @Column (name = "monto_inst_salud", nullable = false)
    private float montoInstitucionSalud;

    @ManyToOne (optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_inst_prevision", nullable = false)
    private InstitucionPrevision institucionPrevision;

    @Column (name = "monto_inst_prevision", nullable = false)
    private float montoInstitucionPrevisional;
    @Column (name = "total_descuento",nullable = false)
    private float totalDescuento;
    @Column (name = "total_haberes",nullable = false)
    private float totalHaberes;
    @Column (nullable = false)
    private int anticipo;

}
