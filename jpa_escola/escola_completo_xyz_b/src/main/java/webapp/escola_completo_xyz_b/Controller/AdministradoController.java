package webapp.escola_completo_xyz_b.Controller;

import javax.swing.text.StyledEditorKit.BoldAction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import webapp.escola_completo_xyz_b.Model.Administrador;
import webapp.escola_completo_xyz_b.Respository.AdministradorRepository;
import webapp.escola_completo_xyz_b.Respository.VerificaCadastroAdmRepository;


@Controller
public class AdministradoController {
    @Autowired
    AdministradorRepository ar;

    @Autowired
    VerificaCadastroAdmRepository vcar;

    @PostMapping("cadastrar-adm")
    public String cadastrarAdmBD(Administrador Adm) {
        Boolean VerificaCpf = vcar.existsById(Adm.getCpf());
        if (VerificaCpf) {
            ar.save(Adm);
            System.out.println("Cadastro Realizado com sucesso");
        } else{
            System.out.println("Falha ao Cadastrar");
        }
        return "/login/login-adm";
    }

    @PostMapping("acesso-adm")
    public String postMethodName(@RequestBody String entity) {
        //metodo para verificar o acesso
        
        return entity;
    }
    
    
}
