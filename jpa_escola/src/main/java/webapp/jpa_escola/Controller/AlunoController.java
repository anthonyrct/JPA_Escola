package webapp.jpa_escola.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import webapp.jpa_escola.Model.Administrador;
import webapp.jpa_escola.Model.Aluno;
import webapp.jpa_escola.Repository.AlunoRepository;


@Controller
public class AlunoController {

    @Autowired
    AlunoRepository ar;

     @Autowired
    findByRa  Vr;

    boolean acessoInternoAluno = false;

    @PostMapping("cadastrar-aluno")
    public ModelAndView cadastroAdmBD(Aluno aluno, RedirectAttributes attributes) {

        boolean verificaRa = Vr.existsByRa(aluno.getRa());

        ModelAndView mv = new ModelAndView("redirect:/login-aluno");

        if (verificaRa) {
            ar.save(aluno);
            String mensagem = "Cadastro Realizado com sucesso";
            System.out.println(mensagem);
            attributes.addFlashAttribute("msg", mensagem);
            attributes.addFlashAttribute("classe", "vermelho");
        } else {
            String mensagem = "Cadastro Não Realizado";
            System.out.println(mensagem);
            attributes.addFlashAttribute("msg", mensagem);
            attributes.addFlashAttribute("classe", "vermelho");
        }

        return mv;
    }

    @PostMapping("acesso-aluno")
    public ModelAndView acessoAlunoLogin(@RequestParam String ra, @RequestParam String senha,
            RedirectAttributes attributes) {
        ModelAndView mv = new ModelAndView("redirect:/interna-aluno");
        try {
            boolean acessoRA = ar.existsById(ra);
            boolean acessoSenha = senha.equals(ar.findByRa(ra).getRa());
            if (acessoRA && acessoSenha) {
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
            mv.setViewName("redirect:/login-aluno");
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
