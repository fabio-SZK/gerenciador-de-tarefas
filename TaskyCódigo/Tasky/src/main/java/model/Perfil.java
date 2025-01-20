package model;

public class Perfil {
    private String nome;
    private String descricao;
    private String funcao;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    
    
    public void alterarPerfil() {
        // Implementação aqui
    }

    public void visualizarPerfil() {
        // Implementação aqui
    }
}

// Classe Usuario
class Usuario {
    private int idUsuario;
    private String nome;
    private String senha;
    private String login;
    private String email;

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    

    public void criarUsuario() {
        // Implementação aqui
    }

    public void deletarUsuario() {
        // Implementação aqui
    }

    public void fazerLogin() {
        // Implementação aqui
    }
}
