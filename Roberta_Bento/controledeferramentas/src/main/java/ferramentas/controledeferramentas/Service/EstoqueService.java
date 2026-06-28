package ferramentas.controledeferramentas.Service;

import ferramentas.controledeferramentas.Dtos.ProdutoDto;
import ferramentas.controledeferramentas.Models.ProdutoModel;
import ferramentas.controledeferramentas.Repositorys.EstoqueRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EstoqueService {

    private final EstoqueRepository repository;


    public EstoqueService(EstoqueRepository repository) {
        this.repository = repository;
    }

}
