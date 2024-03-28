package webapp.escola_completo_xyz_b.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class indexController {
    @GetMapping("/home")
    public String acessoHomePage() {
        return "index";
    }

    @GetMapping("/login-adm")
    public String acessoPageLoginAdm() {
        return "login/login-adm";
    }

    @GetMapping("/cadastro-adm")
    public String acesspPageCadastroAdm() {
        return "cadastro/cadastro-adm";
    }
    
    
    
}
