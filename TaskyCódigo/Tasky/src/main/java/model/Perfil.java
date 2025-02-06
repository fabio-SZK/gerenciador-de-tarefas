package model;

public class Perfil {
    private Integer idPerfil;
    private String nome;
    private String descricao;
    private String funcao;
    private Usuario usuario;

    public Perfil(Integer idPerfil, String nome, String descricao, String funcao, Usuario usuario) {
        this.idPerfil = idPerfil;
        this.nome = nome;
        this.descricao = descricao;
        this.funcao = funcao;
        this.usuario = usuario;
    }

    public Perfil(){
        this.idPerfil = null;
        this.nome = "";
        this.descricao = "";
        this.funcao = "";
        this.usuario = null;
    }
   
    public int getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(Integer idPerfil) {
        this.idPerfil = idPerfil;
    }

    
    
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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    
    
    public void alterarPerfil() {
        // Implementação aqui
    }

    public void visualizarPerfil() {
        // Implementação aqui
    }
}



