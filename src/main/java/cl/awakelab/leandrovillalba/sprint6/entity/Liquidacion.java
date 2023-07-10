package cl.awakelab.leandrovillalba.sprint6.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "liquidacion")
public class Liquidacion {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idLiquidacion;
    @Column
    private int idTrabajador;
    @Column
    private Date periodo;
    @Column
    private int sueldoImponible;
    @Column
    private int sueldoLiquido;
    @Column
    private int idInsitucionSalud;
    @Column
    private float montoInstitucionSalud;
    @Column
    private int idInstitucionPrevisional;
    @Column
    private float montoInstitucionPrevisional;
    @Column
    private float totalDescuento;
    @Column
    private float totalHaberes;
    @Column
    private int anticipo;

}
