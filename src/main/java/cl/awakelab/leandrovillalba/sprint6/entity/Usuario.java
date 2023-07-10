package cl.awakelab.leandrovillalba.sprint6.entity;

import com.jayway.jsonpath.internal.filter.ValueNodes;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "usuario")
public class Usuario {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUsuario;
    @Column
    private int run;
    @Column
    private String clave;
    @Column
    private String nombre;
    @Column
    private String apellido1;
    @Column
    private String apellido2;
    @Column
    private int idPerfil;
    @Column
    private String email;
    @Column
    private Date fechaCreacion; //todo Checkear tipo de Dato: en BBDD DATETIME
    @Column
    private Long telefono;

}
