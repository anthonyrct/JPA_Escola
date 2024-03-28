package webapp.escola_completo_xyz_b.Respository;

import org.springframework.data.repository.CrudRepository;

import webapp.escola_completo_xyz_b.Model.VerificaCadastroAdm;

public interface VerificaCadastroAdmRepository extends CrudRepository<VerificaCadastroAdm,String>  {
    VerificaCadastroAdm findByCpf(String cpf);

    
}
