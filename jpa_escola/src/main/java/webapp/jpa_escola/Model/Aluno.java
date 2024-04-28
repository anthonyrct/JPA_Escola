package webapp.jpa_escola.Model;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
@Entity
public class Aluno implements Serializable {

    // atributos
    @Id
    private String ra;
    private String nome;
    private String email;
    private double nota;
    private String senha;
    private String docente;
    

    public String getRa() {
        return ra;
    }

    public void setRa(String ra) {
        this.ra = ra;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getDocente() {
        return docente;
    }

    public void setDocente(String docente) {
        this.docente = docente;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

}
