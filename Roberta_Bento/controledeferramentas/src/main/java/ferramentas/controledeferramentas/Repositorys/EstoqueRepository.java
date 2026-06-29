package ferramentas.controledeferramentas.Repositorys;

import ferramentas.controledeferramentas.Models.EstoqueModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EstoqueRepository extends JpaRepository<EstoqueModel, Long> {

    List<EstoqueModel> findByProdutoId(Long idProduto);
}
