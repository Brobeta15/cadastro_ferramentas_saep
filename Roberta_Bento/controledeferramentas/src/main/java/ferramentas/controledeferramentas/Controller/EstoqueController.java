package ferramentas.controledeferramentas.Controller;

import ferramentas.controledeferramentas.Dtos.EstoqueDto;
import ferramentas.controledeferramentas.Dtos.ProdutoDto;
import ferramentas.controledeferramentas.Repositorys.EstoqueRepository;
import ferramentas.controledeferramentas.Service.EstoqueService;
import ferramentas.controledeferramentas.Service.ProdutoService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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

    @GetMapping("/estoque/{id}")
    public String viewMovimentarEstoque(Model model, @PathVariable Long id){

        ProdutoDto produtoDto = produtoService.encontrarProduto(id);

        model.addAttribute("EstoqueDto", service.retornarEstoqueDto(produtoDto));

        return "/estoque";
    }

    @PostMapping("/estoque/{id}")
    public String movimentarEstoque(@ModelAttribute("EstoqueDto") EstoqueDto dto, @PathVariable Long id, HttpServletRequest request){

        boolean resposta = service.movimentarEstoque(dto, id, request);

        if (resposta){
            return "redirect:/listaestoque";
        }
        return "redirect:/listaestoque?erro";
    }

    @GetMapping("/historicoestoque/{id}")
    public String viewHistorico(Model model, @PathVariable Long id){

        List<EstoqueDto> lista = service.retornarLista(id);

        model.addAttribute("listahistorico", lista);
        return "/historicoestoque";
    }
}
