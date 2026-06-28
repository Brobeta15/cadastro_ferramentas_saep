package ferramentas.controledeferramentas.Service;

import ferramentas.controledeferramentas.Dtos.ProdutoDto;
import ferramentas.controledeferramentas.Models.ProdutoModel;
import ferramentas.controledeferramentas.Repositorys.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public void cadastrarProduto(ProdutoDto dto){

        ProdutoModel model = new ProdutoModel();

        model.setNome(dto.getNome());
        model.setEstoque(dto.getEstoque());
        produtoRepository.save(model);
    }

    public List<ProdutoDto> listarProduto(){

        List<ProdutoModel> listaOP = produtoRepository.findAll();
        List<ProdutoDto> listaDto = new ArrayList<>();

        for (int i = 0; i < listaOP.size(); i++) {

            ProdutoDto dto = new ProdutoDto();

            dto.setId(listaOP.get(i).getId());
            dto.setNome(listaOP.get(i).getNome());
            dto.setEstoque(listaOP.get(i).getEstoque());

            listaDto.add(dto);
        }

        return listaDto;
    }
    public ProdutoDto encontrarProduto(Long id){

        Optional<ProdutoModel> produtoOp = produtoRepository.findById(id);

        ProdutoDto dto = new ProdutoDto();

        if (produtoOp.isPresent()){

            dto.setId(produtoOp.get().getId());
            dto.setEstoque(produtoOp.get().getEstoque());
            dto.setNome(produtoOp.get().getNome());

            return dto;
        }

        return dto;
    }
    public boolean alterarProduto(ProdutoDto dto, Long id){
        Optional<ProdutoModel> produtoOP = produtoRepository.findById(id);

        if (produtoOP.isPresent()){
            ProdutoModel model = new ProdutoModel();

            model.setId(id);
            model.setNome(dto.getNome());
            model.setEstoque(produtoOP.get().getEstoque());

            produtoRepository.save(model);

            return true;
        }

        return false;
    }

    public String deletarProduto(Long id){

        Optional<ProdutoModel> op = produtoRepository.findById(id);

        if (op.isPresent()){

            produtoRepository.deleteById(id);
            return "ok";
        }
        return "erro";
    }
}
