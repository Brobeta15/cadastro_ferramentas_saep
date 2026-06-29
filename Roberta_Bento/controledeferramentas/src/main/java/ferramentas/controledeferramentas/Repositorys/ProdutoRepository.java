package ferramentas.controledeferramentas.Repositorys;

import ferramentas.controledeferramentas.Models.ProdutoModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<ProdutoModel, Long> {

    Page<ProdutoModel> findByNomeContainingIgnoreCase(String nome, Pageable pageable);
}
