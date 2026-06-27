package ferramentas.controledeferramentas.Repositorys;

import ferramentas.controledeferramentas.Models.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LoginRepository extends JpaRepository<UsuarioModel, String> {

    Optional<UsuarioModel> findByEmail(String email);
}
