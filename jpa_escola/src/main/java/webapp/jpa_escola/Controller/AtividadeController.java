import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import webapp.jpa_escola.Model.Atividade;
import webapp.jpa_escola.Service.AtividadeService; // Certifique-se de importar o pacote correto para o serviço

@Controller
public class AtividadeController {

    @Autowired
    private AtividadeService atividadeService;

    @PostMapping("/enviar-atividade")
    public String enviarAtividade(@RequestParam String titulo, @RequestParam String descricao,
            @RequestParam Date dataDeVencimento) {
        Atividade atividade = new Atividade();
        atividade.setTitulo(titulo);
        atividade.setDescricao(descricao);
        atividade.setDataDeVencimento(dataDeVencimento);

        atividadeService.salvar(atividade);

        return "redirect:/pagina-de-sucesso"; // redirecionar para uma página de sucesso após o envio
    }


    
}
