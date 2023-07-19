package cl.awakelab.leandrovillalba.sprint6.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "perfil")
public class Perfil {
    @Id
    @Column (name = "id_perfil", nullable = false)
    private int idPerfil;
    @Column (length = 200, nullable = false)
    private String descripcion;
    @Column (nullable = false)
    private int estado;

    @OneToMany(mappedBy = "perfil")
    @JsonIgnore //para evitar la recursión infinita
    private List<Usuario> listaUsuarios;

}
