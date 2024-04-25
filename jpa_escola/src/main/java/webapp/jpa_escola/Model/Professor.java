package webapp.jpa_escola.Model;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
@Entity
public class Professor implements Serializable {
    // atributos
    @Id
    private String emailEscolar;
    private String nome;
    private String senha;
    private String nome_aluno;
    private String materia;

    // metodos

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmailEscolar() {
        return emailEscolar;
    }

    public void setEmailEscolar(String emailEscolar) {
        this.emailEscolar = emailEscolar;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome_aluno() {
        return nome_aluno;
    }

    public void setNome_aluno(String nome_aluno) {
        this.nome_aluno = nome_aluno;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

}
