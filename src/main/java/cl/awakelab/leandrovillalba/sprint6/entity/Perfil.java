package cl.awakelab.leandrovillalba.sprint6.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "perfil")
public class Perfil {
    @Id
    @Column (nullable = false)
    private int idPerfil;
    @Column (length = 200, nullable = false)
    private String descripcion;
    @Column (nullable = false)
    private int estado;

    @OneToMany(mappedBy = "perfil")
    private List<Usuario> listaUsuarios;

}
