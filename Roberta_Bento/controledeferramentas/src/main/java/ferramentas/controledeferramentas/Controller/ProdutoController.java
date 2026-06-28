package ferramentas.controledeferramentas.Controller;

import ferramentas.controledeferramentas.Dtos.ProdutoDto;
import ferramentas.controledeferramentas.Service.ProdutoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ProdutoController {

    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @GetMapping("/listaproduto")
    public String viewLista(Model model){

        List<ProdutoDto> lista = produtoService.listarProduto();

        model.addAttribute("listaproduto", lista);

        return "listaproduto";
    }

    @GetMapping("/cadastroproduto")
    public String viewProduto(Model model){

        ProdutoDto dto = new ProdutoDto();

        model.addAttribute("ProdutoDto", dto);
        return "cadastroproduto";
    }

    @PostMapping("/cadastroproduto")
    public String cadastrarProduto(@ModelAttribute("ProdutoDto")ProdutoDto dto){

        produtoService.cadastrarProduto(dto);

        return "redirect:/listaproduto";
    }
    @GetMapping("/alterarproduto/{id}")
    public String viewAlterarProduto(Model model, @PathVariable Long id){

        ProdutoDto dto = produtoService.encontrarProduto(id);

        if (dto == null){

            return "redirect:/listaproduto?erro";
        }

        model.addAttribute("ProdutoDto", dto);
        return "alterarproduto";
    }

    @PostMapping("/alterarproduto/{id}")
    public String alterarProduto(@ModelAttribute("ProdutoDto") ProdutoDto dto, @PathVariable Long id){

        boolean resposta = produtoService.alterarProduto(dto, id);

        if (resposta){
            return "redirect:/listaproduto";
        }
        return "redirect:/istaproduto?erro";
    }
}
