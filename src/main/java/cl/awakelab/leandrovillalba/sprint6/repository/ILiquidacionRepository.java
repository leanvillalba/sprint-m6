package cl.awakelab.leandrovillalba.sprint6.repository;

import cl.awakelab.leandrovillalba.sprint6.entity.Liquidacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ILiquidacionRepository extends JpaRepository<Liquidacion, Long> {
}
