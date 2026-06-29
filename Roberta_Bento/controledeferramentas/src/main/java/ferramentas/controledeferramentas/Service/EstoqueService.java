package ferramentas.controledeferramentas.Service;

import ferramentas.controledeferramentas.Dtos.EstoqueDto;
import ferramentas.controledeferramentas.Dtos.ProdutoDto;
import ferramentas.controledeferramentas.Models.EstoqueModel;
import ferramentas.controledeferramentas.Models.ProdutoModel;
import ferramentas.controledeferramentas.Repositorys.EstoqueRepository;
import ferramentas.controledeferramentas.Repositorys.ProdutoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EstoqueService {

    private final EstoqueRepository repository;
    private final ProdutoRepository produtoRepository;
    private final ProdutoService produtoService;

    public EstoqueService(EstoqueRepository repository, ProdutoRepository produtoRepository, ProdutoService produtoService) {
        this.repository = repository;
        this.produtoRepository = produtoRepository;
        this.produtoService = produtoService;
    }

    public EstoqueDto retornarEstoqueDto(ProdutoDto produtoDto){

        EstoqueDto dto = new EstoqueDto();
        dto.setNome(produtoDto.getNome());
        dto.setIdProduto(produtoDto.getId());

        return dto;
    }

    public boolean movimentarEstoque(EstoqueDto dto, Long id){

        Optional<ProdutoModel> produtoOp = produtoRepository.findById(id);
        EstoqueModel model = new EstoqueModel();

        if (dto.getTipo().equals("SAIDA")){

            if (dto.getValor()<=produtoOp.get().getEstoque()){

                model.setData(dto.getData());
                model.setProduto(produtoOp.get());
                model.setTipo(dto.getTipo());
                model.setValor(dto.getValor());
                produtoService.retirarEstoque(id,dto.getValor());

                repository.save(model);
                return true;
            }
        }else{

            model.setData(dto.getData());
            model.setProduto(produtoOp.get());
            model.setTipo(dto.getTipo());
            model.setValor(dto.getValor());
            produtoService.adicionarEstoque(id,dto.getValor());

            repository.save(model);
            return true;
        }
        return false;
    }

    public List<EstoqueDto> retornarLista(Long idProduto){

        List<EstoqueModel> estoqueOP = repository.findByProdutoId(idProduto);

        List<EstoqueDto> lista = new ArrayList<>();

        for (int i = 0; i < estoqueOP.size(); i++) {

            EstoqueDto dto = new EstoqueDto();

            dto.setId(estoqueOP.get(i).getId());
            dto.setData(estoqueOP.get(i).getData());
            dto.setTipo(estoqueOP.get(i).getTipo());
            dto.setValor(estoqueOP.get(i).getValor());
            dto.setNome(produtoService.encontrarProduto(idProduto).getNome());

            lista.add(dto);
        }
        return lista;
    }



}
