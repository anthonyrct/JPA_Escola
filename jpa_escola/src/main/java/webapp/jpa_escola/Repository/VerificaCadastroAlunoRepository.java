package webapp.jpa_escola.Repository;

import org.springframework.data.repository.CrudRepository;

public interface VerificaCadastroAlunoRepository extends CrudRepository<VerificaCadastroAlunoRepository, String>{
    VerificaCadastroAlunoRepository findByCpf(String cpf);
}
