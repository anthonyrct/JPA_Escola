package webapp.jpa_escola.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class IndexController {

    
    @GetMapping("/home")
    public String acessoHomePage() {
        return "index";
    }

    @GetMapping("/login-adm")
    public String acessoPageLoginAdm() {
        return "login/login-adm";
    }

    @GetMapping("/cadastro-adm")
    public String acessoPageCadastroAdm() {
        return "cadastro/cadastro-adm";
    }

    @GetMapping("/login-professor")
    public String acessoPageLoginProf() {
        return "login/login-professor";
    }

    @GetMapping("/cadastro-professor")
    public String acessoPageCadastroProf(){
        return "cadastro/cadastro-professor";
    }

    @GetMapping("/login-aluno")
    public String acessoPageLoginAluno() {
        return "login/login-aluno";
    }

    @GetMapping("/cadastro-aluno")
    public String acessoPageCadastroAluno() {
        return "cadastro/cadastro-aluno";
    }
    
    
    
    
    

    
    

}
