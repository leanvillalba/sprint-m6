package cl.awakelab.leandrovillalba.sprint6.entity;

import com.jayway.jsonpath.internal.filter.ValueNodes;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "usuario")
public class Usuario {
    @Id
    @Column (nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUsuario;
    @Column (unique = true, nullable = false)
    private int run;
    @Column (length = 200, nullable = false)
    private String clave;
    @Column (length = 100, nullable = false)
    private String nombre;
    @Column (name ="apellido_1", length = 100, nullable = false)
    private String apellido1;
    @Column (name ="apellido_2", length = 100)
    private String apellido2;

    @ManyToOne(optional = false, fetch = FetchType.EAGER) //CascadeAll causaba recursión infinita
    @JoinColumn(name = "id_perfil", nullable = false)
    private Perfil perfil;

    @Column (length = 100, nullable = false)
    private String email;
    @Column (nullable = false)
    private LocalDateTime fechaCreacion = LocalDateTime.now();
    @Column
    private Long telefono;

    @OneToMany(mappedBy = "usuario")
    private List<Empleador> listaEmpleadores;

}
