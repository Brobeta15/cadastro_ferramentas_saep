package ferramentas.controledeferramentas.Repositorys;

import ferramentas.controledeferramentas.Models.ProdutoModel;
import ferramentas.controledeferramentas.Models.UsuarioModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProdutoRepository extends JpaRepository<ProdutoModel, Long> {

    Page<ProdutoModel> findByNomeContainingIgnoreCase(String nome, Pageable pageable);

}
