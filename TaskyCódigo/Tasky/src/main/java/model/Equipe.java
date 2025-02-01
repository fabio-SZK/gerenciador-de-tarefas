package model;

import java.util.ArrayList;
import java.util.List;



public class Equipe {
    private int idEquipe;
    private Usuario liderEquipe;
    private String areaAtuacao;
    private String descricao;
    private String funcao;
    
    private Projeto projeto;
    private List<Usuario> membros;
    private List<Tarefa> listaTarefasEquipe;

    public Equipe(int idEquipe, Usuario liderEquipe, String areaAtuacao, String descricao, String funcao, Projeto projeto, List<Usuario> membros, List<Tarefa> listaTarefasEquipe) {
        this.idEquipe = idEquipe;
        this.liderEquipe = liderEquipe;
        this.areaAtuacao = areaAtuacao;
        this.descricao = descricao;
        this.funcao = funcao;
        this.projeto = projeto;
        this.membros = membros;
        this.listaTarefasEquipe = listaTarefasEquipe;
    }

    public Equipe(int idEquipe, Usuario liderEquipe, String areaAtuacao, String descricao, String funcao, Projeto projeto) {
        this.idEquipe = idEquipe;
        this.liderEquipe = liderEquipe;
        this.areaAtuacao = areaAtuacao;
        this.descricao = descricao;
        this.funcao = funcao;
        this.projeto = projeto;
        this.membros = new ArrayList<>();
        this.listaTarefasEquipe = new ArrayList<>();
    }
    
    

    public Equipe() {
        idEquipe = 0;
        liderEquipe = new Usuario();
        areaAtuacao = "";
        descricao = "";
        funcao = "";
        projeto = new Projeto();
        membros = new ArrayList<>();
        this.listaTarefasEquipe = new ArrayList<>();
    }
    
    
    
    public Usuario getLiderEquipe() {
        return liderEquipe;
    }

    public void setLiderEquipe(Usuario liderEquipe) {
        this.liderEquipe = liderEquipe;
    }

    public String getAreaAtuacao() {
        return areaAtuacao;
    }

    public void setAreaAtuacao(String areaAtuacao) {
        this.areaAtuacao = areaAtuacao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getIdEquipe() {
        return idEquipe;
    }

    public void setIdEquipe(int idEquipe) {
        this.idEquipe = idEquipe;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public Projeto getProjeto() {
        return projeto;
    }

    public void setProjeto(Projeto projeto) {
        this.projeto = projeto;
    }

    public List<Usuario> getMembros() {
        return membros;
    }

    public void setMembros(List<Usuario> membros) {
        this.membros = membros;
    }

    public List<Tarefa> getListaTarefasEquipe() {
        return listaTarefasEquipe;
    }

    public void setListaTarefasEquipe(List<Tarefa> listaTarefasEquipe) {
        this.listaTarefasEquipe = listaTarefasEquipe;
    }

    
    public void criarEquipe() {
        // Implementação aqui
    }

    public void consultarEquipe() {
        // Implementação aqui
    }

    public void deletarEquipe() {
        // Implementação aqui
    }

    public void alterarEquipe() {
        // Implementação aqui
    }

    public void definirLider() {
        // Implementação aqui
    }

    public void listarEquipe() {
        // Implementação aqui
    }
}