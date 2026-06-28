package ferramentas.controledeferramentas.Repositorys;

import ferramentas.controledeferramentas.Models.EstoqueModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstoqueRepository extends JpaRepository<EstoqueModel, Long> {
}
