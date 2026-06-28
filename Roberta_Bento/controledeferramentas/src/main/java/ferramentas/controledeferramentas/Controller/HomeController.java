package ferramentas.controledeferramentas.Controller;

import jdk.dynalink.beans.StaticClass;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Stack;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String viewHome(){

        return "/home";
    }
}
