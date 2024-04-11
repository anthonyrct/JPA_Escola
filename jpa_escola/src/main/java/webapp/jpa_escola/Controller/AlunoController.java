package webapp.jpa_escola.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import webapp.jpa_escola.Model.Aluno;
import webapp.jpa_escola.Repository.AlunoRepository;
import webapp.jpa_escola.Repository.VerificaCadastroAlunoRepository;

@Controller
public class AlunoController {

    @Autowired
    AlunoRepository ar;

    @Autowired
    VerificaCadastroAlunoRepository vcar;

    boolean acessoInternoAluno = false;

    @PostMapping("acesso-aluno")
    public ModelAndView acessoAlunoLogin(@RequestParam String cpf, @RequestParam String senha,
            RedirectAttributes attributes) {
        ModelAndView mv = new ModelAndView("redirect:/interna-adm");
        try {
            boolean acessoCPF = ar.existsById(cpf);
            boolean acessoSenha = senha.equals(ar.findByCpf(cpf).getCpf());
            if (acessoCPF && acessoSenha) {
                acessoInternoAluno = true;
            } else {
                String mensagem = "Login Não Efetuado";
                System.out.println(mensagem);
                attributes.addFlashAttribute("msg", mensagem);
                attributes.addFlashAttribute("classe", "vermelho");
                mv.setViewName("redirect:/login-aluno");
            }
            return mv;
        } catch (Exception e) {
            String mensagem = "Login Não Efetuado";
            System.out.println(mensagem);
            attributes.addFlashAttribute("msg", mensagem);
            attributes.addFlashAttribute("classe", "vermelho");
            mv.setViewName("redirect:/login-adm");
            return mv;
        }
    }

    @PostMapping("logout-aluno")
    public ModelAndView logoutAluno(RedirectAttributes attributes) {
        ModelAndView mv = new ModelAndView("redirect:/interna-aluno");
        attributes.addFlashAttribute("msg", "Logout Efetuado");
        attributes.addFlashAttribute("classe", "verde");
        acessoInternoAluno = false;
        return mv;
    }
}
