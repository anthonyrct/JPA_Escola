package webapp.jpa_escola.Repository;

import org.springframework.data.repository.CrudRepository;

import webapp.jpa_escola.Model.Administrador;

public interface AdministradorRepository extends CrudRepository<Administrador, String> {
    // se eu precisar criar algum método extra eu vou criar aqui

    Administrador findByCpf(String cpf);
}