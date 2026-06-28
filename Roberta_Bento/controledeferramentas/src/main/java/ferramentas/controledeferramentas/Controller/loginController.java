package ferramentas.controledeferramentas.Controller;

import ferramentas.controledeferramentas.Dtos.LoginDto;
import ferramentas.controledeferramentas.Dtos.UsuarioDto;
import ferramentas.controledeferramentas.Service.LoginService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class loginController {

    LoginService service;

    public loginController(LoginService service) {
        this.service = service;
    }

    @GetMapping("/login")
    public String viewLogin(Model model){

        LoginDto dto = new LoginDto();
        model.addAttribute("loginDto", dto);

        return "login";
    }

    @PostMapping("/login")
    public String validarLogin(@ModelAttribute("loginDto") LoginDto dto){

        boolean resposta = service.validarLogin(dto);

        if (resposta){
            return "redirect:/home";
        }
        return "redirect:/login?erro";

    }

    @GetMapping("cadastrarusuario")
    public String viewCdastroUsuario(Model model){

        UsuarioDto dto = new UsuarioDto();

        model.addAttribute("UsuarioDto", dto);

        return "/cadastrarusuario";
    }

    @PostMapping("cadastrarusuario")
    public String cadastrarUsuario(@ModelAttribute("UsuarioDto") UsuarioDto dto){

        if (service.cadastrarUsuario(dto)){

            return "redirect:/login";
        }
        return "redirect:/cadastrarusuario?erro";
    }
}
