package webapp.jpa_escola.Repository;

import org.springframework.data.repository.CrudRepository;

import webapp.jpa_escola.Model.VerificaCadastroAdm;
import java.util.List;

public interface VerificaCadastroAdmRepository extends CrudRepository<VerificaCadastroAdm, String> {
    VerificaCadastroAdm findByCpf(String cpf);
}
