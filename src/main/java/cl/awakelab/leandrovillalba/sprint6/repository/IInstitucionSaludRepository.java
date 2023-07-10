package cl.awakelab.leandrovillalba.sprint6.repository;

import cl.awakelab.leandrovillalba.sprint6.entity.InstitucionSalud;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IInstitucionSaludRepository extends JpaRepository<InstitucionSalud, Integer> {
}
