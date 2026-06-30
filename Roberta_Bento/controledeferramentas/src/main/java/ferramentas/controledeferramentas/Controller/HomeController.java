package ferramentas.controledeferramentas.Controller;

import ferramentas.controledeferramentas.Dtos.LoginSessaoDto;
import ferramentas.controledeferramentas.Sessao.ControleSessao;
import jakarta.servlet.http.HttpServletRequest;
import jdk.dynalink.beans.StaticClass;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.Stack;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String viewHome(HttpServletRequest request, Model model){

        LoginSessaoDto dto = ControleSessao.obter(request);
        model.addAttribute("nome", dto.getNome());

        return "/home";
    }
}
