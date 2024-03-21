// package webapp.jpa_escola;

// import org.hibernate.mapping.List;
// import org.springframework.data.jpa.repository.Query;
// import org.springframework.data.repository.CrudRepository;
// import java.util.List;

// import Model.Professor;

// public class FuncionarioRepository extends CrudRepository<Professor, Long> {
// Professor findById(long id);
// Professor findBySenha(long senha);
// Professor findByCpf(long cpf);
// Professor findByNome(String nome);

// @Query(value = "select u from Professor u where u.nome like %?1%")
// List<Funcionario> findByNomes(String nome);
// }
