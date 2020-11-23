package br.com.unesa.model;

/**
 *
 * @author Jonas Silva Carvalho<jonasloop1@gmail.com>
 * @author Gabriel Henrique Santos Marques<gabrielmarques142@gmail.com>
 * @author Marlon Ribeiro da Silva<marlonribeirodasilva@outlook.com.br>
 * @brief Classe que guarda dados do usuário.
 * @date 23/11/2020.
 */
public class Cliente {

    public int id;
    public String cpf;
    public String nome;
    public String idade;
    public String email;
    public String telefone;

    public Cliente(){
    
    }
    
    public Cliente(int id, String cpf, String nome, String idade, String email, String telefone) {
        
        this.id = id;
        this.cpf = cpf;
        this.nome = nome;
        this.idade = idade;
        this.email = email;
        this.telefone = telefone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

}
