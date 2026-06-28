package ferramentas.controledeferramentas.Controller;

import ferramentas.controledeferramentas.Dtos.ProdutoDto;
import ferramentas.controledeferramentas.Repositorys.EstoqueRepository;
import ferramentas.controledeferramentas.Service.EstoqueService;
import ferramentas.controledeferramentas.Service.ProdutoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class EstoqueController {

    private final EstoqueService service;
    private final ProdutoService produtoService;

    public EstoqueController(EstoqueService service, ProdutoService produtoService) {
        this.service = service;
        this.produtoService = produtoService;
    }

    @GetMapping("/listaestoque")
    public String viewLista(Model model){

        List<ProdutoDto> lista = produtoService.listarProdutoOrdemAlfabetica();

        model.addAttribute("listaproduto", lista);

        return "/listaestoque";
    }
}
