package cl.awakelab.leandrovillalba.sprint6.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "perfil")
public class Perfil {
    @Id
    @Column
    private int idPerfil;
    @Column
    private String descripcion;
    @Column
    private int estado;

}
