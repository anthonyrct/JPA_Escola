package webapp.jpa_escola.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import webapp.jpa_escola.Model.Professor;
import webapp.jpa_escola.Repository.ProfessorRepository;

@Controller
public class ProfessorController {
    
    @Autowired
    ProfessorRepository ar;

    boolean acessoInternoProfessor = false;

    @PostMapping("acesso-professor")
    public ModelAndView acessoprofessorLogin(@RequestParam String emailEscolar, @RequestParam String senha,
            RedirectAttributes attributes) {
        ModelAndView mv = new ModelAndView("redirect:/interna-professor");
        try {
            boolean acessoemailEscolar = ar.existsById(emailEscolar);
            boolean acessoSenha = senha.equals(ar.findByEmailEscolar(emailEscolar).getSenha());
            if (acessoemailEscolar && acessoSenha) {
                acessoInternoProfessor = true;
            } else {
                String mensagem = "Login Não Efetuado";
                System.out.println(mensagem);
                attributes.addFlashAttribute("msg", mensagem);
                attributes.addFlashAttribute("classe", "vermelho");
                mv.setViewName("redirect:/login-professor");
            }
            return mv;
        } catch (Exception e) {
            String mensagem = "Login Não Efetuado";
            System.out.println(mensagem);
            attributes.addFlashAttribute("msg", mensagem);
            attributes.addFlashAttribute("classe", "vermelho");
            mv.setViewName("redirect:/login-professor");
            return mv;
        }
    }


    @GetMapping("/interna-professor")
    public ModelAndView acessoPageInternaprofessor(RedirectAttributes attributes) {
        ModelAndView mv = new ModelAndView("interna/interna-professor");
        if (acessoInternoProfessor) {
            System.out.println("Acesso Permitido");
        } else {
            String mensagem = "Acesso não Permitido - faça Login";
            System.out.println(mensagem);
            mv.setViewName("redirect:/login-adm");
            attributes.addFlashAttribute("msg", mensagem);
            attributes.addFlashAttribute("classe", "vermelho");
        }
        return mv;
    }

    @PostMapping("logout-professor")
    public ModelAndView logoutprofessor(RedirectAttributes attributes) {
        ModelAndView mv = new ModelAndView("redirect:/interna-professor");
        attributes.addFlashAttribute("msg", "Logout Efetuado");
        attributes.addFlashAttribute("classe", "verde");
        acessoInternoProfessor = false;
        return mv;
    }
}
